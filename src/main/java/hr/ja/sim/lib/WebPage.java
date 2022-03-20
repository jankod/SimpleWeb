package hr.ja.sim.lib;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class WebPage {

    @Getter
    protected List<Widget> widgets = new ArrayList<>();

    public void add(Widget w) {
        widgets.add(w);
    }

    public void onRequest(Request request) {

    }
}
