package com.example.hassan.roomdatabase.utility;

import android.util.Log;

import com.example.hassan.roomdatabase.AppDataBase;
import com.example.hassan.roomdatabase.entity.Comment;
import com.example.hassan.roomdatabase.entity.User;

import java.util.List;

public class ShowLog {

    AppDataBase database;

    public ShowLog(AppDataBase database) {
        this.database=database;
    }

    public void displayUserListByPostId(int postId) {

        List<User> users = database.DBDao().findUserListByPostId(postId);

        if (users == null)
            return;

        for (User user: users) {
            Log.d("Users", "User id: " + user.getUserId() + ", User Name: "
                    + user.getName() + ", User Family: " + user.getFamily()
                    + ", User avatr: " + user.getAvatar() + ",User nationlCode:" + user.getNationalCode());
        }
    }


    public void displayCommentsByPostId(int postId) {

        List<Comment> comments = database.DBDao().findCommentsByPostId(postId);

        if (comments == null)
            return;

        for (Comment comment: comments) {
            Log.d("Comments", "Comment id: " + comment.getId() + ", Comment userId: "
                    + comment.getUserId() + ", Comment postId: " + comment.getPostId()
                    + ", Comment text: " + comment.getCommentText());
        }
    }


    public void displayCommentsByUserId(int userId) {

        List<Comment> comments = database.DBDao().findCommentsByUserId(userId);

        if (comments == null)
            return;

        for (Comment comment: comments) {
            Log.d("Comments", "Comment id: " + comment.getId() + ", Comment userId: "
                    + comment.getUserId() + ", Comment postId: " + comment.getPostId()
                    + ", Comment Text: " + comment.getCommentText());
        }
    }

    public void displayCommentsNumberByUserId(int userId) {
        int num = database.DBDao().countCommentsByUserId(userId);
        Log.d("Comments number", num+"");

    }


}
