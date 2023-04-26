package command;

import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class RemoveIdCommand extends AbsCommand{
    public RemoveIdCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String args, LinkedHashSet<StudyGroup> mySet){
        String[] idS = args.split(" ");
        int id = Integer.parseInt(idS[1]);
        for(StudyGroup std: mySet){
            if(std.getId() == id){
                mySet.remove(std);
                Static.txt("Объект удалено!");
                return true;
            }
        }
        Static.txt("Нету такого объекта!");
        return  false;
    }

    @Override
    public String des(){
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}
