package abc;
import utils.IOStreamUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Group extends EducationEntity {

    private List<Student> studentsList;
    private IOStreamUtils stream = new IOStreamUtils();
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
    public List<Student> getStudentsList() {
        return studentsList;
    }
    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = new ArrayList<Student>(studentsList);
    }
    public void addStudent(Student student){
        studentsList.add(student);
    }
    public List<Group> createEntityList(){
        List<Group> groupsList = new ArrayList<Group>();
        String groupName;
        while(true){
            System.out.print("Enter group name or 'exit': ");
            groupName = stream.readString();
            if(groupName.equals("exit"))
                break;
            else{
                Group group = new Group(groupName, student.readStudentsList());
                groupsList.add(group);
            }
        }
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
    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(!(obj instanceof Group))
            return false;
        else{
            Group group = (Group)obj;
            return (getName().equals(group.getName())) &&
                    (this.studentsList.containsAll(group.getStudentsList()))  &&
                    (this.studentsList.size()==group.getStudentsList().size());
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(),this.studentsList);
    }
}
