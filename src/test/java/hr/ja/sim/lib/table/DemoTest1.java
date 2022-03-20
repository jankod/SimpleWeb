package hr.ja.sim.lib.table;

import io.javalin.Javalin;

import java.util.ArrayList;

public class DemoTest1 {

    public static void main(String[] args) {
        Javalin jav = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.showJavalinBanner = false;
        }).start(9000);

        jav.get("/", r -> {

            Table<User> t = new Table<>();
            t.addColumn("pero", user -> user.age);
            t.setData(user(1), user(2));


            r.html("dela ovo");
        });

    }

    private static User user(int id) {
        return new User();
    }
}

class MyPage1 {


    String js = """
            function hideElement(elementId) {
                document.getElementById(elementId).style.display = "none"
            }
                        
                        
            """;
}
