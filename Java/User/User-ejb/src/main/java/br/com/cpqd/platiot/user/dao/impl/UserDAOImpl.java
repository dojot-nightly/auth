package br.com.cpqd.platiot.user.dao.impl;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.cpqd.platiot.user.dao.api.UserDAO;
import br.com.cpqd.platiot.user.vo.UserVO;

@Singleton
public class UserDAOImpl implements UserDAO {
    @PersistenceContext(unitName = "userPU")
    private EntityManager em;

    @Override
    public List<UserVO> search() {
        StringBuilder hql = new StringBuilder("SELECT obj FROM UserVO obj");
        Query query = em.createQuery(hql.toString());
        List<UserVO> users = query.getResultList();
        return users;
    }

    @Override
    public UserVO findByLogin(String login) throws NoResultException {
        try {
            StringBuilder hql = new StringBuilder("SELECT obj FROM UserVO obj WHERE obj.login = :login");
            Query query = em.createQuery(hql.toString());
            query.setParameter("login", login);
            UserVO user = (UserVO) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public UserVO add(UserVO vo) {
        vo = em.merge(vo);
        return vo;
    }
}
