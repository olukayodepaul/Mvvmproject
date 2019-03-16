package com.leventisfoods.paul.mvvmproject;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.leventisfoods.paul.mvvmproject.model.adapters.NoteAdapers;
import com.leventisfoods.paul.mvvmproject.model.dbtables.NoteViewModel;
import com.leventisfoods.paul.mvvmproject.model.dbtables.Register;

import java.util.List;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    NoteViewModel noteViewModel;
    RecyclerView recyclerView;
    NoteAdapers noteAdapers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

        final String id = UUID.randomUUID().toString();
        Register register = new Register(id, "olukayode", "oviosun");
        noteViewModel.insert(register);

        String intd = "paul";
        String i = "jffuf";

        recyclerView = findViewById(R.id.recycler_view);
        noteAdapers = new NoteAdapers(this);
        recyclerView.setAdapter(noteAdapers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        noteViewModel.getAllReg().observe(this, new Observer<List<Register>>() {
            @Override
            public void onChanged(@Nullable List<Register> registers) {
                noteAdapers.SetNotes(registers);

            }
        });
    }
}
