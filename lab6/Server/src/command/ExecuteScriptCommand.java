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
        Res res = null;

        try {
            Scanner sc = new Scanner(new File("Scripts/" + filename));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.equals("exit")){
                    return res;
                }else {
                    try {
                        res = cmd.mng(line, mySet);
                        Static.history.add(line.split(" ")[0]);
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            return res;
        } catch (FileNotFoundException e) {
            Static.txt("Ошибка скрипт файла!");
            return res;
        }
    }

    @Override
    public String des(){
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
