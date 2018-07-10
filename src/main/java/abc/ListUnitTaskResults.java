package abc;
import java.util.ArrayList;
import java.util.HashMap;

public class ListUnitTaskResults {
    public static void main(String[] args){
        University university = new University();
        university.addStudent("Ana","Ku",4.5,"IC-91");
        university.addStudent("Andy","Zu",4.8,"IC-91");
        university.addStudent("Dima","Che",2.8,"IC-91");
        university.addStudent("Olga","Te",5.0,"IC-92");
        university.addStudent("Elena","Ne",3.6,"IC-92");
        university.addStudent("Olga","La",4.0,"IP-01");
        university.addStudent("Natasha","La",4.1,"IP-01");
        university.addStudent("Mark","Fa",3.1,"IP-01");
        university.addStudent("Ana","Fa",4.1,"IP-01");
        university.addStudent("Ana","Ku",3.5,"IP-12");
        university.addStudent("Alina","Fe",3.0,"IP-12");
        university.addStudent("Alex","Lu",4.7,"IP-12");
        university.addStudent("Rod","Le",3.9,"IT-01");
        university.addStudent("Bob","Ba",2.9,"IT-01");
        university.addStudent("Tod","Sa",1.9,"IT-01");
        university.addStudent("Artur","Le",4.9,"IT-02");
        university.addStudent("Clark","Le",3.2,"IT-02");
        university.addStudent("Clark","Ku",4.2,"IT-02");
        university.addGroup("IC-91","ASOIU",5,"FIOT");
        university.addGroup("IC-92","ASOIU",5,"FIOT");
        university.addGroup("IP-01","IP",2,"FIOT");
        university.addGroup("IP-12","IP",3,"FIOT");
        university.addGroup("IT-01","IT",2,"IEE");
        university.addGroup("IT-02","IT",2,"IEE");

        HashMap<String,ArrayList> sameStudentNames= university.findEqualNames("name");
        System.out.println("Students with equal name:");
        university.printEqualStudents(sameStudentNames);
        HashMap<String,ArrayList> sameStudentSurnames = university.findEqualNames("surname");
        System.out.println("\nStudents with equal surname:");
        university.printEqualStudents(sameStudentSurnames);
        HashMap<String,ArrayList> sameStudentNameSurname = university.findEqualNamesSurnames("name","surname");
        System.out.println("\nStudents with equal name and surname");
        university.printEqualStudents(sameStudentNameSurname);
    }
}
