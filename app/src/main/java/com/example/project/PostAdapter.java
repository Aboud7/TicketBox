package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> implements Filterable {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView event,date,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            event = itemView.findViewById(R.id.event);
            date = itemView.findViewById(R.id.date);
            price = itemView.findViewById(R.id.price);
        }
    }
    private Context context;
    private List<Post> posts;
    private List<Post> postsfull;
    public PostAdapter (Context c,List<Post> postList){
        this.context = c;
        posts = postList;
        postsfull = new ArrayList<>(postList);
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.event.setText(post.getEvent());
        holder.date.setText(post.getDate());
        holder.price.setText(post.getPrice());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
    @Override
    public Filter getFilter(){
        return postFilter;
    }
    private Filter postFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Post> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(postsfull);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Post post:postsfull){
                    if(post.getEvent().toLowerCase().contains(filterPattern)||
                            post.getPrice().toLowerCase().contains(filterPattern)||
                            post.getDate().toLowerCase().contains(filterPattern)
                            ){
                        filteredList.add(post);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            posts.clear();
            posts.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
