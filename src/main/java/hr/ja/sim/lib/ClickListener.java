package hr.ja.sim.lib;

import java.util.function.Consumer;

public interface ClickListener<W extends Widget> {

    default Consumer<AjaxRequest> getClickHandler() {
        return null;
    }
    default void click(Consumer<AjaxRequest> handler) {

    }

}
