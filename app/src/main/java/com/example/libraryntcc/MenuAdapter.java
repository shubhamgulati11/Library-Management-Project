package com.example.libraryntcc;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context cxt;
    ArrayList<String> arrayList;

    public MenuAdapter(Context cxt, ArrayList<String> arrayList) {
        this.cxt = cxt;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView;
        LayoutInflater layoutInflater=LayoutInflater.from(cxt);
        inflatedView=layoutInflater.inflate(R.layout.menucard,parent,false);
        return new ViewHolder(inflatedView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String s=arrayList.get(position);
        holder.tvName.setText(s);
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.equals("Add Book")){
                    Intent i=new Intent(cxt,AddBookActivity.class);
                    cxt.startActivity(i);
                }else if(s.equals("Display All Books")){
                    Intent i=new Intent(cxt,DisplayBook.class);
                    cxt.startActivity(i);
                }else if(s.equals("Display All Employees")){
                    

                }else if(s.equals("Display All Issued Books")){

                }else if(s.equals("Display All Students")){
                    Intent i=new Intent(cxt,DisplayStudentActivity.class);
                    cxt.startActivity(i);
                }else if(s.equals("Add Employee")){

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
        }
    }
}
