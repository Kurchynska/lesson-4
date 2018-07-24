package abc.jb;
import abc.utils.IOStreamUtils;
import lombok.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Speciality extends EducationEntity {

    private List<Group> groupsList;
    private Group group = new Group();

    public Speciality(){
    }
    public Speciality(String name){
        setName(name);
        this.groupsList = new ArrayList<Group>();
    }
    public Speciality(String name, List<Group> groups){
        this.setName(name);
        this.groupsList = new ArrayList<Group>(groups);
    }
    public void addGroup(Group group){
        this.groupsList.add(group);
    }
    public List<Speciality> createEntityList(){
        List<Speciality> specialitiesList = new ArrayList<Speciality>();
        String specialityName;
        do{
            System.out.print("Enter speciality name or 'exit': ");
            specialityName = IOStreamUtils.readString();
            if(specialityName.equals("exit"))
                break;
            else{
                Speciality speciality = new Speciality(specialityName, group.createEntityList());
                specialitiesList.add(speciality);
            }
        }while(true);
        return specialitiesList;
    }
    public List<Student> findFiveBestStudents(){
        List<Student> students = new ArrayList<Student>();
        List<Student> fiveBestStudents = new ArrayList<Student>();
        for(Group group : this.getGroupsList())
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
