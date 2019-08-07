package jblog.guohai.org.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户实体类
 */
@Entity
public class UserModel {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 用户编号
     */
    @Getter
    @Setter
    private int userCode;

    /**
     * user name
     */
    @Getter
    @Setter
    private String userName;

    /**
     * user password
     */
    @Getter
    @Setter
    private String userPass;

    /**
     * pass key
     * password = md5(md5(origin_pass)+pass_key)
     */
    @Getter
    @Setter
    private String userKey;


}
