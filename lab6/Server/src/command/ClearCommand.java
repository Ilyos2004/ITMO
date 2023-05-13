package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class ClearCommand extends AbsCommand{
    public ClearCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String s, LinkedHashSet<StudyGroup> mySet){
        mySet.clear();
        return new Res("Коллекция успешно очищено!\n", true);
    }

    @Override
    public String des(){
        return "clear : очистить коллекцию";
    }
}
