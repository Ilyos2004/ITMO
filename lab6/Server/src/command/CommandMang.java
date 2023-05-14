package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class CommandMang{
    public Res mng(String args, LinkedHashSet<StudyGroup> mySet){
        String[] aaa = args.split(" ");
        try {
            return Static.listOfCommands.get(aaa[0]).doo(args, mySet);
        } catch (Exception e) {
            return null;
        }
    }
}