package hr.ja.sim.demo;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class User {

    private Integer id;
    private String name;
    private UserType type;

    public enum UserType {
        BIG, SMALL
    }
}
