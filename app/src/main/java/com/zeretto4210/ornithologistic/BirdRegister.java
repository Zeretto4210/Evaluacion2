package com.zeretto4210.ornithologistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BirdRegister extends AppCompatActivity {
    BDConnection data;
    EditText name, date, comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_register);
        data = new BDConnection(this, "systemBD", null, 1);
        name = (EditText) findViewById(R.id.u_name);
        comment = (EditText) findViewById(R.id.u_comment);
        date = (EditText) findViewById(R.id.u_date);
    }
    public void registrarAve(View view){
        String sName, sDate, sComment;
        sName = ""+name.getText();
        sDate = ""+date.getText();
        sComment = "" + comment.getText();

        SQLiteDatabase dbcant = data.getReadableDatabase();
        int cant = (int) DatabaseUtils.queryNumEntries(dbcant,"registros");

        ContentValues userdata = new ContentValues();
        userdata.put("id",cant+1);
        userdata.put("nombre",sName);
        userdata.put("fecha",sDate);
        userdata.put("comentario",sComment);

        SQLiteDatabase base = data.getWritableDatabase();
        long result = base.insert("registros","id",userdata);
        Toast.makeText(this, "¡Registro de ave correcto!", Toast.LENGTH_SHORT).show();
        finish();
    }
}