package abc;
import abc.jb.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class UniversityTest {

    private University university = new University("KPI");
    private List<Student> studentsToExpel = new ArrayList<Student>();

    @BeforeMethod
    public void addBeforeTest(){
        Student studentOne = new Student("Ana","Ku",4.4);
        Student studentTwo = new Student("Ana","Ku",1.2);
        Student studentThree = new Student("Inna","Lo",5.0);
        Student studentFour = new Student("Andy","Zu",3.7);
        Student studentFive = new Student("Lila","Na",2.3);
        Student studentSix = new Student("Olga","Na",3.4);
        Student studentSeven = new Student("Andy","Le",2.4);
        Group group = new Group("IC-91");
        Speciality speciality = new Speciality("ASOIU");
        Faculty faculty = new Faculty("FIOT");
        group.addStudent(studentOne);
        group.addStudent(studentTwo);
        group.addStudent(studentThree);
        group.addStudent(studentFour);
        group.addStudent(studentFive);
        group.addStudent(studentSix);
        group.addStudent(studentSeven);
        speciality.addGroup(group);
        faculty.addSpeciality(speciality);
        university.addFaculties(faculty);
    }

    /**
     * Students are expelt
     */
    @Test
    public void IsStudentsWasExpelt(){
        studentsToExpel.add(new Student("Ana","Ku",1.2));
        studentsToExpel.add(new Student("Lila","Na",2.3));
        studentsToExpel.add(new Student("Andy","Le",2.4));
        List<Student> allStudents = new ArrayList<Student>(university.getAllStudents());
        university.expelStudents(studentsToExpel);
        List<Student> studentsList = new ArrayList<Student>(allStudents);
        studentsList.removeAll(university.getAllStudents());
        Assert.assertEquals(studentsList,studentsToExpel,"Students expel went not properly");
    }
}
