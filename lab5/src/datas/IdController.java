package datas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IdController {
    String filename = "tmp/db";
    File filefile = new File(filename);
    int idCount = 0;

    public int getId(){
        try {
            Scanner sc = new Scanner(filefile);
            idCount = sc.nextInt();
            return idCount;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean saveNewId(Integer id){
        try {
            PrintWriter output = new PrintWriter(filename);
            output.print(id.toString());
            output.close();
            return true;
        }
        catch(Exception e) {
            e.getStackTrace();
            return false;
        }
    }
}
