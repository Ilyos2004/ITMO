package command;

import ansAndRes.Res;
import classes.StudyGroup;
import datas.CsvSave;
import statics.Static;

import java.util.LinkedHashSet;

public class SaveCommand extends AbsCommand{
    public SaveCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String s, LinkedHashSet<StudyGroup> mySet){
        CsvSave cv = new CsvSave();
        String allRes = "";
        try {
            cv.saveCsv(mySet);
            allRes = allRes + "Коллекция успешно сохранено!\n";
        }catch (Exception e){
            allRes = allRes + "Ошибка сохранения!\n";
        }
        return new Res(allRes, true);
    }

    @Override
    public String des(){
        return "save : сохранить коллекцию в файл";
    }
}
