package datas;

import classes.StudyGroup;
import statics.Static;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ReadCsv {
    public LinkedHashSet<StudyGroup> readCsv(){
        int s = 0;
        String line;
        LinkedHashSet<StudyGroup> mySet = new LinkedHashSet<>();
        DatasParse dtparse = new DatasParse();

        try {
            Scanner sc = new Scanner(new File(Static.filename.toString()));
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if(line.length() > 0 && s != 0){
                    StudyGroup group = dtparse.csvReader(line);
                    if (group != null){
                        mySet.add(group);}
                }
                s = s + 1;
            }
            return mySet;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
