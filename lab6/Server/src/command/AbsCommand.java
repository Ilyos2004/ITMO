package command;

import ansAndRes.Res;
import classes.StudyGroup;

import java.util.LinkedHashSet;

public class AbsCommand implements Command {
    private String name;

    public AbsCommand(String name){
        this.name = name;
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet) {
        Res res = null;
        return res;
    }

    @Override
    public String des() {
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
