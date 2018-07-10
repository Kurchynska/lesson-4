package abc;
import java.util.Comparator;

public class StudentsComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.getAverageMark() < b.getAverageMark() ? -1 :
                a.getAverageMark() == b.getAverageMark() ? 0 : 1;
    }
}
