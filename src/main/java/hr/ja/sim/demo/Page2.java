package hr.ja.sim.demo;

import hr.ja.sim.lib.*;
import hr.ja.sim.lib.comp.Card;
import io.javalin.http.Context;
import lombok.experimental.ExtensionMethod;

import java.util.function.Consumer;

public class Page2 extends WebPage {

    public void onRequest(Request request, PageCreator page) {
        page.getToolBar();
        page.addButton("Click me", Page2::klikni);
        RowLayout row = page.row();

        page.row().col(2).col(2).col(2);
        row.col(6);


    }

    class PrepareAjax {

        public Object syncComponents(ISyncableWidget syncableWidget) {

            return null;
        }

        public PrepareAjax onClient(ClientActions a) {
            return null;
        }
    }

    class ClientActions {

    }

    interface ISyncableWidget {

    }


    void prepareAjax(PrepareAjax prepare) {

    }

    private static void klikni(AjaxRequest ajax) {

    }

    public static void main(String[] args) {
        Page2 page2 = new Page2();
        page2.onRequest(new Request(null), new PageCreator());
    }
}
