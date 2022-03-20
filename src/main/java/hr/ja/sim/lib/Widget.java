package hr.ja.sim.lib;

import lombok.Getter;

import java.security.DigestInputStream;
import java.util.Random;

public abstract class Widget {

    @Getter
    private String id;

    public Widget() {
        id = WidgetUtil.widgetId();
    }

    public Js js() {
        return new Js();
    }


    public abstract String html();

}
