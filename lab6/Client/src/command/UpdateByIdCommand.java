package command;

import ansAndRes.Res;
import classes.Coordinates;
import classes.Person;
import classes.StudyGroup;
import enums.Color;
import enums.Country;
import enums.FormOfEducation;
import enums.Semester;
import statics.Static;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;


public class UpdateByIdCommand {

    public Res doo(String s, DatagramChannel channel, byte[] sendData, byte[] receiveData, String IPAddress, int port) throws IOException, ClassNotFoundException, InterruptedException {
        Res res = null;
        String name = null;
        int x = 0;
        int y = 0;
        int studentCount = 0;
        String perName = null;
        Float weight = 0f;
        Color eyeColor = null;
        Color hairColor = null;
        Country nationality = null;
        FormOfEducation form = null;
        Semester sm = null;
        boolean b = false;

        if (!b) {
            Res req = new Res(s + " tmp", false);
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
                if(request.isSuccess() == true){
                    b = true;
                }
            }else if(System.currentTimeMillis() - startTime > 10000){
                System.out.println("Server no response!");
            }
        }

        if (b) {
            Scanner line = new Scanner(System.in);
            Static.txt("Введите название Группы:");
            while (name == null) {
                System.out.print(">>> ");
                String tmpName = line.nextLine();
                if (tmpName.length() > 0 && !tmpName.contains("\"") && !tmpName.contains(" ")) {
                    name = tmpName;
                    Static.txt("Название добавлено!");
                } else {
                    Static.txt("Название не корректно!\nВведите заново!");
                }
            }

            while (x == 0) {
                Static.txt("Координаты x:");
                System.out.print(">>> ");
                String xY = line.nextLine();
                try {
                    int tmpX = Integer.parseInt(xY);
                    if (tmpX <= 146) {
                        x = tmpX;
                        Static.txt("Координаты х  добавлены!");
                    } else {
                        Static.txt("Максимальное значение поля: 146!");
                    }
                } catch (Exception e) {
                    Static.txt("Ошибка формата!");
                }
            }

            while (y == 0) {
                Static.txt("Координаты y:");
                System.out.print(">>> ");
                String xY = line.nextLine();
                try {
                    int tmpY = Integer.parseInt(xY);
                    if (tmpY <= 146) {
                        y = tmpY;
                        Static.txt("Координаты y  добавлены!");
                    } else {
                        Static.txt("Максимальное значение поля: 146!");
                    }
                } catch (Exception e) {
                    Static.txt("Ошибка формата!");
                }
            }

            while (studentCount == 0) {
                Static.txt("Количество студентов:");
                System.out.print(">>> ");
                try {
                    int tmpStCnt = Integer.parseInt(line.nextLine());
                    if (tmpStCnt > 0) {
                        studentCount = tmpStCnt;
                        Static.txt("Количество студентов добавлено!");
                    } else {
                        Static.txt("Количество студентов должно бить больше 0!");
                    }
                } catch (Exception e) {
                    Static.txt("Ошибка формата!");
                }
            }

            while (form == null) {
                Static.txt("Формат Обучения:\nDISTANCE_EDUCATION\nFULL_TIME_EDUCATION\nEVENING_CLASSES");
                System.out.print(">>> ");
                String tmpFormm = line.nextLine();
                try {
                    form = FormOfEducation.valueOf(tmpFormm.toUpperCase());
                    Static.txt("Формат Обучения добавлено!");
                } catch (Exception e) {
                    Static.txt("Ошибка Формата!");
                }
            }

            while (sm == null) {
                Static.txt("Формат Семестра:");
                for (Enum ss : Semester.values()) {
                    Static.txt(ss.name());
                }
                System.out.print(">>> ");
                String tmpForm = line.nextLine();
                try {
                    sm = Semester.valueOf(tmpForm.toUpperCase());
                    Static.txt("Формат Семестра добавлено!");
                } catch (Exception e) {
                    Static.txt("Ошибка Формата!");
                }
            }

            Static.txt("Добавить Старосту:");
            Static.txt("Введите имя Старосты:");
            while (perName == null) {
                System.out.print(">>> ");
                String tmpName = line.nextLine();
                if (tmpName.length() > 0 && !tmpName.contains("\"")) {
                    perName = tmpName;
                    Static.txt("Имя старосты добавлено!");
                } else {
                    Static.txt("Имя не корректно!\nВведите заново!");
                }
            }

            while (weight == 0) {
                Static.txt("Рост старости:");
                System.out.print(">>> ");
                try {
                    String tmpStCntt = line.nextLine();
                    Float tmpStCnt = Float.parseFloat(tmpStCntt);
                    if (tmpStCnt > 0) {
                        weight = tmpStCnt;
                        Static.txt("Рост старости добавлено!");
                    } else {
                        Static.txt("Рост старости должно бить больше 0!");
                    }
                } catch (Exception e) {
                    Static.txt("Ошибка формата!");
                }
            }

            while (eyeColor == null) {
                Static.txt("Цвет глаз:");
                for (Enum ss : Color.values()) {
                    Static.txt(ss.name());
                }
                System.out.print(">>> ");
                String tmpForm = line.nextLine();
                try {
                    eyeColor = Color.valueOf(tmpForm.toUpperCase());
                    Static.txt("Цвет глаз добавлено!");
                } catch (Exception e) {
                    Static.txt("Ошибка Формата!");
                }
            }

            while (hairColor == null) {
                Static.txt("Цвет волос:");
                for (Enum ss : Color.values()) {
                    Static.txt(ss.name());
                }
                System.out.print(">>> ");
                String tmpForm = line.nextLine();
                try {
                    hairColor = Color.valueOf(tmpForm.toUpperCase());
                    Static.txt("Цвет волос добавлено!");
                } catch (Exception e) {
                    Static.txt("Ошибка Формата!");
                }
            }

            while (nationality == null) {
                Static.txt("Национальность:");
                for (Enum ss : Country.values()) {
                    Static.txt(ss.name());
                }
                System.out.print(">>> ");
                String tmpForm = line.nextLine();
                try {
                    nationality = Country.valueOf(tmpForm.toUpperCase());
                    Static.txt("Национальность добавлено!");
                } catch (Exception e) {
                    Static.txt("Ошибка Формата!");
                }
            }

            try {
                Coordinates cr = new Coordinates(x, y);
                Person groepAdmiiin = new Person(perName, weight, eyeColor, hairColor, nationality);
                StudyGroup stdTmp = new StudyGroup(name, cr, studentCount, form, sm, groepAdmiiin);
                return new Res(stdTmp.toStringCSV(), true);
            } catch (Exception e) {
                return new Res("Ошибка добавления!", false);
            }
        }
        return new Res("Нету такого Элемента!", false);
    }

    public String des(){
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
