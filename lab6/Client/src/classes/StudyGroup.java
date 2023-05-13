package classes;

import datas.IdController;
import enums.FormOfEducation;
import enums.Semester;
import statics.Static;

import java.util.Date;

public class StudyGroup {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле может быть null

    IdController idCnt = new IdController();

    public StudyGroup(int id, String name, Coordinates coordinates, Date creationDate, Integer studentsCount, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }
    public StudyGroup(String name, Coordinates coordinates, Integer studentsCount, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        this.id = idCnt.getId() + 1;
        idCnt.saveNewId(this.id);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getCreationDate() {
        return Static.formatter.format(creationDate);
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public String toStringCSV() {
        return (String) ("\"" + this.id + "\"," + "\"" + this.name + "\"," + "\"" + this.coordinates.getX() + "\"," + "\"" + this.coordinates.getY() + "\"," + "\"" + this.getCreationDate() + "\"," + "\"" + this.getStudentsCount() + "\"," + "\"" + this.formOfEducation.name() + "\"," + "\"" + this.semesterEnum.name() + "\"," + "\"" + this.groupAdmin.getName() + "\"," + "\"" + this.groupAdmin.getWeight() + "\"," + "\"" + this.groupAdmin.getEyeColor().name() + "\"," + "\"" + this.groupAdmin.getHairColor().name() + "\"," + "\"" + this.groupAdmin.getNationality().name() + "\"");
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates.x=" + coordinates.getX() +
                ", coordinates.y=" + coordinates.getY() +
                ", creationDate=" + creationDate +
                ", studentsCount=" + studentsCount +
                ", formOfEducation=" + formOfEducation +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin.name=" + groupAdmin.getName() +
                ", groupAdmin.Nationality=" + groupAdmin.getNationality() +
                '}';
    }
}