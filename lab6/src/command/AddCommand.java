package command;

import classes.Coordinates;
import classes.Person;
import classes.StudyGroup;
import enums.Color;
import enums.Country;
import enums.FormOfEducation;
import enums.Semester;
import statics.Static;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class AddCommand extends AbsCommand{

    public AddCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String args, LinkedHashSet<StudyGroup> mySet){
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

        Scanner line = new Scanner(System.in);
        Static.txt("Введите название Группы:");
        while(name == null){
            System.out.print(">>> ");
            String tmpName = line.nextLine();
            if(tmpName.length() > 0 && !tmpName.contains("\"") && !tmpName.contains(" ")){
                name = tmpName;
                Static.txt("Название добавлено!");
            }else{
                Static.txt("Название не корректно!\nВведите заново!");
            }
        }

        while (x == 0){
            Static.txt("Координаты x:");
            System.out.print(">>> ");
            String xY = line.nextLine();
            try {
                int tmpX = Integer.parseInt(xY);
                if(tmpX <= 146){
                    x = tmpX;
                    Static.txt("Координаты х  добавлены!");
                }else{
                    Static.txt("Максимальное значение поля: 146!");
                }
            } catch (Exception e) {
                Static.txt("Ошибка формата!");
            }
        }

        while (y == 0){
            Static.txt("Координаты y:");
            System.out.print(">>> ");
            String xY = line.nextLine();
            try {
                int tmpY = Integer.parseInt(xY);
                if(tmpY <= 146){
                    y = tmpY;
                    Static.txt("Координаты y  добавлены!");
                }else{
                    Static.txt("Максимальное значение поля: 146!");
                }
            } catch (Exception e) {
                Static.txt("Ошибка формата!");
            }
        }

        while (studentCount == 0){
            Static.txt("Количество студентов:");
            System.out.print(">>> ");
            try {
                int tmpStCnt = Integer.parseInt(line.nextLine());
                if(tmpStCnt > 0){
                    studentCount = tmpStCnt;
                    Static.txt("Количество студентов добавлено!");
                }else{
                    Static.txt("Количество студентов должно бить больше 0!");
                }
            }catch (Exception e){
                Static.txt("Ошибка формата!");
            }
        }

        while (form == null){
            Static.txt("Формат Обучения:\nDISTANCE_EDUCATION\nFULL_TIME_EDUCATION\nEVENING_CLASSES");
            System.out.print(">>> ");
            String tmpFormm = line.nextLine();
            try {
                form = FormOfEducation.valueOf(tmpFormm.toUpperCase());
                Static.txt("Формат Обучения добавлено!");
            }catch (Exception e){
                Static.txt("Ошибка Формата!");
            }
        }

        while (sm == null){
            Static.txt("Формат Семестра:");
            for(Enum s: Semester.values()){
                Static.txt(s.name());
            }
            System.out.print(">>> ");
            String tmpForm = line.nextLine();
            try {
                sm = Semester.valueOf(tmpForm.toUpperCase());
                Static.txt("Формат Семестра добавлено!");
            }catch (Exception e){
                Static.txt("Ошибка Формата!");
            }
        }

        Static.txt("Добавить Старосту:");
        Static.txt("Введите имя Старосты:");
        while(perName == null){
            System.out.print(">>> ");
            String tmpName = line.nextLine();
            if(tmpName.length() > 0 && !tmpName.contains("\"")){
                perName = tmpName;
                Static.txt("Имя старосты добавлено!");
            }else{
                Static.txt("Имя не корректно!\nВведите заново!");
            }
        }

        while (weight == 0){
            Static.txt("Рост старости:");
            System.out.print(">>> ");
            try {
                String tmpStCntt = line.nextLine();
                Float tmpStCnt = Float.parseFloat(tmpStCntt);
                if(tmpStCnt > 0){
                    weight = tmpStCnt;
                    Static.txt("Рост старости добавлено!");
                }else{
                    Static.txt("Рост старости должно бить больше 0!");
                }
            }catch (Exception e){
                Static.txt("Ошибка формата!");
            }
        }

        while (eyeColor == null){
            Static.txt("Цвет глаз:");
            for(Enum s: Color.values()){
                Static.txt(s.name());
            }
            System.out.print(">>> ");
            String tmpForm = line.nextLine();
            try {
                eyeColor = Color.valueOf(tmpForm.toUpperCase());
                Static.txt("Цвет глаз добавлено!");
            }catch (Exception e){
                Static.txt("Ошибка Формата!");
            }
        }

        while (hairColor == null){
            Static.txt("Цвет волос:");
            for(Enum s: Color.values()){
                Static.txt(s.name());
            }
            System.out.print(">>> ");
            String tmpForm = line.nextLine();
            try {
                hairColor = Color.valueOf(tmpForm.toUpperCase());
                Static.txt("Цвет волос добавлено!");
            }catch (Exception e){
                Static.txt("Ошибка Формата!");
            }
        }

        while (nationality == null){
            Static.txt("Национальность:");
            for(Enum s: Country.values()){
                Static.txt(s.name());
            }
            System.out.print(">>> ");
            String tmpForm = line.nextLine();
            try {
                nationality = Country.valueOf(tmpForm.toUpperCase());
                Static.txt("Национальность добавлено!");
            }catch (Exception e){
                Static.txt("Ошибка Формата!");
            }
        }

        try {
            Coordinates cr = new Coordinates(x, y);
            Person groepAdmiiin = new Person(perName, weight, eyeColor, hairColor, nationality);
            StudyGroup stdTmp = new StudyGroup(name, cr, studentCount, form,sm, groepAdmiiin);
            mySet.add(stdTmp);
            Static.txt("Новый объект успешно добавлено!");
            return true;
        }catch (Exception e){
            Static.txt("Ошибка добавления!");
            return false;
        }
    }

    @Override
    public String des(){
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
