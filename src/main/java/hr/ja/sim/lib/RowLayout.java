package hr.ja.sim.lib;

import hr.ja.sim.lib.form.TextField;

public class RowLayout extends Layout {

    private ColLayout parent;

    public RowLayout() {
    }

    public RowLayout col(int i) {
        return this;
    }

    public RowLayout col(Widget w) {
        return this;
    }

    public RowLayout col(int num, Widget txtEnter) {
        return null;
    }
}
