package hr.ja.sim.lib.table;

import com.github.ruediste.lambdaInspector.Lambda;
import com.github.ruediste.lambdaInspector.LambdaInspector;
import com.github.ruediste.lambdaInspector.expr.ExpressionVisitor;
import com.strobel.assembler.InputTypeLoader;
import com.strobel.assembler.metadata.ClasspathTypeLoader;
import com.strobel.decompiler.AnsiTextOutput;
import com.strobel.decompiler.Decompiler;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.PlainTextOutput;
import com.strobel.decompiler.ast.Expression;
import com.strobel.decompiler.languages.Language;
import com.strobel.decompiler.languages.Languages;
import hr.ja.sim.lib.Route;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;

import java.io.Serializable;
import java.io.StringWriter;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.function.Consumer;

public class ProcyonDemo {

    @SneakyThrows
    public static void main2(String[] args) {
        Button b = new Button();

//        SerializedLambda serializedLambda = getSerializedLambda(myLa);
//        StringWriter s = new StringWriter();
//        Decompiler.decompile(getClassName(serializedLambda.getClass()), new PlainTextOutput(s));
//        System.out.println(s);
        //b.onClick(myLa);

    }

    public static void main(String[] args) {

     //   LambdaInspector.setup();
        Button b = new Button();
        b.onClick(ajaxReq -> {
            int adqwd = 123 + 12;
            String pero = new String();
            int demo = Integer.parseInt(String.valueOf(adqwd));
            System.out.println(demo);
        });

        ProcyonDemo.printClass(ProcyonDemo.class);
    }


    static String getClassName(Class<? extends Serializable> c) {
        String name = ClassUtils.getName(c);
        System.out.println(name);
        String replace = name.replace(".", "/");
        //  System.out.println(replace);
        return replace;
    }

    @SneakyThrows
    public static void printClass(Class cc) {

        //   SerializedLambda ss = getSerializedLambda(cc);
        //  cc = ss.getClass();

        StringWriter s = new StringWriter();
        //Decompiler.decompile(getClassName(cc), new AnsiTextOutput(s));
        // hr/ja/sim/lib/table/ProcyonDemo$$Lambda$15/0x0000000800c01a20
        DecompilerSettings set = DecompilerSettings.javaDefaults();
        //set.setTypeLoader(new ClasspathTypeLoader());
        set.setLanguage(Languages.java());
        Decompiler.decompile(getClassName(cc), new PlainTextOutput(s), set);
        System.out.println(s);
    }

    static SerializedLambda getSerializedLambda(Serializable lambda) throws Exception {
        final Method method = lambda.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(true);
        return (SerializedLambda) method.invoke(lambda);
    }

    public static void printClass(SerializedLambda sl) {
        StringWriter s = new StringWriter();
        String name = sl.getCapturingClass();
       // name = sl.getImplClass()+"."+sl.getImplMethodName()+":"+sl.getImplMethodSignature();
        //implClass, implMethodName, implMethodSignature,
          //      %s.%s:%s
        System.out.println(name);
        System.out.println(sl);
        Decompiler.decompile(name, new PlainTextOutput(s));
        System.out.println(s);
    }

}

@FunctionalInterface
interface MyConsumer<T> extends Serializable {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t);

    default void pero() {

    };
}

class Button {

    @SneakyThrows
    void onClick(MyConsumer<AjaxReq> c) {
       // LambdaInspector.inspect(c);



        // Lambda inspect = LambdaInspector.inspect(ss);
        //String name = inspect.static_.accessedMemberInfo.member.getName();
        //     System.out.println(name);
    }


}

class AjaxReq {

}
