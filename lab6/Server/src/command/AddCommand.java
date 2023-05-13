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

public class AddCommand extends AbsCommand{

    public AddCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        Res res = null;
        String dataCSV = "";
        String allRes = "";
        DatasParse dt = new DatasParse();

        for(int i = 3; i < args.length(); i++){
            dataCSV = dataCSV + args.charAt(i);
        }

        try {
            StudyGroup stdTmp = null;
            stdTmp = dt.csvReaderAdd(dataCSV);
            mySet.add(stdTmp);
            allRes = allRes + "Новый объект успешно добавлено!\n";
            return new Res(allRes, true);
        }catch (Exception e){
            return new Res("Ошибка добавления", false);
        }
    }

    @Override
    public String des(){
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
