package abc.jb;
import abc.utils.IOStreamUtils;
import lombok.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Group extends EducationEntity {

    private List<Student> studentsList;
    private Student student = new Student();

    public Group(){
    }
    public Group(String name){
        setName(name);
        this.studentsList = new ArrayList<Student>();
    }
    public Group(String name, List<Student> students){
        setName(name);
        this.studentsList = new ArrayList<Student>(students);
    }
    public void addStudent(Student student){
        studentsList.add(student);
    }
    public List<Group> createEntityList(){
        List<Group> groupsList = new ArrayList<Group>();
        String groupName;
        do{
            System.out.print("Enter group name or 'exit': ");
            groupName = IOStreamUtils.readString();
            if(groupName.equals("exit"))
                break;
            else{
                Group group = new Group(groupName, student.readStudentsList());
                groupsList.add(group);
            }
        }while(true);
        return groupsList;
    }
    public List<Student> findFiveBestStudents(){
        List<Student> students = new ArrayList<Student>(this.getStudentsList());
        List<Student> fiveBestStudents = new ArrayList<Student>();
        Collections.sort(students,new StudentsComparator());
        Collections.reverse(students);
        if(students.size()>=5)
            fiveBestStudents.addAll(students.subList(0,5));
        else
            fiveBestStudents.addAll(students.subList(0,students.size()));
        return fiveBestStudents;
    }
}
