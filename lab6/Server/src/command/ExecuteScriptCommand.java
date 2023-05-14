package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ExecuteScriptCommand extends AbsCommand{
    public ExecuteScriptCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        String[] idS = args.split(" ");
        String filename = idS[1];
        CommandMang cmd = new CommandMang();
        String allRes = "";

        try {
            Scanner sc = new Scanner(new File("Scripts/" + filename));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.split(" ").length >= 2 && line.split(" ")[0].equals("execute_script") && line.split(" ")[1].equals(filename)) {
                    allRes = allRes + "Рекурсия!\n\n";
                } else {
                    try {
                        allRes = allRes + cmd.mng(line, mySet).getResText() + "\n";
                        Static.history.add(line.split(" ")[0]);
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            return new Res(allRes, true);
        } catch (FileNotFoundException e) {
            return new Res("Ошибка скрипт файла!\n", true);
        }
    }

    @Override
    public String des(){
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
