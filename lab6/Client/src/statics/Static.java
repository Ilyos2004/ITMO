package statics;

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

}