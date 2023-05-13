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

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UpdateByIdCommand extends AbsCommand{
    public UpdateByIdCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
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

        String[] idS = args.split(" ");
        int id = Integer.parseInt(idS[1]);
        for(StudyGroup std: mySet){
            if(std.getId() == id){
                b = true;
            }
        }

        if(b == true) {
            Scanner line = new Scanner(System.in);
            Static.txt("Введите название Группы:");
            while (name == null) {
                System.out.print(">>> ");
                String tmpName = line.nextLine();
                if (tmpName.length() > 0) {
                    name = tmpName;
                    Static.txt("Название добавлено!");
                } else {
                    Static.txt("Название не должно бить пустым!\nВведите заново!");
                }
            }

            while (x == 0 && y == 0) {
                Static.txt("Кординаты (x,y через пробел):");
                System.out.print(">>> ");
                String[] xY = line.nextLine().split(" ");
                try {
                    int tmpX = Integer.parseInt(xY[0]);
                    int tmpY = Integer.parseInt(xY[1]);
                    if (tmpY <= 146 && tmpX <= 146) {
                        x = tmpX;
                        y = tmpY;
                        Static.txt("Кординаты добавлены!");
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
                        Static.txt("Количество студентов добавлена!");
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
                    Static.txt("Формат Обучения добавлена!");
                } catch (Exception e) {
                    Static.txt("Ошибка Формата!");
                }
            }

            while (sm == null) {
                Static.txt("Формат Семестра:");
                for (Enum s : Semester.values()) {
                    Static.txt(s.name());
                }
                System.out.print(">>> ");
                String tmpForm = line.nextLine();
                try {
                    sm = Semester.valueOf(tmpForm.toUpperCase());
                    Static.txt("Формат Семестра добавлена!");
                } catch (Exception e) {
                    Static.txt("Ошибка Формата!");
                }
            }

            Static.txt("Добавить Старосту:");
            Static.txt("Введите имя Старосты:");
            while (perName == null) {
                System.out.print(">>> ");
                String tmpName = line.nextLine();
                if (tmpName.length() > 0) {
                    perName = tmpName;
                    Static.txt("Имя старосты добавлено!");
                } else {
                    Static.txt("Имя не должно бить пустым!\nВведите заново!");
                }
            }

            while (weight == 0) {
                Static.txt("Рост старосты:");
                System.out.print(">>> ");
                try {
                    String tmpStCntt = line.nextLine();
                    Float tmpStCnt = Float.parseFloat(tmpStCntt);
                    if (tmpStCnt > 0) {
                        weight = tmpStCnt;
                        Static.txt("Рост старосты добавлено!");
                    } else {
                        Static.txt("Рост старосты должно бить больше 0!");
                    }
                } catch (Exception e) {
                    Static.txt("Ошибка формата!");
                }
            }

            while (eyeColor == null) {
                Static.txt("Цвет глаз:");
                for (Enum s : Color.values()) {
                    Static.txt(s.name());
                }
                System.out.print(">>> ");
                String tmpForm = line.nextLine();
                try {
                    eyeColor = Color.valueOf(tmpForm.toUpperCase());
                    Static.txt("Цвет глаз добавлена!");
                } catch (Exception e) {
                    Static.txt("Ошибка Формата!");
                }
            }

            while (hairColor == null) {
                Static.txt("Цвет волос:");
                for (Enum s : Color.values()) {
                    Static.txt(s.name());
                }
                System.out.print(">>> ");
                String tmpForm = line.nextLine();
                try {
                    hairColor = Color.valueOf(tmpForm.toUpperCase());
                    Static.txt("Цвет волос добавлена!");
                } catch (Exception e) {
                    Static.txt("Ошибка Формата!");
                }
            }

            while (nationality == null) {
                Static.txt("Национальность:");
                for (Enum s : Country.values()) {
                    Static.txt(s.name());
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
                for(StudyGroup std: mySet){
                    if(std.getId() == id){
                        std.setName(name);
                        std.setCoordinates(cr);
                        std.setStudentsCount(studentCount);
                        std.setFormOfEducation(form);
                        std.setSemesterEnum(sm);
                        std.setGroupAdmin(groepAdmiiin);
                    }
                }
                Static.txt("Объект успешно изменено!");
                return res;
            } catch (Exception e) {
                Static.txt("Ошибка добавления!");
                return res;
            }
        }else{
            Static.txt("Такой элемент не существует!");
            return res;
        }
    }

    @Override
    public String des(){
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
