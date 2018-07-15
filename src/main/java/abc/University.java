package abc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * TODO:
 * 1. Scanner instead of InputStreamReader
 * 2. try/catch instead of throws IOExeption
 */

public class University {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String name;
    private List<Faculty> facultiesList;

    public University(String name) throws IOException {
        this.name = name;
        this.facultiesList = new ArrayList<Faculty>(createFacultiesList());
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public List<Faculty> getFacultiesList() {
        return facultiesList;
    }
    public void setFacultiesList(List<Faculty> facultiesList) {
        this.facultiesList = facultiesList;
    }
    public List<Faculty> createFacultiesList() throws IOException {
        List<Faculty> facultiesList = new ArrayList<Faculty>();
        String facultyName;
        while(true){
            System.out.print("Enter faculty name or 'exit':");
            facultyName = reader.readLine();
            if(facultyName.equals("exit"))
                break;
            else{
                Faculty faculty = new Faculty(facultyName);
                facultiesList.add(faculty);
            }
        }
        return facultiesList;
    }
    public List<Student> findEqualNames(){
        List<String> names = new ArrayList<String>();
        List<Student> students = getAllStudents();
        for(Faculty faculty : this.getFacultiesList())
            for(Speciality speciality : faculty.getSpecialitiesList())
                for(Group group : speciality.getGroupsList())
                    for(Student student : group.getStudentsList())
                        names.add(student.getName());
        Set<String> duplicates = new HashSet<String>();
        List<Student> studentsEqualNames = new ArrayList<Student>();
        for(String name : names)
            if(Collections.frequency(names, name) > 1)
                duplicates.add(name);
        for(Student student : students)
            if(duplicates.contains(student.getName()))
                studentsEqualNames.add(student);
        return studentsEqualNames;
    }
    public List<Student> findEqualSurnames(){
        List<String> surnames = new ArrayList<String>();
        List<Student> students = getAllStudents();
        for(Faculty faculty : this.getFacultiesList())
            for(Speciality speciality : faculty.getSpecialitiesList())
                for(Group group : speciality.getGroupsList())
                    for(Student student : group.getStudentsList())
                        surnames.add(student.getSurname());
        Set<String> duplicates = new HashSet<String>();
        List<Student> studentsEqualSurnames = new ArrayList<Student>();
        for(String surname : surnames)
            if(Collections.frequency(surnames, surname) > 1)
                duplicates.add(surname);
        for(Student student : students)
            if(duplicates.contains(student.getSurname()))
                studentsEqualSurnames.add(student);
        return studentsEqualSurnames;
    }
    public List<Student> findEqualNamesSurnames(){
        List<String> namesSurnames = new ArrayList<String>();
        List<Student> students = getAllStudents();
        for(Faculty faculty : this.getFacultiesList())
            for(Speciality speciality : faculty.getSpecialitiesList())
                for(Group group : speciality.getGroupsList())
                    for(Student student : group.getStudentsList())
                        namesSurnames.add(student.getName() + student.getSurname());
        Set<String> duplicates = new HashSet<String>();
        List<Student> studentsEqualNameSurame = new ArrayList<Student>();
        for(String nameSurname : namesSurnames)
            if(Collections.frequency(namesSurnames,nameSurname)>1)
                duplicates.add(nameSurname);
        for(Student student : students)
            if(duplicates.contains(student.getName() + student.getSurname()))
                studentsEqualNameSurame.add(student);
        return studentsEqualNameSurame;
        }
    public void printStudentsList(List<Student> students){
        for(Student student : students)
            System.out.println(student.getName() + "    " + student.getSurname() + "   " + student.getAverageMark());
    }
    public void printFiveBestStudensGroups(){
        for(Faculty faculty : this.getFacultiesList())
            for(Speciality speciality : faculty.getSpecialitiesList())
                for(Group group : speciality.getGroupsList()) {
                    System.out.println("Five best students of group " + group.getName() + ":");
                    printStudentsList(group.fiveBestStudentsGroup());
                }
    }
    public void printFiveBestStudentsSpeciality(){
        for(Faculty faculty : this.getFacultiesList())
            for(Speciality speciality : faculty.getSpecialitiesList()){
                System.out.println("Five best students of speciality " + speciality.getName() + ":");
                printStudentsList(speciality.fiveBestStudentsSpeciality());
            }
    }
    public void printFiveBestStudentsFaculty(){
        for(Faculty faculty : this.getFacultiesList()){
            System.out.println("Five best students of faculty " + faculty.getName() + ":");
            printStudentsList(faculty.fiveBestStudentsFaculty());
        }
    }
    public List<Student> findFiveWorstStudents(){
        List<Student> students = getAllStudents();
        List<Student> fiveWorstStudents = new ArrayList<Student>();
        Collections.sort(students, new AverageMarkComparator());
        if(students.size() > 4)
            for(int i = 0; i < 5 ; i++)
                fiveWorstStudents.add(students.get(i));
        else
            for(int i = 0; i < students.size(); i++)
                fiveWorstStudents.add(students.get(i));
        return fiveWorstStudents;
    }
    public List<Student> readStudentsToExpel() throws IOException {
        List<Student> studentsToExpel = new ArrayList<Student>();
        String stringStudent;
        System.out.println("\nEnter 3 students to expel from recomended list:");
        for(int i = 0; i < 3; i++){
            stringStudent = reader.readLine();
            String[] studentFields = stringStudent.split(",");
            Student student = new Student(studentFields[0],studentFields[1],Double.parseDouble(studentFields[2]));
            studentsToExpel.add(student);
        }
        return studentsToExpel;
    }
    public void expelStudents(List<Student> studentsToExpel){
        for(Student studentToExpel : studentsToExpel)
            for(Faculty faculty : this.getFacultiesList())
                for(Speciality speciality : faculty.getSpecialitiesList())
                    for(Group group : speciality.getGroupsList()) {
                        List<Student> studentsList = group.getStudentsList();
                        Iterator<Student> iterator = studentsList.iterator();
                        while (iterator.hasNext()) {
                            Student student = iterator.next();
                            if (student.equals(studentToExpel))
                                iterator.remove();
                        }
                   }
    }
    public List<Student> getAllStudents(){
        List<Student> allStudents = new ArrayList<Student>();
        for(Faculty faculty : this.getFacultiesList())
            for(Speciality speciality : faculty.getSpecialitiesList())
                for(Group group : speciality.getGroupsList())
                    for(Student student : group.getStudentsList())
                        allStudents.add(student);
        return allStudents;
    }
}

