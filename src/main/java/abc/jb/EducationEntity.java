package abc.jb;
import lombok.Data;
import java.util.List;

@Data
public abstract class EducationEntity {
    private String name;
    public abstract List findFiveBestStudents();
    public abstract List createEntityList();
}
