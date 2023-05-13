package command;

import classes.StudyGroup;
import datas.CsvSave;
import statics.Static;

import java.util.LinkedHashSet;

public class SaveCommand extends AbsCommand{
    public SaveCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String s, LinkedHashSet<StudyGroup> mySet){
        CsvSave cv = new CsvSave();
        try {
            cv.saveCsv(mySet);
            Static.txt("Коллекция успешно сохранено!");
        }catch (Exception e){
            Static.txt("Ошибка сохранения!");
        }
        return true;
    }

    @Override
    public String des(){
        return "save : сохранить коллекцию в файл";
    }
}
