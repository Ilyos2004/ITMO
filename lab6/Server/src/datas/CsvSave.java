package datas;

import classes.StudyGroup;
import statics.Static;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

public class CsvSave {
    public boolean saveCsv(LinkedHashSet<StudyGroup> mySet){
        try {
            PrintWriter output = new PrintWriter(new FileWriter(Static.filename.toString()), true);
            output.println("id,name,coordinate.x,coordinate.y,creationDate,studentsCount,formOfEducation,semesterEnum,groupAdmin.name,groupAdmin.weight,groupAdmin.eyeColor,groupAdmin.hairColor,groupAdmin.nationality");
            mySet.stream().map(p -> p.toStringCSV() + "\n").forEach(output::print);
            output.close();
            return true;
        }
        catch(Exception e) {
            e.getStackTrace();
            return false;
        }
    }
}