package command;

import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class HelpCommand extends AbsCommand {
    public HelpCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String args, LinkedHashSet<StudyGroup> mySet){
        for(Command c: Static.listOfCommands.values()){
            Static.txt(c.des());
        }
        return true;
    }

    @Override
    public String des(){
        return "help : вывести справку по доступным командам";
    }
}
