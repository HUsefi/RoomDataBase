package com.example.hassan.roomdatabase.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user")
public class User {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int userId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "family")
    private String family;

    @ColumnInfo(name = "national_code")
    private int nationalCode;

    @ColumnInfo(name = "avatar")
    private String avatar;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatarLink) {
        this.avatar = avatarLink;
    }
}
