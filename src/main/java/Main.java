import hr.ja.sim.demo.Page1;
import hr.ja.sim.lib.WebApp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        WebApp webApp = new WebApp();

        webApp.addPage(Page1.class);

        webApp.start(8666);

    }
}
