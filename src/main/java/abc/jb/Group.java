package abc.jb;

import abc.utils.IOStreamUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class Group extends EducationEntity {

    private List<Student> studentsList;


    public Group(String name) {
        setName(name);
        this.studentsList = new ArrayList<>();
    }

    public Group(String name, List<Student> students) {
        setName(name);
        this.studentsList = new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public List<Group> createEntityList() {
        List<Group> groupsList = new ArrayList<>();
        Student student = new Student();
        String groupName;
        do {
            System.out.print("Enter group name or 'exit': ");
            groupName = IOStreamUtils.readString();
            if (groupName.equals("exit"))
                break;
            else {
                Group group = new Group(groupName, student.readStudentsList());
                groupsList.add(group);
            }
        } while (true);
        return groupsList;
    }

    public List<Student> findFiveBestStudents() {
        List<Student> students = new ArrayList<>(this.getStudentsList());
        List<Student> fiveBestStudents = new ArrayList<>();
        Collections.sort(students, new StudentsComparator());
        Collections.reverse(students);
        if (students.size() >= 5)
            fiveBestStudents.addAll(students.subList(0, 5));
        else
            fiveBestStudents.addAll(students.subList(0, students.size()));
        return fiveBestStudents;
    }
}
