package command;

import classes.StudyGroup;
import statics.Static;

import java.util.*;

public class FieldAscFromOfEducationCommand extends AbsCommand{
    public FieldAscFromOfEducationCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String args, LinkedHashSet<StudyGroup> mySet){
        TreeMap<String, String> mpTmp = new TreeMap<>();

        List<String> s = new ArrayList<>();
        for(StudyGroup ss: mySet){
            s.add(ss.getFormOfEducation().name());
        }
        Collections.sort(s);
        for(String tmp: s){
            for(StudyGroup std: mySet){
                if(tmp.equals(std.getFormOfEducation().name())){
                    mpTmp.put(std.getName(), std.getFormOfEducation().name());
                }
            }
        }

        for(String t: mpTmp.keySet()){
            Static.txt(t + " " + mpTmp.get(t));
        }
        return true;
    }

    @Override
    public String des(){
        return "print_field_ascending_form_of_education : вывести значения поля formOfEducation всех элементов в порядке возрастания";
    }
}
