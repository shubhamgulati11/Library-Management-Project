package com.example.libraryntcc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    ArrayList<Employee> arrayList;
    Context cxt;

    public EmployeeAdapter(ArrayList<Employee> arrayList, Context cxt) {
        this.arrayList = arrayList;
        this.cxt = cxt;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView;
        LayoutInflater li=LayoutInflater.from(cxt);
        inflatedView=li.inflate(R.layout.empcard,parent,false);
        return new ViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee e=arrayList.get(position);
        holder.tvName.setText(e.getName());
        holder.tvId.setText(e.getAdminId());
        holder.tvEmail.setText(e.getEmail());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvId,tvEmail;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvId=itemView.findViewById(R.id.tvId);
            tvEmail=itemView.findViewById(R.id.tvEmail);

        }
    }
}
