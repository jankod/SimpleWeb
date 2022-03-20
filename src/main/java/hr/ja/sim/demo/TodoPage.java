package hr.ja.sim.demo;

import hr.ja.sim.lib.*;
import hr.ja.sim.lib.form.TextField;

public class TodoPage extends WebPage {

    @Override
    public void onRequest(Request request) {


        TextField txtEnter = new TextField("Enter todo");
        Button b = new Button("Add");

        RowLayout row = new RowLayout();
        row.col(6, txtEnter).col(b);

        txtEnter.js().callFunc("handleThis", txtEnter.getId());

        ListGroup lg = new ListGroup();
        //txtEnter.js().on("keypress:enter", "");


    }
}
