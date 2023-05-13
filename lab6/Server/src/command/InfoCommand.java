package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.util.LinkedHashSet;

public class InfoCommand extends AbsCommand{
    public InfoCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        String allRes = ("Класс:    Study Group\n" +
                "id - identification number\n" +
                "name - Номер группы\n" +
                "coordinates - координаты класса\n" +
                "creationDate - дата создания\n" +
                "studentsCount - количество студентов\n" +
                "groupAdmin - Староста Группы\n" +
                "semesterEnum - тип Семестра\n");
        return new Res(allRes, true);
    }
    @Override
    public String des(){
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
