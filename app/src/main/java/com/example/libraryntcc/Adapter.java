package com.example.libraryntcc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context cxt;
    ArrayList<Student> arrayList;

    public Adapter(Context cxt, ArrayList<Student> arrayList) {
        this.cxt = cxt;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedview;
        LayoutInflater li = LayoutInflater.from(cxt);
        inflatedview = li.inflate(R.layout.studcard,parent,false);
        return new ViewHolder(inflatedview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Student a = arrayList.get(position);
        holder.tvName.setText(a.getName());
        holder.tvEnroll.setText(a.getEnrollment());
        holder.tvDepartment.setText(a.getDepartment());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEnroll,tvName,tvDepartment;
        public ViewHolder(View itemView) {
            super(itemView);
            tvDepartment=itemView.findViewById(R.id.tvDepartment);
            tvEnroll=itemView.findViewById(R.id.tvEnroll);
            tvName=itemView.findViewById(R.id.tvName);
        }
    }
}
