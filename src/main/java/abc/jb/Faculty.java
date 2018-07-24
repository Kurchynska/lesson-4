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
public class Faculty extends EducationEntity {

    private List<Speciality> specialitiesList;


    public Faculty(String name) {
        setName(name);
        this.specialitiesList = new ArrayList<>();
    }

    public Faculty(String name, List<Speciality> specialities) {
        setName(name);
        this.specialitiesList = new ArrayList<>(specialities);
    }

    public void addSpeciality(Speciality speciality) {
        this.specialitiesList.add(speciality);
    }

    public List<Faculty> createEntityList() {
        Speciality speciality = new Speciality();
        List<Faculty> facultiesList = new ArrayList<>();
        String facultyName;
        do {
            System.out.print("Enter faculty name or 'exit':");
            facultyName = IOStreamUtils.readString();
            if (facultyName.equals("exit"))
                break;
            else {
                Faculty faculty = new Faculty(facultyName, speciality.createEntityList());
                facultiesList.add(faculty);
            }
        } while (true);
        return facultiesList;
    }

    public List<Student> findFiveBestStudents() {
        List<Student> students = new ArrayList<>();
        List<Student> fiveBestStudents = new ArrayList<>();
        for (Speciality speciality : this.getSpecialitiesList())
            for (Group group : speciality.getGroupsList())
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
