package hr.ja.sim.lib.table;

import com.strobel.decompiler.Decompiler;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.PlainTextOutput;
import com.strobel.decompiler.languages.Languages;
import hr.ja.sim.demo.Page1;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.io.Serializable;
import java.io.StringWriter;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

public class ProcyonDemo {

    public static void main(String[] args) {

//        StopWatch s = StopWatch.createStarted();
//        ProcyonDemo.printClass(Page1.class);
//        s.stop();
//        System.out.println(DurationFormatUtils.formatDurationHMS(s.getTime()));
        Button b = new Button();
        b.browserClick(new Button.BrowserClickHandler() {
            @Override
            public void onCLick() {
                System.out.println("pozvao on click");
            }
        });
        b.browserClick(new Button.BrowserClickHandler() {
            @Override
            public void onCLick() {
                System.out.println("dva");
            }
        });
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

    }

    ;
}

class Button {

    @SneakyThrows
    void onClick(MyConsumer<AjaxReq> c) {
        // LambdaInspector.inspect(c);


        // Lambda inspect = LambdaInspector.inspect(ss);
        //String name = inspect.static_.accessedMemberInfo.member.getName();
        //     System.out.println(name);
    }


    public void browserClick(BrowserClickHandler c) {
        System.out.println("class hash code "+ c.hashCode());
        StopWatch s = StopWatch.createStarted();
        ProcyonDemo.printClass(c.getClass());
        s.stop();
        System.out.println(DurationFormatUtils.formatDurationHMS(s.getTime()));
    }

    public abstract static class BrowserClickHandler {
        public abstract void onCLick();
    }
}


class AjaxReq {

}
