package hr.ja.sim.lib.form;

import hr.ja.sim.lib.IModel;
import hr.ja.sim.lib.IWidget;

public class FormModel implements IModel {

    public void addSubmit(String save) {
    }

    public SelectModel addSelect(String age, String age1, Object... values) {
        return new SelectModel();

    }

    public void addText(String name, String name1) {
    }

    public DateTimeChooser addDateTime(String time, String time1) {
        return new DateTimeChooser();
    }

    @Override
    public Class<? extends IWidget> widget() {
        return FormWidget.class;
    }
}
