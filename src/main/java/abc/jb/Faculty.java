package abc.jb;
import abc.utils.IOStreamUtils;
import lombok.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Faculty extends EducationEntity {

    private List<Speciality> specialitiesList;
    private Speciality speciality = new Speciality();

    public Faculty(){
    }
    public Faculty(String name){
        setName(name);
        this.specialitiesList = new ArrayList<Speciality>();
    }
    public Faculty(String name, List<Speciality> specialities){
        this.setName(name);
        this.specialitiesList = new ArrayList<Speciality>(specialities);
    }
    public void addSpeciality(Speciality speciality){
        this.specialitiesList.add(speciality);
    }
    public List<Faculty> createEntityList(){
        List<Faculty> facultiesList = new ArrayList<Faculty>();
        String facultyName;
        do{
            System.out.print("Enter faculty name or 'exit':");
            facultyName = IOStreamUtils.readString();
            if(facultyName.equals("exit"))
                break;
            else{
                Faculty faculty = new Faculty(facultyName, speciality.createEntityList());
                facultiesList.add(faculty);
            }
        }while(true);
        return facultiesList;
    }
    public List<Student> findFiveBestStudents(){
        List<Student> students = new ArrayList<Student>();
        List<Student> fiveBestStudents = new ArrayList<Student>();
        for(Speciality speciality : this.getSpecialitiesList())
            for(Group group : speciality.getGroupsList())
                for(Student student : group.getStudentsList())
                    students.add(student);
        Collections.sort(students,new StudentsComparator());
        Collections.reverse(students);
        if(students.size()>=5)
            fiveBestStudents.addAll(students.subList(0,5));
        else
            fiveBestStudents.addAll(students.subList(0,students.size()));
        return fiveBestStudents;
    }
}
