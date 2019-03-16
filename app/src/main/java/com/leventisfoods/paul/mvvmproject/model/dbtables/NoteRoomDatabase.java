package com.leventisfoods.paul.mvvmproject.model.dbtables;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Register.class}, version = 1, exportSchema = false)
public abstract class NoteRoomDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();

    private static volatile NoteRoomDatabase noteRoomInstance;

    static NoteRoomDatabase getDatabase(final Context context) {
        if(noteRoomInstance==null){
            synchronized (NoteRoomDatabase.class){
                if(noteRoomInstance==null){
                    noteRoomInstance =
                            Room.databaseBuilder(context.getApplicationContext(),NoteRoomDatabase.class, "mobiletrader_v")
                                    .addMigrations()
                            .build();
                }
            }
        }
        return noteRoomInstance;
    }
}
