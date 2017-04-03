package br.com.cpqd.platiot.user.service.api;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import br.com.cpqd.platiot.user.exception.BusinessException;
import br.com.cpqd.platiot.user.to.LoginTO;

public interface LoginService {
    String login(LoginTO to) throws BusinessException, NoSuchAlgorithmException, NoSuchProviderException;
}