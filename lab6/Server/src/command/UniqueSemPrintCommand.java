package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class UniqueSemPrintCommand extends AbsCommand{
    public UniqueSemPrintCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        String allRes = "";
        for(StudyGroup std: mySet){
            allRes = allRes + (std.getName() + " " + std.getSemesterEnum().name()) + "\n";
        }
        return new Res(allRes, true);
    }

    @Override
    public String des(){
        return "print_unique_semester_enum : вывести уникальные значения поля semesterEnum всех элементов в коллекции";
    }
}
