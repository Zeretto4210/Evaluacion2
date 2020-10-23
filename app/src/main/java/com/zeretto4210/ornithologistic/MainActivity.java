package com.zeretto4210.ornithologistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BDConnection data;
    User user;
    TextView userdata;
    int cant; //para borrar la cuenta
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userdata = (TextView) findViewById(R.id.l_data);
        data = new BDConnection(this, "systemBD", null, 1);
        user = retrieveData();
        cant = 1;
    }
    public void registrarUsuario(View view){
        user = retrieveData();
        if (user==null){
            Intent i = new Intent(getApplicationContext(), UserRegister.class);
            startActivity(i);
        }
        else{
            cant++;
            if (cant == 2){
                userdata.setText("Nombre: "+user.getName()+"\nApellido: "+user.getLastname()+"\nGénero: "+user.getgender()+"\nFecha de Nacimiento: "+user.getDate());
                Toast.makeText(this, "¡Ya has registrado un usuario!", Toast.LENGTH_SHORT).show();
            }
            if (cant == 7){
                deleteData();
                Toast.makeText(this, "¡Usuario y registros eliminados!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void registrarAve(View view){
        user = retrieveData();
        if(user==null){
            Toast.makeText(this, "¡Primero registra tus datos!", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(getApplicationContext(), BirdRegister.class);
            startActivity(i);
        }
    }
    public void listarAves(View view){
        user = retrieveData();
        if(user==null){
            Toast.makeText(this, "¡Primero registra tus datos!", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(getApplicationContext(), BirdRegister.class);
            startActivity(i);
        }
    }
    public void deleteData(){
        SQLiteDatabase base = data.getWritableDatabase();
        base.delete("usuario",null, null);
        base.delete("registros",null, null);
        finish();
        startActivity(getIntent());
    }
    public User retrieveData(){
        SQLiteDatabase base = data.getReadableDatabase();
        String[] columns = {"id", "nombre", "apellido", "genero", "fecha"};
        Cursor c = base.query("usuario", columns, null, null, null, null, null);
        try{
            c.moveToFirst();
            if (c.getInt(0) == 1){
                return (new User(c.getString(1),c.getString(2),c.getString(3),c.getString(4)));
            }
        }catch(Exception e){
        }
        return null;
    }
}