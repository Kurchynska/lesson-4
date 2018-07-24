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
public class Speciality extends EducationEntity {

    private List<Group> groupsList;

    public Speciality(String name) {
        setName(name);
        this.groupsList = new ArrayList<>();
    }

    public Speciality(String name, List<Group> groups) {
        setName(name);
        this.groupsList = new ArrayList<>(groups);
    }

    public void addGroup(Group group) {
        this.groupsList.add(group);
    }

    public List<Speciality> createEntityList() {
        Group group = new Group();
        List<Speciality> specialitiesList = new ArrayList<>();
        String specialityName;
        do {
            System.out.print("Enter speciality name or 'exit': ");
            specialityName = IOStreamUtils.readString();
            if (specialityName.equals("exit"))
                break;
            else {
                Speciality speciality = new Speciality(specialityName, group.createEntityList());
                specialitiesList.add(speciality);
            }
        } while (true);
        return specialitiesList;
    }

    public List<Student> findFiveBestStudents() {
        List<Student> students = new ArrayList<>();
        List<Student> fiveBestStudents = new ArrayList<>();
        for (Group group : this.getGroupsList())
            for (Student student : group.getStudentsList())
                students.add(student);
        Collections.sort(students, new StudentsComparator());
        Collections.reverse(students);
        if (students.size() >= 5)
            fiveBestStudents.addAll(students.subList(0, 5));
        else
            fiveBestStudents.addAll(students.subList(0, students.size()));
        return fiveBestStudents;
    }
}
