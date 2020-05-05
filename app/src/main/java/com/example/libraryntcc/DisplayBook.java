package com.example.libraryntcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DisplayBook extends AppCompatActivity {
    ArrayList<Book> arrayList;
    RecyclerView rv;
    LinearLayoutManager lm;
    SearchView searchView;
    BookAdapter adapter;
    static String url_DisplayBooks="https://ntccproject.000webhostapp.com/connect/DisplayAllBooks.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_book);
        searchView=findViewById(R.id.searchView);
        rv=findViewById(R.id.rv);
        DisplayBook();
    }
    public void DisplayBook(){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url_DisplayBooks, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG",""+ response);
                Gson gson=new Gson();
                ARBook arBook=gson.fromJson(response,ARBook.class);
                arrayList=arBook.getBookResponse();
                Log.e("TAG",""+arrayList.get(0).getBName());
                adapter = new BookAdapter(getBaseContext(),arrayList);
                lm = new LinearLayoutManager(getBaseContext());
                rv.setLayoutManager(lm);
                rv.setAdapter(adapter);
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        adapter.getFilter().filter(newText);
                        return true;
                    }
                });
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
