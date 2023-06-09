package mainProgram;

import classes.StudyGroup;
import datas.ReadCsv;
import statics.Static;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedHashSet<StudyGroup> mySet = new LinkedHashSet<>();
        Static.filename = "Datas/" + System.getenv("BD");


        ReadCsv csvRd = new ReadCsv();
        try {
            mySet = csvRd.readCsv();
            Static.txt("Коллекция успешно заполнено с файла!");
            System.out.print(">>> ");
        }catch (Exception e){
            Static.txt("Ошибка Файла!");
        }

        //CommandMang cmd = new CommandMang();

        try (Scanner reader = new Scanner(System.in)) {
            String line;
            while (!(line = reader.nextLine()).equals("exit")) {
                try {
                    //cmd.mng(line, mySet);
                    System.out.print(">>> ");
                    Static.history.add(line.split(" ")[0]);
                }catch (Exception e){
                    System.out.println("Команда введена не правильно");
                    System.out.print(">>> ");
                    continue;
                }
            }
        }

    }
}