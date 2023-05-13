package mainProgram;
import ansAndRes.Res;
import classes.StudyGroup;
import command.CommandMang;
import command.SaveCommand;
import datas.ReadCsv;
import statics.Static;
import java.util.LinkedHashSet;
import java.util.Scanner;
public class Main {
    public LinkedHashSet<StudyGroup> main() {
        LinkedHashSet<StudyGroup> mySet = new LinkedHashSet<>();
        Static.filename = "Datas/baza.csv";

        ReadCsv csvRd = new ReadCsv();
        try {
            mySet = csvRd.readCsv();
            Static.txt("Коллекция успешно заполнено с файла!");
        } catch (Exception e) {
            Static.txt("Ошибка Файла!");
        }

        return mySet;
    }

    public void savecmd(LinkedHashSet<StudyGroup> mySet){
        Scanner srn = new Scanner(System.in);
        while (true) {
            if (srn.nextLine().equals("save")) {
                SaveCommand sv = new SaveCommand("save");
                System.out.println(sv.doo("save", mySet).getResText());
            }
        }
    }
}