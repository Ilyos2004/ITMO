package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class AvrgCommand extends AbsCommand{
    public AvrgCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        Float ans = 0f;
        String allRes = "";
        for(StudyGroup s: mySet){
            ans = ans + s.getStudentsCount();
        }
        try {
            ans = ans / mySet.size();
            allRes = allRes + ans.toString() + "\n";
        }catch (Exception e){
            allRes = allRes + "Коллекция пуста!" + "\n";
        }
        return new Res(allRes, true);
    }

    @Override
    public String des(){
        return "average_of_students_count : вывести среднее значение поля studentsCount для всех элементов коллекции";
    }
}
