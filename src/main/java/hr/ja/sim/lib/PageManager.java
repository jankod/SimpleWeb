package hr.ja.sim.lib;

import lombok.SneakyThrows;

public class PageManager {
    private final Route route;

    private Class<? extends WebPage> pageClass;

    public PageManager(Class<? extends WebPage> pageClass) {
        this.pageClass = pageClass;
        route = pageClass.getAnnotation(Route.class);
    }

    public String getPageUrl() {
        return route.value();
    }

    @SneakyThrows
    public void onRequest(Request request) {
        //HttpSession session = request.getContext().req.getSession();
        WebPage webPage = pageClass.getDeclaredConstructor().newInstance();
        webPage.onRequest(request);
    }
}
