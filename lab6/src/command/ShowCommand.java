package command;

import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class ShowCommand extends AbsCommand{
    public ShowCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String s, LinkedHashSet<StudyGroup> mySet){
        for(StudyGroup std: mySet){
            Static.txt(std.toString());
        }
        return true;
    }

    @Override
    public String des(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
