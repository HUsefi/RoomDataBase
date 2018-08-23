package com.example.hassan.roomdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hassan.roomdatabase.utility.DatabaseInitializer;
import com.example.hassan.roomdatabase.utility.ShowLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDataBase database = AppDataBase.getAppDatabase(this);

        DatabaseInitializer.with(database).generateAppDetails();

        ShowLog logger = new ShowLog(database);
        logger.displayUserListByPostId(1);
        logger.displayCommentsByPostId(2);
        logger.displayCommentsByUserId(2);
        logger.displayCommentsNumberByUserId(2);
    }
}
