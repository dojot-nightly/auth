package br.com.cpqd.platiot.user.exception;

public abstract class AbstractBusinessException extends GenericException {
    public AbstractBusinessException(String code) {
        super(code);
    }

    public AbstractBusinessException(String code, Throwable cause) {
        super(code, cause);
    }

    public AbstractBusinessException(String code, Object[] messageParameters) {
        super(code, messageParameters);
    }

    public AbstractBusinessException(String code, Throwable cause, Object[] messageParameters) {
        super(code, cause, messageParameters);
    }
}
