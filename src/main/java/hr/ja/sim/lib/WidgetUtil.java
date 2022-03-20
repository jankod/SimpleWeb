package hr.ja.sim.lib;

import java.util.Random;

public class WidgetUtil {
    public static String widgetId() {
        return new Random().nextInt(1, 2232432) + "";
    }
}
