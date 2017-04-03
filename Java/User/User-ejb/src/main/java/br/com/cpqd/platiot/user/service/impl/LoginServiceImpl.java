package br.com.cpqd.platiot.user.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import br.com.cpqd.platiot.user.dao.api.UserDAO;
import br.com.cpqd.platiot.user.exception.BusinessException;
import br.com.cpqd.platiot.user.service.api.ActivePasswordService;
import br.com.cpqd.platiot.user.service.api.KeyGeneratorService;
import br.com.cpqd.platiot.user.service.api.LoginService;
import br.com.cpqd.platiot.user.service.api.UserService;
import br.com.cpqd.platiot.user.to.LoginTO;
import br.com.cpqd.platiot.user.utils.UserConstants;
import br.com.cpqd.platiot.user.vo.ActivePasswordVO;
import br.com.cpqd.platiot.user.vo.UserVO;

@Singleton
public class LoginServiceImpl implements LoginService {
    @EJB
    private UserDAO dao;
    @EJB
    private ActivePasswordService activePasswordService;
    @EJB
    private KeyGeneratorService keyGeneratorService;
    @EJB
    private UserService userService;

    @Override
    public String login(LoginTO to) throws BusinessException, NoSuchAlgorithmException, NoSuchProviderException {
        validateLogin(to);
        UserVO user = userService.findByLogin(to.getLogin());
        if ((user == null) || (user.getId() == null)) {
            throw new BusinessException(UserConstants.ERROR_INVALID_LOGIN);
        }
        ActivePasswordVO activePassword = activePasswordService.findByUser(user.getId());
        String hashPassword = keyGeneratorService.generateHash(to.getPassword(), activePassword.getSalt());
        if (!(hashPassword.equals(activePassword.getHash().trim()))) {
            throw new BusinessException(UserConstants.ERROR_INVALID_LOGIN);
        }
        return to.getPassword();
    }

    private void validateLogin(LoginTO to) throws BusinessException {
        if ((to.getLogin() == null) || (to.getLogin().trim().isEmpty())) {
            throw new BusinessException(UserConstants.ERROR_INVALID_FIELD_LOGIN);
        }
        if ((to.getPassword() == null) || (to.getPassword().trim().isEmpty())) {
            throw new BusinessException(UserConstants.ERROR_INVALID_FIELD_PASSWORD);
        }
    }
}