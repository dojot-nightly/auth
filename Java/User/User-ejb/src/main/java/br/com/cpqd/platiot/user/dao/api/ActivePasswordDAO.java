package br.com.cpqd.platiot.user.dao.api;

import br.com.cpqd.platiot.user.vo.ActivePasswordVO;

public interface ActivePasswordDAO {
    ActivePasswordVO add(ActivePasswordVO activePassword);

    ActivePasswordVO findByUser(Integer idUser);
}