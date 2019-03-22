package com.leventisfoods.paul.mvvmproject.model.dbtables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "registration")
public class Register {

    @PrimaryKey
    @NonNull
    public String id;
    public String firstname;
    public String lastname;

    public Register(@NonNull String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}

