package server;

import ansAndRes.Res;
import classes.StudyGroup;
import command.CommandMang;
import command.SaveCommand;
import datas.ReadCsv;
import mainProgram.Main;
import statics.Static;

import java.io.*;
import java.net.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMng {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static int port = 1100;

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(port);
        Main mainProgram = new Main();
        LinkedHashSet<StudyGroup> mySet = mainProgram.main();
        CommandMang cmd = new CommandMang();

        new Thread(() -> {mainProgram.savecmd(mySet);}).start();

        while (true) {
            byte[] receiveData = new byte[9999];
            byte[] sendData;

            //give
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            byte[] data = receivePacket.getData();
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);

            Res request = (Res) is.readObject();

            //getting
            String sentence = new String(request.getResText().getBytes(), 0, request.getResText().getBytes().length);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            //print a getting from client
            System.out.println("Client " + receivePacket.getAddress() + " send: " + sentence);

            //MainProgramController
            Res result = null;
            result = cmd.mng(request.getResText(), mySet);
            if (result != null) {
                Static.history.add(request.getResText().split(" ")[0]);
            }else{
                result = new Res("Команда введена не правильно", false);
            }

            //send a Answer
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(result);

            sendData = outputStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);

            result = null;
            request = null;
        }
    }
}