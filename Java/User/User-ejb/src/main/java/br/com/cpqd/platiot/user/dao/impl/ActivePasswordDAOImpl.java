package br.com.cpqd.platiot.user.dao.impl;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.cpqd.platiot.user.dao.api.ActivePasswordDAO;
import br.com.cpqd.platiot.user.vo.ActivePasswordVO;

@Singleton
public class ActivePasswordDAOImpl implements ActivePasswordDAO {
    @PersistenceContext(unitName = "userPU")
    private EntityManager em;

    @Override
    public ActivePasswordVO add(ActivePasswordVO activePassword) {
        activePassword = em.merge(activePassword);
        return activePassword;
    }

    @Override
    public ActivePasswordVO findByUser(Integer idUser) {
        StringBuilder hql = new StringBuilder("SELECT obj FROM ActivePasswordVO obj WHERE obj.user.id = :idUser");
        Query query = em.createQuery(hql.toString());
        query.setParameter("idUser", idUser);
        ActivePasswordVO out = (ActivePasswordVO) query.getSingleResult();
        return out;
    }
}