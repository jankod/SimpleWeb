package hr.ja.sim.lib.comp;

import hr.ja.sim.lib.Widget;

public class Card extends AbstractWidget implements ILabel<Card> {

    private String label;

    public static void main(String[] args) {
        Card c = new Card();
        c.setLabel("moj card");

        But but = new But();
    }

}


class But extends AbstractWidget {


    @Override
    public String html() {
        return super.html();
    }
}

class StaticUtil {

    private static StaticUtil instance = new StaticUtil();

    private StaticUtil() {
    }

    public static StaticUtil get() {
        return instance;
    }

    public <W extends IWidget> void setLabel(ILabel<W> labeled, String label) {
        sendCommand("setLabel", labeled.getWidget().getId(), label);
    }

    private void sendCommand(String command, String componentId, String... values) {

    }

}

class AbstractWidget extends Widget implements IWidget {

    private Widget w;

    AbstractWidget() {
        w = this;
    }

    @Override
    public String html() {
        return "NOT IMPLEMENTED";
    }

    @Override
    public Widget getWidget() {
        return w;
    }
}

interface IWidget {
    Widget getWidget();
}

interface ILabel<W extends IWidget> extends IWidget {

    default void setLabel(String label) {
        StaticUtil.get().setLabel(this, label);
    }

    default String getLabel() {
        getWidget().getId();
        return "";
    }
}
