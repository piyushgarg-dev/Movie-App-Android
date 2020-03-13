package dev.piyushgarg.codequotientmoviebuddy;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card,parent,false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currentMovie = movies.get(position);
        holder.movie_title.setText(currentMovie.getOriginal_title());
        holder.movie_desc.setText(currentMovie.getOverview());
        try {
            holder.popularity.setText(Integer.toString((int) currentMovie.getPopularity()));
            holder.votes.setText(Integer.toString((int) currentMovie.getVote_count()));
            holder.avg_votes.setText(Integer.toString((int) currentMovie.getVote_average()));
        }catch(Exception e){
            System.out.println(e);
        }




        Picasso.get().load("https://image.tmdb.org/t/p/w185/"+currentMovie.getPoster_path()).into(holder.movie_bg);


    }

    @Override
    public int getItemCount() {
        return movies.toArray().length;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
            public TextView movie_title;
            public TextView movie_desc;
            public Button movie_dec_button;
            public ImageView movie_bg;
            public TextView avg_votes;
            public TextView votes;
            public TextView popularity;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_bg = itemView.findViewById(R.id.bg_img);
            movie_dec_button = itemView.findViewById(R.id.movie_dec_button);
            movie_desc = itemView.findViewById(R.id.movie_dec);
            movie_title = itemView.findViewById(R.id.movie_title);
            avg_votes = itemView.findViewById(R.id.avg_votes);
            votes = itemView.findViewById(R.id.votes);
            popularity = itemView.findViewById(R.id.popularity);

        }
    }
}
