package datas;

import classes.Coordinates;
import classes.Person;
import classes.StudyGroup;
import enums.Color;
import enums.Country;
import enums.FormOfEducation;
import enums.Semester;
import statics.Static;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatasParse {
    public StudyGroup csvReader(String s){
        Pattern pt = Pattern.compile("\"([^\"]*)\"");
        Matcher mt = pt.matcher(s);
        List<String> dt = new ArrayList<>();
        while(mt.find()){
            dt.add(mt.group(1));
        }

        try {
            int id = Integer.parseInt(dt.get(0));
            String name = dt.get(1);
            Coordinates cor = new Coordinates(Integer.parseInt(dt.get(2)), Integer.parseInt(dt.get(3)));
            Date date = Static.formatter.parse(dt.get(4).toString());
            int stCount = Integer.parseInt(dt.get(5));
            FormOfEducation frmEdu = FormOfEducation.valueOf(dt.get(6));
            Semester sms = Semester.valueOf(dt.get(7));
            String adminName = dt.get(8);
            Float adminWeight = Float.parseFloat(dt.get(9));
            Color adminEyeColor = Color.valueOf(dt.get(10));
            Color adminHairColor = Color.valueOf(dt.get(11));
            Country adminNation = Country.valueOf(dt.get(12));

            Person adminGroup = new Person(adminName, adminWeight, adminEyeColor, adminHairColor, adminNation);
            StudyGroup data = new StudyGroup(id, name, cor, date, stCount, frmEdu, sms, adminGroup);
            return data;
        } catch (Exception e) {
            System.out.println("Ошибка Парсинга!");
            return null;
        }
    }
}
