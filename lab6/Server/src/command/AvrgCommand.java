package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;
import java.util.stream.Stream;

public class AvrgCommand extends AbsCommand{
    public AvrgCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        Float ans = 0f;
        String allRes = "";
        if(!mySet.isEmpty()) {
            //Stream Api
            ans = (float) mySet.stream().mapToInt(StudyGroup::getStudentsCount).sum();
        }else{
            return new Res("Коллекция пуста!\n", true);
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
