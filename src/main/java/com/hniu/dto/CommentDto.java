package com.hniu.dto;

import com.hniu.entity.Comment;
import com.hniu.entity.User;

/**
 * @Author: 熊俊
 * @Date: 2018/10/12 20:29
 * @Description:
 * @Modified By:
 */
public class CommentDto extends Comment {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
