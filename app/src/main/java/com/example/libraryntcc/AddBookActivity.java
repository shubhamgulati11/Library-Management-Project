package com.example.libraryntcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddBookActivity extends AppCompatActivity {

    EditText etId,etName,etAuthor;
    Button btnAdd;
    private static String URL_AddBook="https://ntccproject.000webhostapp.com/connect/AddBook.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        etId=findViewById(R.id.etId);
        etName=findViewById(R.id.etName);
        etAuthor=findViewById(R.id.etAuthor);
        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG","Add Book button");
                String id=etId.getText().toString().trim();
                String name=etName.getText().toString().trim();
                String author=etAuthor.getText().toString().trim();
                Log.e("TAG","Author= "+author);
                AddBook(id,name,author);
            }
        });

    }
    private void AddBook(final String id, final String name, final String author){
        Log.e("TAG","Add Book Function");
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_AddBook, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    Log.e("TAG","Add Book Response");
                    JSONObject jsonResponse = new JSONObject(response);
                    Log.e("TAG",""+jsonResponse.toString());
                    String success=jsonResponse.getString("success");
                    if(success.equals("1")){
                        Toast.makeText(AddBookActivity.this,"Book Added Successfully",Toast.LENGTH_SHORT).show();
                        etId.setText("");
                        etName.setText("");
                        etAuthor.setText("");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG","Admin Login error response");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("id",id);
                params.put("name",name);
                params.put("author",author);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
