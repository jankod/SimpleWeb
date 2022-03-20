package hr.ja.sim.lib;

import j2html.TagCreator;

import java.util.function.Consumer;

public class PageCreator {

    public ToolBarModel getToolBar() {
        return new ToolBarModel();
    }

    public Button addButton(String label, Consumer<AjaxRequest> ajaxRequest) {
        Class<? extends Consumer> aClass = ajaxRequest.getClass();

        return new Button(label);
    }

    public RowLayout row() {
        return null;
    }
}
