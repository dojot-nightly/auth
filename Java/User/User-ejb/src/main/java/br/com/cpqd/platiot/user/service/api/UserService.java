package br.com.cpqd.platiot.user.service.api;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import br.com.cpqd.platiot.user.exception.BusinessException;
import br.com.cpqd.platiot.user.to.UserTO;
import br.com.cpqd.platiot.user.vo.UserVO;

public interface UserService {
    UserVO findByLogin(String login);

    List<UserTO> searchTO();

    UserTO add(UserTO to) throws BusinessException, NoSuchAlgorithmException, NoSuchProviderException;
}