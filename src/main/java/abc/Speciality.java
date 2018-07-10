package abc;
import utils.IOStreamUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Speciality extends EducationEntity{

    private List<Group> groupsList;
    private IOStreamUtils stream = new IOStreamUtils();
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
    public List<Group> getGroupsList() {
        return groupsList;
    }
    public void setGroupsList(List<Group> groupsList) {
        this.groupsList = new ArrayList<Group>(groupsList);
    }
    public void addGroup(Group group){
        this.groupsList.add(group);
    }
    public List<Speciality> createEntityList(){
        List<Speciality> specialitiesList = new ArrayList<Speciality>();
        String specialityName;
        do{
            System.out.print("Enter speciality name or 'exit': ");
            specialityName = stream.readString();
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
    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(!(obj instanceof Speciality))
            return false;
        else{
            Speciality speciality = (Speciality) obj;
            return (getName().equals(speciality.getName())) &&
                    (this.groupsList.containsAll(speciality.getGroupsList()))  &&
                    (this.groupsList.size()==speciality.getGroupsList().size());
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(),this.groupsList);
    }
}
