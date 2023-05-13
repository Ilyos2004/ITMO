package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class RemoveIdCommand extends AbsCommand{
    public RemoveIdCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        String[] idS = args.split(" ");
        int id = Integer.parseInt(idS[1]);
        for(StudyGroup std: mySet){
            if(std.getId() == id){
                mySet.remove(std);
                return new Res("Объект удалено!\n", true);
            }
        }
        return new Res("Нету такого объекта!\n", true);
    }

    @Override
    public String des(){
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}
