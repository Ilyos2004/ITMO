package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class HistoryCommand extends AbsCommand{
    public HistoryCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        String allRes = "";
        if(Static.history.size() >= 12) {
            for (int i = Static.history.size() - 12; i < Static.history.size(); i++) {
                allRes = allRes + (Static.history.get(i)) + "\n";
            }
            return new Res(allRes, true);
        }
        else{
            return new Res("История команд меньше 12!\n", true);
        }
    }

    @Override
    public String des(){
        return "history : вывести последние 12 команд (без их аргументов)";
    }
}
