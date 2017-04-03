package br.com.cpqd.platiot.user.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import br.com.cpqd.platiot.user.dao.api.ActivePasswordDAO;
import br.com.cpqd.platiot.user.service.api.ActivePasswordService;
import br.com.cpqd.platiot.user.service.api.KeyGeneratorService;
import br.com.cpqd.platiot.user.vo.ActivePasswordVO;
import br.com.cpqd.platiot.user.vo.UserVO;

@Singleton
public class ActivePasswordServiceImpl implements ActivePasswordService {
    @EJB
    private ActivePasswordDAO dao;
    @EJB
    private KeyGeneratorService keyGeneratorService;

    @Override
    public ActivePasswordVO findByUser(Integer idUser) {
        ActivePasswordVO activePassword = dao.findByUser(idUser);
        return activePassword;
    }

    @Override
    public ActivePasswordVO add(UserVO user, String password) throws NoSuchAlgorithmException, NoSuchProviderException {
        byte[] salt = keyGeneratorService.generateSalt();
        String hash = keyGeneratorService.generateHash(password, salt);
        ActivePasswordVO activePassword = new ActivePasswordVO();
        activePassword.setDate(new Date());
        activePassword.setHash(hash);
        activePassword.setSalt(salt);
        activePassword.setUser(user);
        activePassword = dao.add(activePassword);
        return activePassword;
    }
}