package hr.ja.sim.lib;

import hr.ja.sim.demo.Page1;
import hr.ja.sim.lib.js.Browser;
import j2html.tags.specialized.ButtonTag;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

import static j2html.TagCreator.button;

public class Button extends Widget implements ClickListener<Button> {


//    @JsonProperty("_name")
//    default String getComponentName() {
//        return this.getClass().getSimpleName();
//    }

//    @Getter
//    @Setter
//    private Consumer<AjaxRequest> ajaxHandler;

    @Getter
    @Setter
    private String label;

    public Button(String label) {
    }


//    public void click(Consumer<AjaxRequest> ajaxListener) {
//
//    }

    public Button(String label, String url) {

        this.label = label;
    }


    @Override
    public String html() {
        ButtonTag btn = button(label)
                .withId(getId());
        btn.renderFormatted();
        return """
                <button id='${getId()}' class='btn btn-primary'>${label()}</button>
                """;
    }

    public String label() {
        return label + "?";
    }

    public void onBrowser(Consumer<Browser> consumer) {
    }
}
