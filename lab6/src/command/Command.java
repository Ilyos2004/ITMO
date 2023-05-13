package command;

import classes.StudyGroup;

import java.util.LinkedHashSet;

public interface Command {
    boolean doo(String args, LinkedHashSet<StudyGroup> mySet);
    String des();
    String getName();
}