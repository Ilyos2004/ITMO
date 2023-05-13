package command;

import ansAndRes.Res;
import classes.StudyGroup;

import java.util.LinkedHashSet;

public interface Command {
    Res doo(String args, LinkedHashSet<StudyGroup> mySet);
    String des();
    String getName();
}