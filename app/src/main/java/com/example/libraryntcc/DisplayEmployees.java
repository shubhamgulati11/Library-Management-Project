package com.example.libraryntcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DisplayEmployees extends AppCompatActivity {

    RecyclerView rv;
    EmployeeAdapter adapter;
    LinearLayoutManager lm;
    ArrayList<Employee> arrayList;
    static String url_DisplayEmployee="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_employees);
        rv=findViewById(R.id.rv);
    }
    public void displayEmp(){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url_DisplayEmployee, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG",""+ response);
                Gson gson=new Gson();
                AREmployee arEmployee=gson.fromJson(response,AREmployee.class);
                arrayList=arEmployee.getAdminResponse();
                Log.e("TAG",""+arrayList.get(0).getAdminId());
                adapter = new EmployeeAdapter(arrayList,getBaseContext());
                lm = new LinearLayoutManager(getBaseContext());
                rv.setLayoutManager(lm);
                rv.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
