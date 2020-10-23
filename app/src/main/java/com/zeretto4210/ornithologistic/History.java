package com.zeretto4210.ornithologistic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    BDConnection data;
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        data = new BDConnection(this, "systemBD", null, 1);

        ArrayList<Bird> birdList = databaseToList();

        list = (RecyclerView) findViewById(R.id.r_list);
        list.setLayoutManager(new LinearLayoutManager(this));

        Adapter me = new Adapter(birdList);
        list.setAdapter(me);
    }

    public ArrayList<Bird> databaseToList(){
        ArrayList<Bird> tempList = new ArrayList<>();
        SQLiteDatabase base = data.getReadableDatabase();
        String[] columnas = {"id", "player", "cpu"};

        Cursor c = base.query("registros", columnas, null, null, null, null, null);
        while(c.moveToNext()){
            Bird b = new Bird(""+c.getInt(0), c.getString(1),c.getString(2),c.getString(3));
            tempList.add(b);
        }
        return tempList;
    }
}