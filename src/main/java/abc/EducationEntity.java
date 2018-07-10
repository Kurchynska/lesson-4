package abc;
import java.util.List;

public abstract class EducationEntity {

    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract List findFiveBestStudents();
    public abstract List createEntityList();
    @Override
    public String toString() {
        return this.name;
    }
}
