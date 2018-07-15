package abc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {

    private String name;
    private List<Student> studentsList;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Group(String name) throws IOException {
        this.name = name;
        this.studentsList = new ArrayList<Student>(createStudentsList());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Student> getStudentsList() {
        return studentsList;
    }
    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
    public List<Student> createStudentsList() throws IOException {
        List<String> stringStudentsList = new ArrayList<String>();
        String student;
        System.out.println("Enter Students in format - name,surname,average_mark. Enter 'exit' to finish");
        while (true) {
            student = reader.readLine();
            if (student.equals("exit"))
                break;
            else
                stringStudentsList.add(student);
        }
        return convertStringToStudent(stringStudentsList);
    }
    public List<Student> fiveBestStudentsGroup(){
        List<Student> students = new ArrayList<Student>(this.getStudentsList());
        List<Student> fiveBestStudents = new ArrayList<Student>();
        Collections.sort(students,new AverageMarkComparator());
        Collections.reverse(students);
        if(students.size()>4)
            for(int i = 0; i < 5; i++)
                fiveBestStudents.add(students.get(i));
        else
            for(int i = 0; i < students.size(); i++)
                fiveBestStudents.add(students.get(i));
        return fiveBestStudents;
    }

    private List<Student> convertStringToStudent(List<String> stringStudentsList) {
        List<Student> studentsList = new ArrayList<Student>();
        for (String stringStudent : stringStudentsList) {
            String[] studentFields = stringStudent.split(",");
            Student student = new Student(studentFields[0], studentFields[1], Double.parseDouble(studentFields[2]));
            studentsList.add(student);
        }
        return studentsList;
    }
}
