package edu.hw2.task4;

public class CallingInfoUtil {

    private CallingInfoUtil() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement method = new Throwable().getStackTrace()[1];
        return new CallingInfo(method.getClassName(), method.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {

    }
}
