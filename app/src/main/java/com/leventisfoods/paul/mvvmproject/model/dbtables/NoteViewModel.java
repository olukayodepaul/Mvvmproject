package com.leventisfoods.paul.mvvmproject.model.dbtables;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRoomDatabase noteRoomDatabase;
    private NoteDao noteDao;
    private LiveData<List<Register>> allRegsiter;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRoomDatabase = NoteRoomDatabase.getDatabase(application);
        noteDao = noteRoomDatabase.noteDao();
        allRegsiter = noteDao.getAllNote();
    }

    public LiveData<List<Register>> getAllReg(){
        return allRegsiter;
    }

    public void insert(Register register) {
        new InsertAsyTask(noteDao).execute(register);
    }

    private class InsertAsyTask extends AsyncTask<Register, Void, Void> {

        NoteDao noteDao;

        public InsertAsyTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Register... registers) {
            noteDao.insert(registers[0]);
            return null;
        }
    }


}
