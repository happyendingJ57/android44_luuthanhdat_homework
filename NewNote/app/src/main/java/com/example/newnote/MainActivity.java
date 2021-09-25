package com.example.newnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView btnCreateNewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateNewNote = findViewById(R.id.btnCreateNewNote);

        btnCreateNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragment(CreateNewNote.newInstance());
            }
        });

    }
//bo sung cho  onFragment o trong btnCreateNewNote
    private void onFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragContainer, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}