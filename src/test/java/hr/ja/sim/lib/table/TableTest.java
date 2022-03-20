package hr.ja.sim.lib.table;

import lombok.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TableTest {

    @Test
    void test1() {

    }

    public static void main(String[] args) {
        Table<User> table = new Table<>();
        table.addColumn("Name", User::getName);
        table.addColumn("Age", model -> String.valueOf(model.getAge()));

        TableWidget tableWidget = new TableWidget();
        
        tableWidget.renderTable(table);

    }
}

@Data
class User {
    int age;
    String name;
}
