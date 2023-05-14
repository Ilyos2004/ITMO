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
        String[] allRequests = args.split("\n");
        String allRes = "";
        CommandMang cmd = new CommandMang();

        for(String tmp: allRequests){
            if(!tmp.equals("execute_script")) {
                allRes = allRes + cmd.mng(tmp, mySet).getResText();
            }
        }

        return new Res(allRes, true);
    }

    @Override
    public String des(){
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
