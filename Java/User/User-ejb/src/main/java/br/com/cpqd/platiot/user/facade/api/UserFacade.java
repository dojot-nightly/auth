package br.com.cpqd.platiot.user.facade.api;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import br.com.cpqd.platiot.user.exception.BusinessException;
import br.com.cpqd.platiot.user.to.LoginTO;
import br.com.cpqd.platiot.user.to.UserTO;

public interface UserFacade {
    /*
     * Users
     */
    List<UserTO> searchUserTO();

    UserTO addUserTO(UserTO to) throws BusinessException, NoSuchAlgorithmException, NoSuchProviderException;

    String login(LoginTO to) throws BusinessException, NoSuchAlgorithmException, NoSuchProviderException;
}