package command;

import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class CommandMang{
    public boolean mng(String args, LinkedHashSet<StudyGroup> mySet){
        String[] aaa = args.split(" ");
        Static.listOfCommands.get(aaa[0]).doo(args, mySet);
        return true;
    }
}