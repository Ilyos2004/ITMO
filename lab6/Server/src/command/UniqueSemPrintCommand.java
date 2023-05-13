package command;

import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class UniqueSemPrintCommand extends AbsCommand{
    public UniqueSemPrintCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String args, LinkedHashSet<StudyGroup> mySet){
        for(StudyGroup std: mySet){
            Static.txt(std.getName() + " " + std.getSemesterEnum().name());
        }
        return true;
    }

    @Override
    public String des(){
        return "print_unique_semester_enum : вывести уникальные значения поля semesterEnum всех элементов в коллекции";
    }
}
