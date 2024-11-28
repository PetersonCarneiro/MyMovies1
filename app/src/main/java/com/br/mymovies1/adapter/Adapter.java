package com.br.mymovies1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.mymovies1.R;
import com.br.mymovies1.model.Movie;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Movie> movieList;

    public Adapter(List<Movie> list){
        this.movieList = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTitle, textViewType, textViewYear;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewType = itemView.findViewById(R.id.textViewType);
            textViewYear = itemView.findViewById(R.id.textViewYear);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adpter_view,parent,false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewType.setText(movie.getType());
        holder.textViewYear.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }



}
