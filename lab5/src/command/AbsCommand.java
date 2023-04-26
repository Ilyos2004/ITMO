package command;

import classes.StudyGroup;

import java.util.LinkedHashSet;

public class AbsCommand implements Command {
    private String name;

    public AbsCommand(String name){
        this.name = name;
    }

    @Override
    public boolean doo(String args, LinkedHashSet<StudyGroup> mySet) {
        return false;
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
