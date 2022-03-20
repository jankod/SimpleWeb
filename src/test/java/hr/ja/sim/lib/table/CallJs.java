package hr.ja.sim.lib.table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static hr.ja.sim.lib.table.Jquery.$;

public class CallJs {

    public static void main(String[] args) {
        //   Doc.setTitle("pero");


        // {"className":"Jquery","params":["#id2"],"methods":[{"name":"hide","params":null}]}
        //   $("#id2").hide().show(true);

        $("#sada").on("click", new Consumer<JsEvent>() {
            @Override
            public void accept(JsEvent jsEvent) {

            }
        });
        FunctionResult result = $("#sdasd").nesto();
        $("#button").on("click", jsEvent -> $("#").show(true));

        System.out.println(JsGenerator.printAll());


        // $( "#button-container button" ).on( "click", function( event ) {
        //  hiddenBox.show();
        //});

    }
}

class FunctionResult {

}

class Doc {

}

interface MethodParams {

    default String name() {
        return this.toString();
    }
}

@FunctionalInterface
interface EventListener<T> extends MethodParams {

    void accept(T t);

    @Override
    default String name() {
        return "function";
    }
}

class Jquery {

    private CallObject callObject;

    private Jquery(String id) {
        callObject = new CallObject("Jquery", id);
    }

    public static Jquery $(String id) {
        return new Jquery(id);
    }


    public Jquery hide() {
        callObject.method("hide");
        return this;
    }

    public Jquery show(boolean slowly) {
        callObject.method("show", String.valueOf(slowly));
        return this;
    }

    public void on(String eventName, Consumer<JsEvent> func) {
        callObject.method("on", eventName, func);
    }

    public FunctionResult nesto() {
        return null;
    }
}

class JsEvent {

}

class JsGenerator {

    private static final List<CallObject> callObjectList = new ArrayList<>();

    public static void add(CallObject callObject) {
        callObjectList.add(callObject);
    }

    public static String printAll() {
        return callObjectList.stream().map(CallObject::toString).collect(Collectors.joining());
    }
}

@Data
class CallObject {

    private String className;

    private String[] params;
    private List<MethodCalls> methods = new ArrayList<>();

    public CallObject(String className, String... params) {
        this.className = className;
        this.params = params;
        JsGenerator.add(this);
    }

    public void method(String methodName) {
        methods.add(new MethodCalls(methodName));
    }

    public void method(String methodName, Object... params) {
        methods.add(new MethodCalls(methodName, params));
    }

    public void method(String methodName, Consumer<JsEvent> func) {
        methods.add(new MethodCalls(methodName, func));
    }


    private static ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public String toString() {
        return mapper.writeValueAsString(this);
    }
}


@Data
@AllArgsConstructor
class MethodCalls {
    String name;
    List<String> params;

    public MethodCalls(String name) {
        this.name = name;
    }

    public MethodCalls(String name, Object... params) {
        this.name = name;
        if (params != null) {
            this.params = new ArrayList<>();
            for (Object param : params) {
                if (param instanceof MethodParams) {
                    MethodParams p = (MethodParams) param;
                    this.params.add(p.name());
                    continue;
                }

                String toString = param.toString();
                this.params.add(toString);
            }
        }

    }
}

