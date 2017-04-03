package br.com.cpqd.platiot.user.facade.impl;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import br.com.cpqd.platiot.user.exception.BusinessException;
import br.com.cpqd.platiot.user.facade.api.UserFacadeLocal;
import br.com.cpqd.platiot.user.service.api.LoginService;
import br.com.cpqd.platiot.user.service.api.UserService;
import br.com.cpqd.platiot.user.to.LoginTO;
import br.com.cpqd.platiot.user.to.UserTO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserFacadeImpl implements UserFacadeLocal {
    @EJB
    private LoginService loginService;
    @EJB
    private UserService userService;

    @Override
    public List<UserTO> searchUserTO() {
        return userService.searchTO();
    }
    
    @Override
    public UserTO addUserTO(UserTO to) throws BusinessException, NoSuchAlgorithmException, NoSuchProviderException {
        return userService.add(to);
    }

    @Override
    public String login(LoginTO to) throws BusinessException, NoSuchAlgorithmException, NoSuchProviderException {
        return loginService.login(to);
    }
}