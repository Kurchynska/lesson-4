package abc;
import java.io.IOException;
import java.util.List;


public class ListUnitTaskResults {
    public static void main(String[] args) throws IOException {
        University university = new University();
        List<List> myUniversity = university.createUniversity(2);
        university.printAllStudents(myUniversity);
        System.out.println("Students with equal names:");
        university.printStudentsEqualNames(university.findEqualNames(myUniversity),myUniversity);
        System.out.println("Students with equal surnames:");
        university.printStudentsEqualSurnames(university.findEqualSurnames(myUniversity),myUniversity);
    }
}
