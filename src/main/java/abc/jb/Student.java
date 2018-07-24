package abc.jb;

import abc.utils.IOStreamUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private String surname;
    private double averageMark;

    public List<Student> readStudentsList() {
        List<String> stringStudentsList = new ArrayList<>();
        System.out.println("Enter students in format: Name,Surname,Mark  and print exit to stop ");
        String stringStudent;
        do {
            stringStudent = IOStreamUtils.readString();
            if (stringStudent.equals("exit"))
                break;
            else
                stringStudentsList.add(stringStudent);
        } while (true);
        return convertToListOfStudents(stringStudentsList);
    }

    private List<Student> convertToListOfStudents(List<String> stringStudentsList) {
        List<Student> studentsList = new ArrayList<>();
        for (String stringStudent : stringStudentsList) {
            String[] studentFields = stringStudent.split(",");
            Student student = new Student(studentFields[0], studentFields[1], Double.parseDouble(studentFields[2]));
            studentsList.add(student);
        }
        return studentsList;
    }

    public void printStudentsList(List<Student> students) {
        for (Student student : students)
            System.out.println(student.getName() + "    " + student.getSurname() + "   " + student.getAverageMark());
    }
}
