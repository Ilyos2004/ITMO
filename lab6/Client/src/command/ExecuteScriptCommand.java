package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ExecuteScriptCommand{

    public String doo(String args){
        String[] idS = args.split(" ");
        String filename = idS[1];
        String allRes = "";
        ExecuteScriptCommand ex = new ExecuteScriptCommand();

        try {
            Scanner sc = new Scanner(new File("Scripts/" + filename));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.split(" ").length >= 2 && line.split(" ")[0].equals("execute_script") && line.split(" ")[1].equals(filename)) {
                    allRes = allRes + "Рекурсия!\n";
                } else if(line.split(" ").length >= 2 && line.split(" ")[0].equals("execute_script")){
                    allRes = allRes + ex.doo(line) + "\n";
                }
                else {
                    try {
                        allRes = allRes + line + "\n";
                        Static.history.add(line.split(" ")[0]);
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            return allRes;
        } catch (FileNotFoundException e) {
            return "Ошибка скрипт файла!\n";
        }
    }

    public String des(){
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
