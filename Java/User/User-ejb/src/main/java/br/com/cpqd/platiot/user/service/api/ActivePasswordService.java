package br.com.cpqd.platiot.user.service.api;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import br.com.cpqd.platiot.user.vo.ActivePasswordVO;
import br.com.cpqd.platiot.user.vo.UserVO;

public interface ActivePasswordService {
    ActivePasswordVO findByUser(Integer idUser);

    ActivePasswordVO add(UserVO user, String password) throws NoSuchAlgorithmException, NoSuchProviderException;
}