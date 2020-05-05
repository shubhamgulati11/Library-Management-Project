package com.example.libraryntcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AdminMenuActivity extends AppCompatActivity {

    RecyclerView rv;
    MenuAdapter  menuAdapter;
    LinearLayoutManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        ArrayList<String> arrayList=getArraylist();
        rv=findViewById(R.id.rv);
        menuAdapter=new MenuAdapter(getBaseContext(),arrayList);
        lm = new LinearLayoutManager(getBaseContext());
        rv.setLayoutManager(lm);
        rv.setAdapter(menuAdapter);

    }
    public ArrayList<String> getArraylist(){
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("Add Book");
        arrayList.add("Display All Books");
        arrayList.add("Display All Employees");
        arrayList.add("Display All Issued Books");
        arrayList.add("Display All Students");
        arrayList.add("Add Employee");
        return arrayList;
    }
}
