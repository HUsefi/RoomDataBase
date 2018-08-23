package com.example.hassan.roomdatabase.utility;

import com.example.hassan.roomdatabase.AppDataBase;
import com.example.hassan.roomdatabase.entity.Comment;
import com.example.hassan.roomdatabase.entity.Post;
import com.example.hassan.roomdatabase.entity.User;

public class DatabaseInitializer {
    private static DatabaseInitializer instance;
    private static AppDataBase dataBase;

    public static DatabaseInitializer with(AppDataBase appDataBase) {

        if (dataBase == null)
            dataBase = appDataBase;

        if (instance == null)
            instance = new DatabaseInitializer();

        return instance;
    }
    public void generateAppDetails() {
        if (dataBase == null)
            return;

        User[] users = new User[5];
        users[0] = userInstance(1, "Hossein", "Yousefi" , "", 61);
        users[1] = userInstance(2, "Vahid", "Talaei" , "", 21);
        users[2] = userInstance(3, "Amirreza", "Fahimi", "", 31);
        users[3] = userInstance(4, "Mohhamad", "Sianaki", "", 41);
        users[4] = userInstance(5, "Sina", "Almasi", "", 71);
        dataBase.DBDao().insertUsers(users);

        Post[] posts = new Post[5];
        posts[0] = postInstance(1, "Interesting", "Interesting post", "",1);
        posts[1] = postInstance(2, "Funny", "FunnyPost", "",2);
        posts[2] = postInstance(3, "Bitter ", "BitterPost", "",3);
        posts[3] = postInstance(4, "Social", "SocialPost", "",4);
        posts[4] = postInstance(5, "Serious", "SeriousPost", "",5);
        dataBase.DBDao().insertPosts(posts);

        Comment[] comments = new Comment[5];
        comments[0] = commentInstance(1, "Like", 1, 2);
        comments[1] = commentInstance(2, "BigLike", 2, 4);
        comments[2] = commentInstance(3, "sonboletin", 3, 1);
        comments[3] = commentInstance(4, "ostoghodus", 4, 5);
        comments[4] = commentInstance(5, "ostoghodus", 5, 3);
        dataBase.DBDao().insertComments(comments);

    }

    private User userInstance(int id, String name, String family, String avatar, int nationalCode) {
        User user = new User();
        user.setUserId(id);
        user.setName(name);
        user.setFamily(family);
        user.setAvatar(avatar);
        user.setNationalCode(nationalCode);
        return user;
    }
    private Post postInstance(int id, String title, String description, String avatar, int userId) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setDescription(description);
        post.setAvatar(avatar);
        post.setUserId(userId);
        return post;
    }

    private Comment commentInstance(int id, String commentText, int userId, int postId) {
        Comment comment =new Comment();
        comment.setId(id);
        comment.setCommentText(commentText);
        comment.setUserId(userId);
        comment.setPostId(postId);
        return comment;
    }


}
