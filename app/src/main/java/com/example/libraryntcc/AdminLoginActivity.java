package com.example.libraryntcc;

import android.content.Intent;
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

public class AdminLoginActivity extends AppCompatActivity {

    EditText AdminId,AdminPass;
    Button loginBtn;
    private static String url="https://ntccproject.000webhostapp.com/connect/AdminLogin.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        AdminId=findViewById(R.id.AdminId);
        AdminPass=findViewById(R.id.AdminPass);
        loginBtn=findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id=AdminId.getText().toString().trim();
                final String pass=AdminPass.getText().toString().trim();
                Log.e("TAG","Button Clicked");
                Log.e("TAG","id= "+id+" pass= "+pass);
                Login(id,pass);
            }
        });

    }
    private void Login(final String id, final String pass){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    Log.e("TAG","In function");
                    JSONObject jsonResponse = new JSONObject(response);
                    String success=jsonResponse.getString("success");
                    Log.e("TAG",""+success);
                    Log.e("TAG",""+jsonResponse.toString());
                    if(success.equals("1")){
                        Intent i=new Intent(AdminLoginActivity.this, AdminMenuActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(AdminLoginActivity.this,"Wrong Id or Password",Toast.LENGTH_SHORT);
                    }

                }catch (JSONException e){
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
                params.put("password",pass);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
