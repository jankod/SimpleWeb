package hr.ja.sim.lib.table;

import de.mirkosertic.bytecoder.allocator.Allocator;
import de.mirkosertic.bytecoder.backend.CompileOptions;
import de.mirkosertic.bytecoder.backend.CompileResult;
import de.mirkosertic.bytecoder.backend.CompileTarget;
import de.mirkosertic.bytecoder.backend.LLVMOptimizationLevel;
import de.mirkosertic.bytecoder.core.*;
import de.mirkosertic.bytecoder.optimizer.KnownOptimizer;
import de.mirkosertic.bytecoder.unittest.Slf4JLogger;

import java.io.*;
import java.lang.reflect.Method;

public class TranspileDemo {
    public static StringFunction exclaim = (s) -> s + "!";

    public static void main(String[] args) {

    }

    public static void main1(String[] args) throws IOException {

        CompileTarget t = new CompileTarget(ClassLoader.getSystemClassLoader(), CompileTarget.BackendType.js);
        CompileOptions theOptions = new CompileOptions(new Slf4JLogger(), false, KnownOptimizer.NONE, true, "pref_", 512,
                1024, false, false,
                Allocator.linear, new String[0], new String[0],
                LLVMOptimizationLevel.defaultValue(), false);

        final BytecodeMethodSignature theSignature = new BytecodeMethodSignature(BytecodePrimitiveTypeRef.VOID,
                new BytecodeTypeRef[]{new BytecodeArrayTypeRef(BytecodeObjectTypeRef.fromRuntimeClass(String.class), 1)});

        // CompileResult theCode = theCompileTarget.compile(theOptions, theTargetClass, "main", theSignature);
        CompileResult result = t.compile(theOptions, exclaim.getClass(), "main", theSignature);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        for (CompileResult.Content content : result.getContent()) {
            System.out.println(content.getFileName());
            //content.writeTo(out);
        }
        System.out.println(new String(out.toByteArray()));

        Method m;


    }



}



class Pero {
    String name;

    public static void main(String[] args) {
        int dada = 2 + 33;
        double pero = dada / 32;

    }
}
