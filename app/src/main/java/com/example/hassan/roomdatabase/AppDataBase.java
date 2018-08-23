package com.example.hassan.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.hassan.roomdatabase.entity.Comment;
import com.example.hassan.roomdatabase.entity.Post;
import com.example.hassan.roomdatabase.entity.User;


@Database(entities = {User.class, Post.class, Comment.class}, version = 1)

public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase INSTANCE;

    public abstract ModelDao DBDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            "app-database")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }

}
