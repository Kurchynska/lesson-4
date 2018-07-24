package abc.jb;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public abstract class EducationEntity {
    private String name;

    public abstract List findFiveBestStudents();

    public abstract List createEntityList();
}
