package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserVO implements Serializable {
    private Integer uid;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String mail;

    /**
     *
     */
    private String role;

    private String name;

    /**
     *
     */
    private String no;

    /**
     *
     */
    private String school;

    /**
     *
     */
    private String profession;

    private List<Course> courses;

    @Override
    public String toString() {
        return "UserVO{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", school='" + school + '\'' +
                ", profession='" + profession + '\'' +
                ", courses=" + courses +
                '}';
    }
}
