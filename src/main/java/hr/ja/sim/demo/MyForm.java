package hr.ja.sim.demo;


import hr.ja.sim.lib.form.FormModel;
import hr.ja.sim.lib.form.SelectModel;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Data
@FieldNameConstants
public class MyForm extends FormModel {

    private String name;

    private Integer age = 22;

    private Integer age2;

    private LocalDateTime time;

    public MyForm() {
        addText("Name", Fields.name);

        addSelect("Age", Fields.age, "2", "30", "4", 555, 44, 22);

        addDateTime("Time", Fields.time);

        SelectModel select = addSelect("Age2", Fields.age2)
                .labelValueSelected("Select something", null)
                .labelValue("22", 22)
                .labelValue("55", 55);

        addSubmit("Save");

    }
}
