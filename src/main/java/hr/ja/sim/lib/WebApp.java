package hr.ja.sim.lib;

import io.javalin.Javalin;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class WebApp {

    private List<Class<? extends WebPage>> pagesClasses = new ArrayList<>();
    private Javalin javalin;

    public void addPage(Class<? extends WebPage> page) {
        pagesClasses.add(page);
    }

    @SneakyThrows
    public void start(int port) {
        javalin = Javalin.create(c->{
            c.showJavalinBanner = false;
            c.enableCorsForAllOrigins();
        }).start(port);

        initPages();


    }

    private void initPages() {
        for (Class<? extends WebPage> pageClass : pagesClasses) {
            PageManager page = new PageManager(pageClass);
            javalin.get(page.getPageUrl(), context -> {
                page.onRequest(new Request(context));
            });
        }
    }
}
