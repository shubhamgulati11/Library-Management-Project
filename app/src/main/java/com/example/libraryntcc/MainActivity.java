package com.example.libraryntcc;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {

    Button loginBtn;
    EditText amiId,pass;
    TextView tvRegister;
    private static String LOGIN_URL="https://ntccproject.000webhostapp.com/connect/login4.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amiId=findViewById(R.id.amiId);
        pass=findViewById(R.id.pass);
        loginBtn=findViewById(R.id.loginBtn);
        tvRegister=findViewById(R.id.tvRegister);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id=amiId.getText().toString().trim();
                final String password=pass.getText().toString().trim();
                Log.e("TAG","Button Clicked");
                Login(id,password);
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AddBookActivity.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
    private void Login(final String id, final String pass){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    String success=jsonResponse.getString("success");
                    Log.e("TAG",""+jsonResponse.toString());
                    if(success.equals("1")){
                        String name=jsonResponse.getString("name");
                        String enroll=jsonResponse.getString("enroll");
                        Intent i=new Intent(MainActivity.this,UserAreaActivity.class);
                        i.putExtra("id",id);
                        i.putExtra("name",name);
                        i.putExtra("enroll",enroll);
                        MainActivity.this.startActivity(i);
                    }else{
                        Toast.makeText(MainActivity.this,"Wrong Id or Password",Toast.LENGTH_SHORT);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG","error response");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("id",id);
                params.put("password",pass);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
