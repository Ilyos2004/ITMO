package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.*;

public class FieldAscFromOfEducationCommand extends AbsCommand{
    public FieldAscFromOfEducationCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        TreeMap<String, String> mpTmp = new TreeMap<>();
        StringBuilder allRes =new StringBuilder();

        List<String> s = new ArrayList<>();
        if (!mySet.isEmpty()) {
            //Stream Api
            mySet.stream().map(p -> p.getFormOfEducation().name()).forEach(s::add);
        }else{
            return new Res("Коллекция пуста!\n", true);
        }
        Collections.sort(s);
        for(String tmp: s){
            for(StudyGroup std: mySet){
                if(tmp.equals(std.getFormOfEducation().name())){
                    mpTmp.put(std.getName(), std.getFormOfEducation().name());
                }
            }
        }

        //Stream Api
        mpTmp.keySet().stream().map(p -> p + " " + mpTmp.get(p) + "\n").forEach(allRes::append);
        return new Res(allRes.toString(), true);
    }

    @Override
    public String des(){
        return "print_field_ascending_form_of_education : вывести значения поля formOfEducation всех элементов в порядке возрастания";
    }
}
