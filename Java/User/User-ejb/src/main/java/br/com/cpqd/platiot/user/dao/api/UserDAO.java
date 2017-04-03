package br.com.cpqd.platiot.user.dao.api;

import java.util.List;

import br.com.cpqd.platiot.user.vo.UserVO;

public interface UserDAO {
    List<UserVO> search();
    
    UserVO findByLogin(String login);

    UserVO add(UserVO vo);
}
