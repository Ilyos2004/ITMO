package client;

import ansAndRes.Res;
import command.AddCommand;
import command.ExecuteScriptCommand;
import command.UpdateByIdCommand;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class ClientMng {

    private static int port = 1100;
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        DatagramChannel channel = DatagramChannel.open();
        channel.configureBlocking(false);
        String host = "localhost";
        int port = 1100;
        channel.connect(new InetSocketAddress(host, port));
        byte[] sendData = new byte[9999];
        byte[] receiveData = new byte[9999];

        Scanner scanner = new Scanner(System.in);
        String sentence;

        while (true) {
            //input
            System.out.print(">>> ");
            sentence = scanner.nextLine();
            Res req = null;
            if(sentence.equals("exit")){
                return;
            }else {
                if (sentence.split(" ")[0].equals("add")){
                    AddCommand ad = new AddCommand();
                    req = ad.doo();
                    req.setResText("add " + req.getResText());
                }else if(sentence.split(" ")[0].equals("execute_script")){
                    ExecuteScriptCommand ex = new ExecuteScriptCommand();
                    String allRequest = ex.doo(sentence);
                    req = new Res("execute_script " + allRequest, true);
                }
                else if(sentence.split(" ").length >= 2 && sentence.split(" ")[0].equals("update")){
                    UpdateByIdCommand ad = new UpdateByIdCommand();
                    req = ad.doo(sentence, channel, sendData, receiveData, host, port);
                    req.setResText(sentence + " " + req.getResText());
                }
                else {
                    //ser
                    req = new Res(sentence.toString(), true);
                }
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(req);

                //sending
                sendData = outputStream.toByteArray();
                ByteBuffer buffer = ByteBuffer.wrap(sendData);
                channel.write(buffer);
                ByteBuffer responseBuffer = ByteBuffer.allocate(9999);

                //give Answers
                long startTime = System.currentTimeMillis();
                responseBuffer.clear();
                SocketAddress responder = channel.receive(responseBuffer);

                if(responder != null){
                    responseBuffer.flip();
                    byte[] responseBytes = new byte[responseBuffer.remaining()];
                    responseBuffer.get(responseBytes);
                    ByteArrayInputStream in = new ByteArrayInputStream(responseBytes);
                    ObjectInputStream is = new ObjectInputStream(in);
                    Res request = (Res) is.readObject();
                    ///print a answer
                    String modifiedSentence = new String(request.getResText().getBytes(), 0, request.getResText().getBytes().length);
                    System.out.println(modifiedSentence);
                }else if(System.currentTimeMillis() - startTime > 10000){
                    System.out.println("Server no response!");
                }
            }
        }
    }
}