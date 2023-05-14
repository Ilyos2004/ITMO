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
        StringBuilder allRes = new StringBuilder();
        if (!mySet.isEmpty()) {
            //Stream Api
            mySet.stream().map(p -> p.getName() + " " + p.getSemesterEnum().name() + "\n").forEach(allRes::append);
        }else{
            allRes.append("Коллекция пуста!\n");
        }
        return new Res(allRes.toString(), true);
    }

    @Override
    public String des(){
        return "print_unique_semester_enum : вывести уникальные значения поля semesterEnum всех элементов в коллекции";
    }
}
