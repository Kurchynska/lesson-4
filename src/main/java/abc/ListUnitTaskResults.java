package abc;
import java.io.IOException;
import java.util.List;


public class ListUnitTaskResults {
    public static void main(String[] args) throws IOException {
        University university = new University("KPI");
        System.out.println("Students with equal names: ");
        List<Student> equalNameStudents = university.findEqualNames();
        university.printStudentsList(equalNameStudents);
        System.out.println("\nStudents with equal surnames: ");
        List<Student> equalSurnameStudents = university.findEqualSurnames();
        university.printStudentsList(equalSurnameStudents);
        System.out.println("\nStudents with equal name and surname: ");
        List<Student> equalNameSurnameStudents = university.findEqualNamesSurnames();
        university.printStudentsList(equalNameSurnameStudents);
        System.out.println("\nFive best students: ");
        university.printFiveBestStudensGroups();
        university.printFiveBestStudentsSpeciality();
        university.printFiveBestStudentsFaculty();
        System.out.println("\nFive worst students :");
        List<Student> fiveWorstStudents = university.findFiveWorstStudents();
        university.printStudentsList(fiveWorstStudents);
        university.expelStudents(university.readStudentsToExpel());
        System.out.println("Students that are not expelt: ");
        university.printStudentsList(university.getAllStudents());

    }
}
