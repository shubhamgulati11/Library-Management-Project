package com.example.libraryntcc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> implements Filterable {

    Context cxt;
    ArrayList<Book> arrayList;
    ArrayList<Book> filteredarrayList;

    public BookAdapter(Context cxt, ArrayList<Book> arrayList) {
        this.cxt = cxt;
        this.arrayList = arrayList;
        filteredarrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView;
        LayoutInflater li=LayoutInflater.from(cxt);
        inflatedView=li.inflate(R.layout.bookcard,parent,false);
        return new ViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book b=filteredarrayList.get(position);
        holder.tvBId.setText(b.getBId());
        holder.tvBName.setText(b.getBName());
        holder.tvAuthor.setText(b.getAuthor());
    }

    @Override
    public int getItemCount() {
        return filteredarrayList.size();
    }

    @Override
    public Filter getFilter() {
        Log.e("TAG","GetFilter");
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {

                    filteredarrayList = arrayList;
                }else {
                    Log.e("TAG","Perform Filter");
                    ArrayList<Book> List = new ArrayList<>();

                    for (Book  b : arrayList) {

                        if (b.getBName().toLowerCase().contains(charString) || b.getAuthor().toLowerCase().contains(charString) || b.getBId().contains(charString)) {

                            List.add(b);
                        }
                    }

                    filteredarrayList = List;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredarrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredarrayList = (ArrayList<Book>) results.values;
                notifyDataSetChanged();
            }
        };
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBId,tvBName,tvAuthor;
        public ViewHolder(View itemView) {
            super(itemView);
            tvBId=itemView.findViewById(R.id.tvBId);
            tvBName=itemView.findViewById(R.id.tvBName);
            tvAuthor=itemView.findViewById(R.id.tvAuthor);
        }
    }
}
