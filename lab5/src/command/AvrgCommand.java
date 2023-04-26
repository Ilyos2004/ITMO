package command;

import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class AvrgCommand extends AbsCommand{
    public AvrgCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String args, LinkedHashSet<StudyGroup> mySet){
        Float ans = 0f;
        for(StudyGroup s: mySet){
            ans = ans + s.getStudentsCount();
        }
        try {
            ans = ans / mySet.size();
            Static.txt(ans.toString());
        }catch (Exception e){
            Static.txt("Коллекция пуста!");
        }
        return true;
    }

    @Override
    public String des(){
        return "average_of_students_count : вывести среднее значение поля studentsCount для всех элементов коллекции";
    }
}
