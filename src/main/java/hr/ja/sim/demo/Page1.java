package hr.ja.sim.demo;


import hr.ja.sim.lib.*;
import hr.ja.sim.lib.form.Form;
import hr.ja.sim.lib.form.ChoiceBox;
import hr.ja.sim.lib.form.TextField;
import hr.ja.sim.lib.table.Table;

import static java.util.Comparator.comparing;

@Route(Url.page1)
public class Page1 extends WebPage {


    @Reactive
    Button btn;

    @Override
    public void onRequest(Request request) {
        Button btn1 = new Button("Klikni me", Url.buttonClick);

        Button btnClick2 = new Button("Click 2");
        btnClick2.click(req -> {
            req.js().element(btnClick2.getId()).remove();
            req.js().element("ppp").show();
        });

        btnClick2.onBrowser(browser -> {
            browser.document().on(btn1).remove();
            browser.exec("""
                    document.title = "pero";
                    """);
        });

        add(btn1);


        add(btnClick2);

        btn1.js().onClick("ajax", "");

//        btn1.click(req -> {
//            btn1.setLabel("Ovo je button 222");
//            req.updateWidget(btn1);
//            req.js().callFunc("func1", "param1", "param2");
//        });

        createTable();

        createUserForm();
    }

    private void createUserForm() {
        Form<User> form = new Form<>(new User());

        form.add(new TextField<>("Name", User.Fields.name));
        ChoiceBox<User> selectType = new ChoiceBox<>("Type");
        selectType.addValue("Pero", User.UserType.BIG);
        form.add(selectType);

        add(form);
    }

    private void createTable() {
        Table<User> table = new Table<>();
        table.addColumn("ID", User::getId).sort(comparing(User::getName));
        table.addColumn("Name", User::getName);

        add(table);
    }

    @Route(Url.buttonClick)
    public static void onClick(AjaxRequest req) {

        //req.js()
    }

}

class JsUtil {
    public static void main(String[] args) {
        getElementById("pero");
    }

    static String getElementById(String elementId) {
        return """
                return document.getElementById(elementId);
                """;
    }
}
