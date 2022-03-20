package hr.ja.sim.lib.table;

public class TranscompileJsDemo {


    public static void main(String[] args) {

        String js = """
                let bodyId = document.body.id;
                """;



        met();

    }

    private static void met() {
        // let body = document.body.id
        String bodyId = Document.body.id;
    }
}


class Document {
    public static Body body = new Body();
}

class Body {
    public String id;
}
