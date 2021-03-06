package com.example.hassan.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.hassan.roomdatabase.entity.Comment;
import com.example.hassan.roomdatabase.entity.Post;
import com.example.hassan.roomdatabase.entity.User;

import java.util.List;

@Dao
public interface ModelDao {

    @Query("Select user.* " +
            "from user " +
            "join comment " +
            "on comment.user_id = user.userId " +
            "join post " +
            "on post.id = comment.post_id " +
            "where post.id = :postId")
    List<User> findUserListByPostId(int postId);

    @Query("select comment.* from comment where comment.post_id = :postId")
    List<Comment> findCommentsByPostId(int postId);


    @Query("Select comment.* from comment where comment.user_id = :userId")
    List<Comment> findCommentsByUserId(int userId);

    @Query("select count(*) from comment where comment.user_id = :userId")
    int countCommentsByUserId(int userId);

    @Insert
    void insertUsers(User... users);


    @Insert
    void insertPosts(Post... posts);

    @Insert
    void insertComments(Comment... comments);


}
