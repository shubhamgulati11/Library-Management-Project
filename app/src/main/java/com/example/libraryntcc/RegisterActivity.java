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

public class RegisterActivity extends AppCompatActivity {

    EditText etId,etPass,etName,etEnroll;
    Button btnSignIn;
    private static String URL_REGIST="https://ntccproject.000webhostapp.com/connect/register2.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etId=findViewById(R.id.etId);
        etPass=findViewById(R.id.etPass);
        etName=findViewById(R.id.etName);
        etEnroll=findViewById(R.id.etEnroll);
        btnSignIn=findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG","Button");
                final String id=etId.getText().toString().trim();
                final String pass=etPass.getText().toString().trim();
                final String name=etName.getText().toString();
                final String enroll=etEnroll.getText().toString();
                if(!id.isEmpty() && !pass.isEmpty() && !name.isEmpty() && !enroll.isEmpty()){
                    Regist(id,pass,name,enroll);

                }else{
                    Toast.makeText(RegisterActivity.this,"Fields should not be empty",Toast.LENGTH_SHORT);
                }

            }
        });

    }
    private void Regist(final String id, final String pass, final String name, final String enroll){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_REGIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    Log.e("TAG",""+jsonResponse.toString());
                    Intent i=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG","Error Response");
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("id",id);
                params.put("password",pass);
                params.put("name",name);
                params.put("enroll",enroll);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
