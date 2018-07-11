package abc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class University {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public List<Student> createGroup(int studentsNumber) throws IOException {
        List<Student> group = new ArrayList<Student>();
        for(int i = 0; i < studentsNumber; i++){
            System.out.print("\nEnter student name: ");
            String name = reader.readLine();
            System.out.print("\nEnter student surname: ");
            String surname = reader.readLine();
            System.out.print("\nEnter student average mark: ");
            double mark = Double.parseDouble(reader.readLine());
            Student student = new Student(name,surname,mark);
            group.add(student);
        }
        return group;
    }
    public List<List> createSpeciality(int groupNumber) throws IOException{
        List<List> speciality = new ArrayList<List>();
        for(int i = 1; i <= groupNumber; i++){
            System.out.print("\nHow many students will be in group " + i + ": ");
            int studentsNumber = Integer.parseInt(reader.readLine());
            speciality.add(createGroup(studentsNumber));
        }
        return speciality;
    }
    public List<List> createFaculty(int specialitiesNumber) throws IOException{
        List<List> faculty = new ArrayList<List>();
        for(int i = 1; i <=specialitiesNumber; i++){
            System.out.print("\nHow many groups will be in speciality " + i + ":");
            int groupsNumber = Integer.parseInt(reader.readLine());
            faculty.add(createSpeciality(groupsNumber));
        }
        return faculty;
    }
    public List<List> createUniversity(int facultiesNumber) throws IOException{
        List<List> university = new ArrayList<List>();
        for(int i = 1; i<=facultiesNumber; i++){
            System.out.print("\nHow many specialities will be in faculty " + i + ":");
            int specialitiesNumber = Integer.parseInt(reader.readLine());
            university.add(createFaculty(specialitiesNumber));
        }
        return university;
    }
    public void printAllStudents(List<List> university) throws IOException{
        for(int i = 0; i < university.size(); i++){
            List<List> faculty = new ArrayList<List>();
            faculty.addAll(university.get(i));
            for(int j = 0; j < faculty.size(); j++){
                List<List> speciality = new ArrayList<List>();
                speciality.addAll(faculty.get(j));
                for(int k = 0; k < speciality.size(); k++ ){
                    List<Student> group = new ArrayList<Student>();
                    group.addAll(speciality.get(k));
                    for(int t = 0; t < group.size(); t++){
                        Student student = group.get(t);
                        String name = student.getName();
                        String surname = student.getSurname();
                        double mark = student.getAverageMark();
                        System.out.println(name + "   " + surname + "  " + mark);
                    }
                }
            }
        }
    }
    public List<String> findEqualNames(List<List> university) throws IOException{
        List<String> names = new ArrayList<String>();
        for(int i = 0; i < university.size(); i++){
            List<List> faculty = new ArrayList<List>();
            faculty.addAll(university.get(i));
            for(int j = 0; j < faculty.size(); j++){
                List<List> speciality = new ArrayList<List>();
                speciality.addAll(faculty.get(j));
                for(int k = 0; k < speciality.size(); k++ ){
                    List<Student> group = new ArrayList<Student>();
                    group.addAll(speciality.get(k));
                    for(int t = 0; t < group.size(); t++){
                        Student student = group.get(t);
                        String name = student.getName();
                        names.add(name);
                    }
                }
            }
        }
        ArrayList<String> nameRepited = new ArrayList<String>();
        int counter;
        for(int i = 0; i < names.size(); i++){
            String nameToCompare = names.get(i);
            counter = 1;
            for(int j = 1+i; j <names.size(); j++){
                if(nameToCompare.equals(names.get(j))){
                    counter++;
                }
            }
            if(counter>1 && !nameRepited.contains(nameToCompare)){
                nameRepited.add(nameToCompare);
            }
        }
        return nameRepited;
    }
    public void printStudentsEqualNames(List<String> nameRepited, List<List> university){
        for(int i = 0; i < university.size(); i++){
            List<List> faculty = new ArrayList<List>();
            faculty.addAll(university.get(i));
            for(int j = 0; j < faculty.size(); j++){
                List<List> speciality = new ArrayList<List>();
                speciality.addAll(faculty.get(j));
                for(int k = 0; k < speciality.size(); k++ ){
                    List<Student> group = new ArrayList<Student>();
                    group.addAll(speciality.get(k));
                    for(int t = 0; t < group.size(); t++){
                        Student student = group.get(t);
                        String name = student.getName();
                        String surname = student.getSurname();
                        double mark = student.getAverageMark();
                        if(nameRepited.contains(name)){
                            System.out.println(name + "   " + surname + "  " + mark);
                        }
                    }
                }
            }
        }
    }
    public List<String> findEqualSurnames(List<List> university) throws IOException{
        List<String> surnames = new ArrayList<String>();
        for(int i = 0; i < university.size(); i++){
            List<List> faculty = new ArrayList<List>();
            faculty.addAll(university.get(i));
            for(int j = 0; j < faculty.size(); j++){
                List<List> speciality = new ArrayList<List>();
                speciality.addAll(faculty.get(j));
                for(int k = 0; k < speciality.size(); k++ ){
                    List<Student> group = new ArrayList<Student>();
                    group.addAll(speciality.get(k));
                    for(int t = 0; t < group.size(); t++){
                        Student student = group.get(t);
                        String surname = student.getSurname();
                        surnames.add(surname);
                    }
                }
            }
        }
        ArrayList<String> surnameRepited = new ArrayList<String>();
        int counter;
        for(int i = 0; i < surnames.size(); i++){
            String nameToCompare = surnames.get(i);
            counter = 1;
            for(int j = 1+i; j <surnames.size(); j++){
                if(nameToCompare.equals(surnames.get(j))){
                    counter++;
                }
            }
            if(counter>1 && !surnameRepited.contains(nameToCompare)){
                surnameRepited.add(nameToCompare);
            }
        }
        return surnameRepited;
    }
    public void printStudentsEqualSurnames(List<String> surnameRepited, List<List> university){
        for(int i = 0; i < university.size(); i++){
            List<List> faculty = new ArrayList<List>();
            faculty.addAll(university.get(i));
            for(int j = 0; j < faculty.size(); j++){
                List<List> speciality = new ArrayList<List>();
                speciality.addAll(faculty.get(j));
                for(int k = 0; k < speciality.size(); k++ ){
                    List<Student> group = new ArrayList<Student>();
                    group.addAll(speciality.get(k));
                    for(int t = 0; t < group.size(); t++){
                        Student student = group.get(t);
                        String name = student.getName();
                        String surname = student.getSurname();
                        double mark = student.getAverageMark();
                        if(surnameRepited.contains(surname)){
                            System.out.println(name + "   " + surname + "  " + mark);
                        }
                    }
                }
            }
        }
    }
}
