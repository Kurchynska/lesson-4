package abc.jb;
import abc.utils.IOStreamUtils;
import lombok.Data;
import java.util.*;

@Data
public class University {

    private String name;
    private List<Faculty> facultiesList;
    private Faculty faculty = new Faculty();
    private Student student = new Student();

    public University(){
    }
    public University(String name){
        this.name = name;
        this.facultiesList = new ArrayList<Faculty>();
    }
    public void setFacultiesList() {
        this.facultiesList = new ArrayList<Faculty>(faculty.createEntityList());
    }
    public void addFaculties(Faculty faculty){
        this.facultiesList.add(faculty);
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
    public void printFiveBestStudentsGroups(){
        for(Faculty faculty : this.getFacultiesList())
            for(Speciality speciality : faculty.getSpecialitiesList())
                for(Group group : speciality.getGroupsList()) {
                    System.out.println("Five best students of group " + group.getName() + ":");
                    student.printStudentsList(group.findFiveBestStudents());
                }
    }
    public void printFiveBestStudentsSpeciality(){
        for(Faculty faculty : this.getFacultiesList())
            for(Speciality speciality : faculty.getSpecialitiesList()){
                System.out.println("Five best students of speciality " + speciality.getName() + ":");
                student.printStudentsList(speciality.findFiveBestStudents());
            }
    }
    public void printFiveBestStudentsFaculty(){
        for(Faculty faculty : this.getFacultiesList()){
            System.out.println("Five best students of faculty " + faculty.getName() + ":");
            student.printStudentsList(faculty.findFiveBestStudents());
        }
    }
    public List<Student> findFiveWorstStudents(){
        List<Student> students = getAllStudents();
        Collections.sort(students, new StudentsComparator());
        List<Student> fiveWorstStudents = new ArrayList<Student>();
        if(students.size()>=5)
            fiveWorstStudents.addAll(students.subList(0,5));
        else
            fiveWorstStudents.addAll(students.subList(0,students.size()));
        return fiveWorstStudents;
    }
    public List<Student> readStudentsToExpel(int number){
        List<Student> fiveWorstStudents = new ArrayList<Student>(findFiveWorstStudents());
        System.out.println("Enter surname of students to expel from list below:");
        student.printStudentsList(fiveWorstStudents);
        List<String> studentsSurnameList = new ArrayList<String>();
        List<String> worstStudentsSurnames = new ArrayList<String>();
        List<Student> listStudentsToExpel = new ArrayList<Student>();
        String surname;
        for(Student student: fiveWorstStudents)
            worstStudentsSurnames.add(student.getSurname());
        for(int i = 0; i<number; i++ ){
            surname = IOStreamUtils.readString();
            if(worstStudentsSurnames.contains(surname))
                studentsSurnameList.add(surname);
            else{
                System.out.println("This name is not in the list, please enter correct name:");
                i--;
            }
        }
        for(Student student : fiveWorstStudents){
            surname = student.getSurname();
            if(studentsSurnameList.contains(surname))
                listStudentsToExpel.add(student);
        }
        return listStudentsToExpel;
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

