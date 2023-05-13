package command;

import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class InfoCommand extends AbsCommand{
    public InfoCommand(String name) {
        super(name);
    }

    @Override
    public boolean doo(String args, LinkedHashSet<StudyGroup> mySet){
        Static.txt("Класс:    Study Group\n" +
                "id - identification number\n" +
                "name - Номер группы\n" +
                "coordinates - координаты класса\n" +
                "creationDate - дата создания\n" +
                "studentsCount - количество студентов\n" +
                "groupAdmin - Староста Группы\n" +
                "semesterEnum - тип Семестра");
        return true;
    }
    @Override
    public String des(){
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
