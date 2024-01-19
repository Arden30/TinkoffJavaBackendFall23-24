package edu.hw11.task3;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

public class FibonacciAppender implements ByteCodeAppender {
    private static final String CLASS_NAME = "FibonacciCalculator";
    private static final String METHOD_NAME = "fibonacci";
    private static final String METHOD_SIGNATURE = "(I)J";
    @Override
    public @NotNull Size apply(
        MethodVisitor mv,
        Implementation.@NotNull Context context,
        @NotNull MethodDescription md
    ) {
        mv.visitCode();

        // if (n <= 1)
        Label l1 = new Label();
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitInsn(Opcodes.ICONST_1);
        mv.visitJumpInsn(Opcodes.IF_ICMPGT, l1);

        // return n
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitInsn(Opcodes.I2L);
        mv.visitInsn(Opcodes.LRETURN);

        // if (n > 1)
        mv.visitLabel(l1);
        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);

        // fib(n - 1)
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitInsn(Opcodes.ICONST_1);
        mv.visitInsn(Opcodes.ISUB);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_NAME, METHOD_NAME, METHOD_SIGNATURE);

        // fib(n - 2)
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitInsn(Opcodes.ICONST_2);
        mv.visitInsn(Opcodes.ISUB);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_NAME, METHOD_NAME, METHOD_SIGNATURE);

        // fib(n - 1) + fib(n - 2);
        mv.visitInsn(Opcodes.LADD);
        mv.visitInsn(Opcodes.LRETURN);
        mv.visitEnd();

        return new ByteCodeAppender.Size(4, 1);
    }
}
