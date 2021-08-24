package org.goldstine;

/**
 * 自定义一个运行时异常
 */
public class RuntimeExceptionDefinition extends RuntimeException{
    public RuntimeExceptionDefinition() {
    }

    public RuntimeExceptionDefinition(String message) {
        super(message);
    }

    public RuntimeExceptionDefinition(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeExceptionDefinition(Throwable cause) {
        super(cause);
    }

    public RuntimeExceptionDefinition(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
