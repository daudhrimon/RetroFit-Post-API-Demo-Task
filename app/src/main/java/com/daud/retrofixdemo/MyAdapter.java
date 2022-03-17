package com.daud.retrofixdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Entry> list;

    public MyAdapter(Context context, List<Entry> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.apiTv.setText("API: "+list.get(position).getAPI());
        holder.descriptionTv.setText("Description: "+list.get(position).getDescription());
        holder.authTv.setText("Auth: "+list.get(position).getAuth());
        holder.httpsTv.setText("HTTPS: "+list.get(position).getHTTPS());
        holder.corsTv.setText("Cors: "+list.get(position).getCors());
        holder.linkTv.setText("Link: "+list.get(position).getLink());
        holder.categoryTv.setText("Category: "+list.get(position).getCategory());
        holder.linkTv.setOnClickListener(view -> {
            Intent intent = new Intent(context,WebActivity.class);
            intent.putExtra("URL",list.get(position).getLink());
            context.startActivity(intent);
            ((MainActivity)context).finish();
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView apiTv,descriptionTv,authTv,httpsTv,corsTv,linkTv,categoryTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            apiTv=itemView.findViewById(R.id.apiTv);
            descriptionTv=itemView.findViewById(R.id.descriptionTv);
            authTv=itemView.findViewById(R.id.authTv);
            httpsTv=itemView.findViewById(R.id.httpsTv);
            corsTv=itemView.findViewById(R.id.corsTv);
            linkTv=itemView.findViewById(R.id.linkTv);
            categoryTv=itemView.findViewById(R.id.categoryTv);
        }
    }
}
