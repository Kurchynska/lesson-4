package abc;
import utils.IOStreamUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private String surname;
    private double averageMark;
    private IOStreamUtils stream = new IOStreamUtils();

    public Student(){
    }
    public Student(String name, String surname,double averageMark){
        this.name = name;
        this.surname = surname;
        this.averageMark = averageMark;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }
    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
    public double getAverageMark() {
        return averageMark;
    }
    public List<Student> readStudentsList() {
        List<String> stringStudentsList = new ArrayList<String>();
        System.out.println("Enter students in format: Name,Surname,Mark  and print exit to stop ");
        String stringStudent;
        do {
            stringStudent = stream.readString();
            if (stringStudent.equals("exit"))
                break;
            else
                stringStudentsList.add(stringStudent);
        } while (true);
        return convertToListOfStudents(stringStudentsList);
    }
    private List<Student> convertToListOfStudents(List<String> stringStudentsList) {
        List<Student> studentsList = new ArrayList<Student>();
        for (String stringStudent : stringStudentsList) {
            String[] studentFields = stringStudent.split(",");
            Student student = new Student(studentFields[0], studentFields[1], Double.parseDouble(studentFields[2]));
            studentsList.add(student);
        }
        return studentsList;
    }
    public void printStudentsList(List<Student> students){
        for(Student student : students)
            System.out.println(student.getName() + "    " + student.getSurname() + "   " + student.getAverageMark());
    }

    @Override
    public boolean equals(Object student) {
        if(student==null)
            return false;
        else if(!(student instanceof Student))
            return false;
        else {
            Student st = (Student)student;
            return this.name.equals(st.getName()) &&
                    this.surname.equals(st.getSurname()) &&
                    this.averageMark == st.getAverageMark();
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.name,this.surname,this.averageMark);
    }
    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.averageMark;
    }
}
