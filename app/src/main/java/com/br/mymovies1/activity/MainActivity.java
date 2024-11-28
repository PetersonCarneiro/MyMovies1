package com.br.mymovies1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.br.mymovies1.R;
import com.br.mymovies1.adapter.Adapter;
import com.br.mymovies1.model.Movie;
import com.br.mymovies1.utils.RecyclerItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextType, editTextYear;
    private RecyclerView recyclerView;
    private ArrayList<Movie> movieList;
    private Adapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextType  = findViewById(R.id.editTextType);
        editTextYear  = findViewById(R.id.editTextYear);

        recyclerView = findViewById(R.id.recyclerView);

        movieList = new ArrayList<>();
        adapter = new Adapter(movieList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Movie movie = movieList.get(position);
                        Toast.makeText(getApplicationContext(),"Filme: "+ movie.getTitle(),Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Movie movie = movieList.get(position);
                        Toast.makeText(getApplicationContext(),"Ano: "+ movie.getYear(),Toast.LENGTH_SHORT).show();

                    }
                })
        );

    }


    public void save(View view){

        String title = editTextTitle.getText().toString();
        String type  = editTextType.getText().toString();
        String year  = editTextYear.getText().toString();

        Movie movie = new Movie(title, type, year);

        movieList.add(movie);

        adapter.notifyItemInserted(movieList.size()-1);

        editTextTitle.setText("");
        editTextType.setText("");
        editTextYear.setText("");


    }


}