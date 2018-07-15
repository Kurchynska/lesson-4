package abc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Faculty {

    private String name;
    private List<Speciality> specialitiesList;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Faculty(String name) throws IOException {
        this.name = name;
        this.specialitiesList = new ArrayList<Speciality>(createSpecialitiesList());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Speciality> getSpecialitiesList() {
        return specialitiesList;
    }
    public void setSpecialitiesList(List<Speciality> specialitiesList) {
        this.specialitiesList = specialitiesList;
    }
    public List<Speciality> createSpecialitiesList() throws IOException {
        List<Speciality> specialitiesList = new ArrayList<Speciality>();
        String specialityName;
        while(true){
            System.out.print("Enter speciality name or 'exit': ");
            specialityName = reader.readLine();
            if(specialityName.equals("exit"))
                break;
            else{
                Speciality speciality = new Speciality(specialityName);
                specialitiesList.add(speciality);
            }
        }
        return specialitiesList;
    }
    public List<Student> fiveBestStudentsFaculty(){
        List<Student> students = new ArrayList<Student>();
        List<Student> fiveBestStudents = new ArrayList<Student>();
        for(Speciality speciality : this.getSpecialitiesList())
            for(Group group : speciality.getGroupsList())
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
