package abc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Speciality {

    private String name;
    private List<Group> groupsList;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Speciality(String name) throws IOException {
        this.name = name;
        this.groupsList = new ArrayList<Group>(createGroupsList());
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public List<Group> getGroupsList() {
        return groupsList;
    }
    public void setGroupsList(List<Group> groupsList) {
        this.groupsList = groupsList;
    }
    public List<Group> createGroupsList() throws IOException {
        List<Group> groupsList = new ArrayList<Group>();
        String groupName;
        while(true){
            System.out.print("Enter group name or 'exit': ");
            groupName = reader.readLine();
            if(groupName.equals("exit"))
                break;
            else{
                Group group = new Group(groupName);
                groupsList.add(group);
            }
        }
        return groupsList;
    }
    public List<Student> fiveBestStudentsSpeciality(){
        List<Student> students = new ArrayList<Student>();
        List<Student> fiveBestStudents = new ArrayList<Student>();
        for(Group group : this.getGroupsList())
            for(Student student : group.getStudentsList())
                students.add(student);
        Collections.sort(students,new AverageMarkComparator());
        Collections.reverse(students);
        if(students.size()>4)
            for(int i = 0; i < 5; i++)
                fiveBestStudents.add(students.get(i));
        else
            for(int i = 0; i < students.size(); i++)
                fiveBestStudents.add(students.get(i));
        return fiveBestStudents;
    }
}
