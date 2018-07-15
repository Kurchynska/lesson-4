package abc;

public class Student {
    private String name;
    private String surname;
    private double averageMark;

    public Student(String name, String surname,double averageMark){
        this.name = name;
        this.surname = surname;
        this.averageMark = averageMark;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }
    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public boolean equals(Object student) {
        if(student==null)
            return false;
        else if(!(student instanceof Student))
            return false;
        else {
            Student st = (Student)student;
            return this.getName().equals(st.getName()) &&
                    this.getSurname().equals(st.getSurname()) &&
                    this.getAverageMark() == st.getAverageMark();
        }
    }
}
