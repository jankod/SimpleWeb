package hr.ja.sim.lib;

import io.javalin.http.Context;
import lombok.Getter;

public class Request {
    @Getter
    private Context context;

    public Request(Context context) {
        this.context = context;
    }


}
