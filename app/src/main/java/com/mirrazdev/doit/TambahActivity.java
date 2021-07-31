package com.mirrazdev.doit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mirrazdev.doit.database.AppDatabase;
import com.mirrazdev.doit.database.entitas.Todo;

public class TambahActivity extends AppCompatActivity {
    private EditText edittodo, editkom;
    private Button btnSave;
    private AppDatabase database;
    private int tid = 0;
    private boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        edittodo = findViewById(R.id.todo);
        editkom = findViewById(R.id.komentar);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        tid = intent.getIntExtra("tid",0);
        if (tid>0){
            isEdit = true;
            Todo todo = database.todoDao().get(tid);
            edittodo.setText(todo.aktifitas);
            editkom.setText(todo.keterangan);
        }else {
            isEdit = false;
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEdit){
                    database.todoDao().update(tid, edittodo.getText().toString(), editkom.getText().toString());
                }else {
                    database.todoDao().insertAll(edittodo.getText().toString(), editkom.getText().toString());
                }
                finish();
            }
        });
    }
}