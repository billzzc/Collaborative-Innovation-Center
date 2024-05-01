package com.aiit.hexlab.common.core.domain.model;

/**
 * 用户注册对象
 * 
 * @author Zkoi
 */
public class RegisterBody extends LoginBody
{

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
