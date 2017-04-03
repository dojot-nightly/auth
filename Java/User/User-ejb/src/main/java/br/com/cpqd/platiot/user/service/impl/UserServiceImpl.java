package br.com.cpqd.platiot.user.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import br.com.cpqd.platiot.user.dao.api.UserDAO;
import br.com.cpqd.platiot.user.exception.BusinessException;
import br.com.cpqd.platiot.user.service.api.ActivePasswordService;
import br.com.cpqd.platiot.user.service.api.UserService;
import br.com.cpqd.platiot.user.to.UserTO;
import br.com.cpqd.platiot.user.utils.UserConstants;
import br.com.cpqd.platiot.user.vo.ActivePasswordVO;
import br.com.cpqd.platiot.user.vo.UserVO;

@Singleton
public class UserServiceImpl implements UserService {
    @EJB
    private UserDAO dao;
    @EJB
    private ActivePasswordService activePasswordService;

    @Override
    public UserVO findByLogin(String login) {
        UserVO user = dao.findByLogin(login);
        return user;
    }

    @Override
    public List<UserTO> searchTO() {
        List<UserVO> users = dao.search();
        List<UserTO> out = new ArrayList<UserTO>();
        UserTO to = null;
        for (UserVO user : users) {
            to = parseVOTO(user);
            out.add(to);
        }
        return out;
    }

    @Override
    public UserTO add(UserTO to) throws BusinessException, NoSuchAlgorithmException, NoSuchProviderException {
        validateTO(to);
        UserVO user = new UserVO();
        user.setLogin(to.getLogin());
        user.setName(to.getName());
        user = dao.add(user);
        ActivePasswordVO activePassword = activePasswordService.add(user, to.getPassword());
        return to;
    }

    private void validateTO(UserTO to) throws BusinessException {
        if ((to.getLogin() == null) || (to.getLogin().trim().isEmpty())) {
            throw new BusinessException(UserConstants.ERROR_INVALID_FIELD_LOGIN);
        }
        if ((to.getName() == null) || (to.getName().trim().isEmpty())) {
            throw new BusinessException(UserConstants.ERROR_INVALID_FIELD_PASSWORD);
        }
    }

    private UserTO parseVOTO(UserVO user) {
        UserTO out = new UserTO();
        out.setLogin(user.getLogin());
        out.setName(user.getName());
        out.setPassword(null);
        return out;
    }
}