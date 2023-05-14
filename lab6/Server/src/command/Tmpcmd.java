package command;

import ansAndRes.Res;
import classes.StudyGroup;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.LinkedHashSet;

public class Tmpcmd {
    public Res updateId(Res request, DatagramSocket serverSocket, LinkedHashSet<StudyGroup> mySet, byte[] receiveData, InetAddress IPAddress, int port, byte[] sendData) throws IOException, ClassNotFoundException {
        //getting
        String sentence = new String(request.getResText().getBytes(), 0, request.getResText().getBytes().length);
        boolean b = false;
        String[] idS = sentence.split(" ");
        int id = Integer.parseInt(idS[1]);

        if(mySet.stream().map(p -> p.getId() == id).count() == 1){
            b = true;
        }

        Res newRes = new Res(sentence, b);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(outputStream);
        os.writeObject(newRes);

        System.out.println(newRes.getResText());

        sendData = outputStream.toByteArray();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        byte[] data = receivePacket.getData();
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);

        request = (Res) is.readObject();
        return request;
    }
}
