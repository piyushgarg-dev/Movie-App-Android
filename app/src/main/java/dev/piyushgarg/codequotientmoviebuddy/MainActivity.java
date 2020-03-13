package dev.piyushgarg.codequotientmoviebuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = new LinearLayoutManager(this);
        recyclerView =findViewById(R.id.recyclerView);
        getMovieData();
    }

    private void getMovieData(){
        final ArrayList<Movie> movieArrayList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        String URL = "http://api.tmdb.org/3/discover/movie?api_key=b9591ff97640f60d75c1a53f147f9c88&language=en'&page=1";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject movie = jsonArray.getJSONObject(i);
                        movieArrayList.add(new Movie(movie.getDouble("popularity"),movie.getDouble("vote_count"),movie.getString("poster_path"),movie.getDouble("id"),movie.getString("original_title"),movie.getString("title"),movie.getString("overview"),movie.getDouble("vote_average")));
                        System.out.println(movie);
                    }

                    adapter = new MovieAdapter(movieArrayList);
                    recyclerView.hasFixedSize();
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });

        requestQueue.add(request);
    }

    public void saveForLater(View view) {
        Snackbar.make(view,"Save for later comming soon",Snackbar.LENGTH_SHORT).show();
    }
}
