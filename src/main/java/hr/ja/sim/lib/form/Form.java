package hr.ja.sim.lib.form;

import hr.ja.sim.demo.User;
import hr.ja.sim.lib.Widget;
import hr.ja.sim.lib.bs.BootstrapFormTheme;


public class Form<M> extends Widget {
    private M model;

    public Form(M model) {
        this.model = model;
    }

    public void add(FormField<M> field) {

    }


    @Override
    public String html() {
        return null;
    }
}
