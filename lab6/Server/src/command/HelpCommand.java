package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class HelpCommand extends AbsCommand {
    public HelpCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        StringBuilder allRes = new StringBuilder();
        //Stream Api
        Static.listOfCommands.values().stream().map(p -> p.des() + "\n").forEach(allRes::append);
        return new Res(allRes.toString(), true);
    }

    @Override
    public String des(){
        return "help : вывести справку по доступным командам";
    }
}
