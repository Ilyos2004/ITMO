package statics;

import command.*;

import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Static {
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    public static String filename = "../lab5/Datas/";

    public static void txt(String s){
        System.out.println(s);
    }
    public static List<String> history = new LinkedList<>();
    public static Map<String, Command> listOfCommands;

    static{
        listOfCommands = new LinkedHashMap<>();
        listOfCommands.put("help", new HelpCommand("help"));
        listOfCommands.put("info", new InfoCommand("info"));
        listOfCommands.put("show", new ShowCommand("show"));
        listOfCommands.put("clear", new ClearCommand("clear"));
        listOfCommands.put("save", new SaveCommand("save"));
        listOfCommands.put("average_of_students_count", new AvrgCommand("average_of_students_count"));
        listOfCommands.put("print_unique_semester_enum", new UniqueSemPrintCommand("print_unique_semester_enum"));
        listOfCommands.put("print_field_ascending_form_of_education", new FieldAscFromOfEducationCommand("print_field_ascending_form_of_education"));
        listOfCommands.put("remove_by_id", new RemoveIdCommand("remove_by_id"));
        listOfCommands.put("add", new AddCommand("add"));
        listOfCommands.put("update", new UpdateByIdCommand("update"));
        listOfCommands.put("execute_script", new ExecuteScriptCommand("execute_script"));
        listOfCommands.put("history", new HistoryCommand("history"));
    }

}