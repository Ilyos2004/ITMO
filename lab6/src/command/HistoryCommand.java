package command;

import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class HistoryCommand extends AbsCommand{
    public HistoryCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String args, LinkedHashSet<StudyGroup> mySet){
        if(Static.history.size() >= 12) {
            for (int i = Static.history.size() - 12; i <= Static.history.size(); i++) {
                Static.txt(Static.history.get(i));
            }
            return true;
        }
        else{
            Static.txt("История команд меньше 12!");
            return false;
        }
    }

    @Override
    public String des(){
        return "history : вывести последние 12 команд (без их аргументов)";
    }
}
