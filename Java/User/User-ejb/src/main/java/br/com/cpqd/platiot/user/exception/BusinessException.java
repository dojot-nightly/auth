package br.com.cpqd.platiot.user.exception;

import java.util.Locale;

public class BusinessException extends AbstractBusinessException {
    private static final long serialVersionUID = -4791504822148510903L;

    public BusinessException(String code) {
        super(code);
    }

    @Override
    public String getBundleName() {
        return "user_exceptions";
    }

    @Override
    public Locale getLocale() {
        return Locale.getDefault();
    }
}
