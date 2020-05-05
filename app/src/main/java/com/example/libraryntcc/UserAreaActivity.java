package com.example.libraryntcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    TextView tvId,tvName,tvEnroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        tvId=findViewById(R.id.tvId);
        tvName=findViewById(R.id.tvName);
        tvEnroll=findViewById(R.id.tvEnroll);
        String name=getIntent().getStringExtra("name");
        String bid=getIntent().getStringExtra("bid");
        String bname=getIntent().getStringExtra("bname");
        tvId.setText(bid);
        tvName.setText(name);
        tvEnroll.setText(bname);

    }
}
