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
        StringBuilder allRes = new StringBuilder();
        if (!mySet.isEmpty()) {
            mySet.stream().map(p -> p.toString() + "\n").forEach(allRes::append);
        }else{
            allRes.append("Коллекция Пуста!\n");
        }
        return new Res(allRes.toString(), true);
    }

    @Override
    public String des(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
