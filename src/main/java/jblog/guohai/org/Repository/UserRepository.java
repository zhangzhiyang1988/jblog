package jblog.guohai.org.Repository;

import jblog.guohai.org.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author:Zhangzy
 * Date:2019/8/7
 * Time:17:00
 */
public interface UserRepository extends JpaRepository<UserModel,Long> {

    UserModel findUserModelByUserName(String userName);
}
