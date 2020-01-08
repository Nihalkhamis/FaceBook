package com.elsafeir.mbsoft.facebook.UI.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elsafeir.mbsoft.facebook.Model.PostModel;
import com.elsafeir.mbsoft.facebook.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<PostModel> movieslist = new ArrayList<>();

    public void setMovieslist(List<PostModel> movieslist) {
        this.movieslist = movieslist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.PostViewHolder holder, int position) {
        holder.titleTV.setText(movieslist.get(position).getTitle());
        holder.userIDTV.setText(movieslist.get(position).getUserId()+"");
        holder.bodyTV.setText(movieslist.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return movieslist.size();
    }


    class PostViewHolder extends RecyclerView.ViewHolder{
       TextView titleTV, userIDTV, bodyTV;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            userIDTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);

        }
    }

}
