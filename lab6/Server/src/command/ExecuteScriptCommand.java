package command;

import ansAndRes.Res;
import classes.StudyGroup;
import statics.Static;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecuteScriptCommand extends AbsCommand{
    public ExecuteScriptCommand(String name) {
        super(name);
    }

    @Override
    public Res doo(String args, LinkedHashSet<StudyGroup> mySet){
        String allRes = "";
        CommandMang cmd = new CommandMang();

        Pattern pt = Pattern.compile("\"([^\"]*)\"");
        Matcher mt = pt.matcher(args);
        List<String> dt = new ArrayList<>();
        while(mt.find()){
            dt.add(mt.group(1));
        }

        for (String tmp: dt) {
            if(!tmp.equals("Рекурсия!") && !tmp.equals("execute_script")) {
                try {
                    allRes = allRes + cmd.mng(tmp, mySet).getResText() + "\n";
                    Static.history.add(tmp.split(" ")[0]);
                }catch (Exception e){
                    allRes = allRes + "Ошибка команды!\n\n";
                }
            }
            if(tmp.equals("Рекурсия!")){
                allRes = allRes + "Рекурсия!\n\n";
            }
        }
        return new Res(allRes, true);
    }

    @Override
    public String des(){
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
