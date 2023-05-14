package client;

import ansAndRes.Res;
import command.AddCommand;
import command.UpdateByIdCommand;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientMng {

    private static int port = 1100;
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData;
        byte[] receiveData = new byte[2048];

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

                }
                else if(sentence.split(" ")[0].equals("update")){
                    UpdateByIdCommand ad = new UpdateByIdCommand();
                    req = ad.doo();
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
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                clientSocket.send(sendPacket);

                //give Answers
                clientSocket.setSoTimeout(10000);
                try {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    clientSocket.receive(receivePacket);
                    byte[] data = receivePacket.getData();
                    ByteArrayInputStream in = new ByteArrayInputStream(data);
                    ObjectInputStream is = new ObjectInputStream(in);

                    Res request = (Res) is.readObject();

                    ///print a answer
                    String modifiedSentence = new String(request.getResText().getBytes(), 0, request.getResText().getBytes().length);
                    System.out.println(modifiedSentence);
                } catch (SocketTimeoutException e) {
                    System.out.println("Server not Answered!");
                }
            }
        }
    }
}