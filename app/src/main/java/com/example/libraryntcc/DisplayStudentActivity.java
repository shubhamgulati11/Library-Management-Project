package com.example.libraryntcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class DisplayStudentActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<Student> arrayList;
    Adapter adapter;
    LinearLayoutManager lm;
    static String url_DisplayStudents="https://ntccproject.000webhostapp.com/connect/TrialJsonArray.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);
        rv=findViewById(R.id.rv);

        Display();


    }

    private void Display(){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url_DisplayStudents, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG",""+ response);
                Gson gson=new Gson();
                ARStudent arStudent=gson.fromJson(response,ARStudent.class);
                arrayList=arStudent.getResponse();
                Log.e("TAG",""+arStudent.getResponse().get(0).getDepartment());
                adapter = new Adapter(getBaseContext(),arrayList);
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
