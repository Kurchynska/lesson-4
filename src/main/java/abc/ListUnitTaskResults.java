package abc;

public class ListUnitTaskResults {
    public static void main(String[] args) {
        Student student = new Student();

        University university = new University("KPI");
        university.setFacultiesList();
        System.out.println("Students with equal names: ");
        student.printStudentsList(university.findEqualNames());
        System.out.println("\nStudents with equal surnames: ");
        student.printStudentsList(university.findEqualSurnames());
        System.out.println("\nStudents with equal name and surname: ");
        student.printStudentsList(university.findEqualNamesSurnames());
        System.out.println("\nFive best students: ");
        university.printFiveBestStudentsGroups();
        university.printFiveBestStudentsSpeciality();
        university.printFiveBestStudentsFaculty();
        System.out.println("\nFive worst students :");
        student.printStudentsList( university.findFiveWorstStudents());
        university.expelStudents(university.readStudentsToExpel(3));
        System.out.println("Students that are not expelt: ");
        student.printStudentsList(university.getAllStudents());

    }
}
