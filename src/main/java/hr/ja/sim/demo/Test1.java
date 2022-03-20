package hr.ja.sim.demo;

import java.io.Serializable;
import java.lang.invoke.MethodType;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.function.Consumer;

public class Test1 {

    static Method lambdaToMethod(Serializable lambda) {
        for(Class<?> cl=lambda.getClass(); cl!=null; cl=cl.getSuperclass()) try {
            Method m=cl.getDeclaredMethod("writeReplace");
            m.setAccessible(true);
            try {
                SerializedLambda sl=(SerializedLambda)m.invoke(lambda);
                return Test1.class.getDeclaredMethod(sl.getImplMethodName(),
                        MethodType.fromMethodDescriptorString(sl.getImplMethodSignature(),
                                Test1.class.getClassLoader()).parameterArray());
            } catch(ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }
        } catch(NoSuchMethodException ex){}
        throw new AssertionError();
    }
    public static void main(String[] args)
    {
        Serializable stringConsumer = (Consumer<String> & Serializable)
                s -> System.out.println("first lambda called with " + s);

        legacyCaller("a string", lambdaToMethod(stringConsumer));
        legacyCaller("a string", lambdaToMethod((Consumer<String>&Serializable)
                s -> System.out.println("second lambda called with "+s)));
    }

    public static void legacyCaller(Object arg, Method m) {
        System.out.println("calling Method \""+m.getName()+"\" reflectively");
        try {
            m.invoke(null, arg);
        } catch(ReflectiveOperationException ex) {
            ex.printStackTrace();
        }
    }
}
