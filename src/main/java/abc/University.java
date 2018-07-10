package abc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class University {
    private ArrayList<HashMap> university = new ArrayList<HashMap>();
    private ArrayList<HashMap> groups = new ArrayList<HashMap>();

    public void addStudent(String name, String surname, double averageMark, String group){
        HashMap student = new HashMap();
        student.put("name",name);
        student.put("surname",surname);
        student.put("average",averageMark);
        student.put("group",group);
        this.university.add(student);
    }
    public void addGroup(String group, String speciality, int course, String faculty){
        HashMap universityStructure = new HashMap();
        universityStructure.put("group",group);
        universityStructure.put("speciality",speciality);
        universityStructure.put("course",course);
        universityStructure.put("faculty",faculty);
        this.groups.add(universityStructure);
    }
    public HashMap<String,ArrayList> findEqualNames(String key){
        HashMap<String,ArrayList> equalNames = new HashMap<String,ArrayList>();
        for(int i = 0; i < this.university.size(); i++){
            ArrayList index = new ArrayList();
            index.add(i);
            HashMap student = this.university.get(i);
            String studentName = student.get(key).toString();
            for(int j = 1+i; j < this.university.size(); j++){
                HashMap studentNext = this.university.get(j);
                String studentNameNext = studentNext.get(key).toString();
                if(studentName.equals(studentNameNext)){
                    index.add(j);
                }
            }
            if (!equalNames.containsKey(studentName) && index.size()>1){
                equalNames.put(studentName,index);
            }
        }
        return equalNames;
    }
    public HashMap<String,ArrayList> findEqualNamesSurnames(String keyFirst, String keySecond){
        HashMap<String,ArrayList> equalNames = findEqualNames(keyFirst);
        HashMap<String,ArrayList> equalSurnames = findEqualNames(keySecond);
        HashMap<String,ArrayList> equalNameSurname = new HashMap<String,ArrayList>();
        for(Map.Entry<String,ArrayList> pairName : equalNames.entrySet()){
            ArrayList equalNameSurnamePosition = new ArrayList();
            ArrayList namePositions = new ArrayList();
            namePositions.addAll(pairName.getValue());
            for(Map.Entry<String,ArrayList> pairSurname : equalSurnames.entrySet()){
                ArrayList surnamePositions = new ArrayList();
                surnamePositions.addAll(pairSurname.getValue());
                surnamePositions.retainAll(namePositions);
                if(surnamePositions.size()>1){
                    equalNameSurnamePosition.addAll(surnamePositions);
                    equalNameSurname.put(pairName.getKey() + " " + pairSurname.getKey(),equalNameSurnamePosition);
                    break;
                }
            }
        }
        return equalNameSurname;
    }
    public void printEqualStudents(HashMap<String,ArrayList> equalStudents){
        for(Map.Entry<String,ArrayList> pair: equalStudents.entrySet()){
            ArrayList positionsToPrint = new ArrayList();
            positionsToPrint.addAll(pair.getValue());
            for(int i = 0 ; i < positionsToPrint.size(); i++){
                HashMap studentToPrint = this.university.get(Integer.parseInt(positionsToPrint.get(i).toString()));
                System.out.printf("%-5s %9s","Name: ", studentToPrint.get("name") + ", ");
                System.out.printf("%-5s %9s", "Surname: ", studentToPrint.get("surname") + ", ");
                System.out.printf("%-5s %9s", "Average mark: ", studentToPrint.get("average") + ", ");
                System.out.printf("%-5s %9s", "Group: ", studentToPrint.get("group") + "\n");
            }
        }
    }
}
