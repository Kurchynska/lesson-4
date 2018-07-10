package abc;
import utils.IOStreamUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Faculty extends EducationEntity {

    private List<Speciality> specialitiesList;
    private IOStreamUtils stream = new IOStreamUtils();
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
    public List<Speciality> getSpecialitiesList() {
        return specialitiesList;
    }
    public void setSpecialitiesList(List<Speciality> specialitiesList) {
        this.specialitiesList = new ArrayList<Speciality>(specialitiesList);
    }
    public void addSpeciality(Speciality speciality){
        this.specialitiesList.add(speciality);
    }
    public List<Faculty> createEntityList(){
        List<Faculty> facultiesList = new ArrayList<Faculty>();
        String facultyName;
        do{
            System.out.print("Enter faculty name or 'exit':");
            facultyName = stream.readString();
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
    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(!(obj instanceof Faculty))
            return false;
        else{
            Faculty faculty = (Faculty) obj;
            return (getName().equals(faculty.getName())) &&
                    (this.specialitiesList.containsAll(faculty.getSpecialitiesList()))  &&
                    (this.specialitiesList.size()==faculty.getSpecialitiesList().size());
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(),this.specialitiesList);
    }
}
