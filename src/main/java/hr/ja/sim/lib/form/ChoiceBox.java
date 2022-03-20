package hr.ja.sim.lib.form;

import java.util.ArrayList;
import java.util.List;

public class ChoiceBox<M> extends FormField<M> {

    private List<ChoiceKeyValue> keyValueList = new ArrayList<>();

    public enum ChoiceBoxType {
        // one select
        CHECKBOX, SELECT
    }


    public ChoiceBox(String fieldLabel) {

    }

    public void addValue(String valueLabel, Object value) {
            keyValueList.add(new ChoiceKeyValue());
    }
}
