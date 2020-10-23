package com.zeretto4210.ornithologistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class UserRegister extends AppCompatActivity {

    BDConnection data;
    EditText name, lastname, date;
    RadioGroup gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        data = new BDConnection(this, "systemBD", null, 1);
        name = (EditText) findViewById(R.id.u_name);
        lastname = (EditText) findViewById(R.id.u_lastname);
        date = (EditText) findViewById(R.id.u_date);
        gender = (RadioGroup) findViewById(R.id.r_group);
    }
    public void registrarUsuario(View view){
        String sName, sLastName, sGender, sDate;
        sName = ""+name.getText();
        sLastName = ""+lastname.getText();
        sDate = ""+date.getText();
        sGender = "";
        switch (gender.getCheckedRadioButtonId()){
            case (R.id.r_male): {
                sGender += "Hombre";
                break;
            }
            case (R.id.r_female): {
                sGender += "Mujer";
                break;
            }
            case (R.id.r_any): {
                sGender += "Prefiero no decir";
                break;
            }
        }
    //(id INTEGER, nombre TEXT, apellido TEXT, genero TEXT, fecha TEXT)";
        ContentValues userdata = new ContentValues();
        userdata.put("id",1);
        userdata.put("nombre",sName);
        userdata.put("apellido",sLastName);
        userdata.put("genero",sGender);
        userdata.put("fecha",sDate);

        SQLiteDatabase base = data.getWritableDatabase();
        long result = base.insert("usuario","id",userdata);
        Toast.makeText(this, "¡Te has registrado correctamente!", Toast.LENGTH_SHORT).show();
        finish();
    }
}