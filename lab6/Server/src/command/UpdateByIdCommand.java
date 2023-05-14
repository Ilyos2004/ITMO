package command;

import ansAndRes.Res;
import classes.Coordinates;
import classes.Person;
import classes.StudyGroup;
import datas.DatasParse;
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
        String dataCSV = "";
        String allRes = "";
        DatasParse dt = new DatasParse();
        boolean b = false;

        String[] idS = args.split(" ");
        int id = Integer.parseInt(idS[1]);
        for(StudyGroup std: mySet){
            if(std.getId() == id){
                b = true;
            }
        }

        if(b) {
            for (int i = 3; i < args.length(); i++) {
                dataCSV = dataCSV + args.charAt(i);
            }

            try {
                StudyGroup stdTmp = null;
                stdTmp = dt.csvReaderAdd(dataCSV);

                for(StudyGroup std: mySet){
                    if(std.getId() == id){
                        std.setName(stdTmp.getName());
                        std.setCoordinates(stdTmp.getCoordinates());
                        std.setStudentsCount(stdTmp.getStudentsCount());
                        std.setFormOfEducation(stdTmp.getFormOfEducation());
                        std.setSemesterEnum(stdTmp.getSemesterEnum());
                        std.setGroupAdmin(stdTmp.getGroupAdmin());
                    }
                }

                allRes = allRes + "Объект успешно изменено!\n";
                return new Res(allRes, true);
            } catch (Exception e) {
                return new Res("Ошибка изменения!\n", false);
            }
        }else{
            return new Res("Такой элемент не существует!\n", false);
        }
    }

    @Override
    public String des(){
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
