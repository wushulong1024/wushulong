package com.qs.entity;
/**
 * @author shkstart
 * @create 2019-08-10 13:25
 */

public class Userti {
    private  Integer id;
    private  String username;
    private  String password;
    private  int type;
    private  String nicheng;

    public Userti() {}

    public Userti(String username, String password, int type, String nicheng) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.nicheng = nicheng;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNicheng() {
        return nicheng;
    }

    public void setNicheng(String nicheng) {

        this.nicheng = nicheng;
    }

    @Override
    public String toString() {
        return "Userti{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", nicheng='" + nicheng + '\'' +
                '}';
    }
}
