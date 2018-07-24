package abc.jb;

import abc.utils.IOStreamUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class University {

    private String name;
    private List<Faculty> facultiesList;
    private Faculty faculty = new Faculty();
    private Student student = new Student();

    public University(String name) {
        this.name = name;
        this.facultiesList = new ArrayList<>();
    }

    public void setFacultiesList() {
        this.facultiesList = new ArrayList<>(faculty.createEntityList());
    }

    public void addFaculties(Faculty faculty) {
        this.facultiesList.add(faculty);
    }

    public List<Student> findEqualNames() {
        List<String> names = new ArrayList<>();
        List<Student> students = getAllStudents();
        for (Student student : students)
            names.add(student.getName());
        Set<String> duplicates = new HashSet<>();
        List<Student> studentsEqualNames = new ArrayList<>();
        for (String name : names)
            if (Collections.frequency(names, name) > 1)
                duplicates.add(name);
        for (Student student : students)
            if (duplicates.contains(student.getName()))
                studentsEqualNames.add(student);
        return studentsEqualNames;
    }

    public List<Student> findEqualSurnames() {
        List<String> surnames = new ArrayList<>();
        List<Student> students = getAllStudents();
        for (Student student : students)
            surnames.add(student.getSurname());
        Set<String> duplicates = new HashSet<>();
        List<Student> studentsEqualSurnames = new ArrayList<>();
        for (String surname : surnames)
            if (Collections.frequency(surnames, surname) > 1)
                duplicates.add(surname);
        for (Student student : students)
            if (duplicates.contains(student.getSurname()))
                studentsEqualSurnames.add(student);
        return studentsEqualSurnames;
    }

    public List<Student> findEqualNamesSurnames() {
        List<String> studentsSurnames = new ArrayList<>();
        List<String> studentNames = new ArrayList<>();
        List<Student> students = getAllStudents();
        for (Student student : students) {
            studentNames.add(student.getName());
            studentsSurnames.add(student.getSurname());
        }
        Set<Student> duplicates = new HashSet<>();
        List<Student> studentsEqualNameSurname = new ArrayList<>();
        for (Student student : students)
            if ((Collections.frequency(studentNames, student.getName()) > 1)
                    && (Collections.frequency(studentsSurnames, student.getSurname()) > 1))
                duplicates.add(student);
        for (Student student : students)
            if (duplicates.contains(student))
                studentsEqualNameSurname.add(student);
        return studentsEqualNameSurname;
    }

    public void printFiveBestStudentsGroups() {
        for (Faculty faculty : this.getFacultiesList())
            for (Speciality speciality : faculty.getSpecialitiesList())
                for (Group group : speciality.getGroupsList()) {
                    System.out.println("Five best students of group " + group.getName() + ":");
                    student.printStudentsList(group.findFiveBestStudents());
                }
    }

    public void printFiveBestStudentsSpeciality() {
        for (Faculty faculty : this.getFacultiesList())
            for (Speciality speciality : faculty.getSpecialitiesList()) {
                System.out.println("Five best students of speciality " + speciality.getName() + ":");
                student.printStudentsList(speciality.findFiveBestStudents());
            }
    }

    public void printFiveBestStudentsFaculty() {
        for (Faculty faculty : this.getFacultiesList()) {
            System.out.println("Five best students of faculty " + faculty.getName() + ":");
            student.printStudentsList(faculty.findFiveBestStudents());
        }
    }

    public List<Student> findFiveWorstStudents() {
        List<Student> students = getAllStudents();
        Collections.sort(students, new StudentsComparator());
        List<Student> fiveWorstStudents = new ArrayList<>();
        if (students.size() >= 5)
            fiveWorstStudents.addAll(students.subList(0, 5));
        else
            fiveWorstStudents.addAll(students.subList(0, students.size()));
        return fiveWorstStudents;
    }

    public List<Student> readStudentsToExpel(int number) {
        List<Student> fiveWorstStudents = new ArrayList<>(findFiveWorstStudents());
        System.out.println("Enter surname of students to expel from list below:");
        student.printStudentsList(fiveWorstStudents);
        List<String> studentsSurnameList = new ArrayList<>();
        List<String> worstStudentsSurnames = new ArrayList<>();
        List<Student> listStudentsToExpel = new ArrayList<>();
        String surname;
        for (Student student : fiveWorstStudents)
            worstStudentsSurnames.add(student.getSurname());
        for (int i = 0; i < number; i++) {
            surname = IOStreamUtils.readString();
            if (worstStudentsSurnames.contains(surname))
                studentsSurnameList.add(surname);
            else {
                System.out.println("This name is not in the list, please enter correct name:");
                i--;
            }
        }
        for (Student student : fiveWorstStudents) {
            surname = student.getSurname();
            if (studentsSurnameList.contains(surname))
                listStudentsToExpel.add(student);
        }
        return listStudentsToExpel;
    }

    public void expelStudents(List<Student> studentsToExpel) {
        for (Student studentToExpel : studentsToExpel)
            for (Faculty faculty : this.getFacultiesList())
                for (Speciality speciality : faculty.getSpecialitiesList())
                    for (Group group : speciality.getGroupsList()) {
                        List<Student> studentsList = group.getStudentsList();
                        Iterator<Student> iterator = studentsList.iterator();
                        while (iterator.hasNext()) {
                            Student student = iterator.next();
                            if (student.equals(studentToExpel))
                                iterator.remove();
                        }
                    }
    }

    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        for (Faculty faculty : this.getFacultiesList())
            for (Speciality speciality : faculty.getSpecialitiesList())
                for (Group group : speciality.getGroupsList())
                    for (Student student : group.getStudentsList())
                        allStudents.add(student);
        return allStudents;
    }
}

