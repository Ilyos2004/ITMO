package command;

import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class ClearCommand extends AbsCommand{
    public ClearCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String s, LinkedHashSet<StudyGroup> mySet){
        mySet.clear();
        Static.txt("Коллекция успешно очищено!");
        return true;
    }

    @Override
    public String des(){
        return "clear : очистить коллекцию";
    }
}
