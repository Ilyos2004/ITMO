package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class ShowCommand extends AbsCommand{
    public ShowCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String s, LinkedHashSet<StudyGroup> mySet){
        String allRes = "";
        if (!mySet.isEmpty()) {
            for (StudyGroup std : mySet) {
                allRes = allRes + std.toString() + "\n";
            }
        }else{
            allRes = allRes + "Коллекция Пуста!\n";
        }
        return new Res(allRes, true);
    }

    @Override
    public String des(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
