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
        String allRes = "";
        for(Command c: Static.listOfCommands.values()){
            allRes = allRes + c.des() + "\n";
        }
        return new Res(allRes, true);
    }

    @Override
    public String des(){
        return "help : вывести справку по доступным командам";
    }
}
