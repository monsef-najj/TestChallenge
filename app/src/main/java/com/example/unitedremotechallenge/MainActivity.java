package com.example.unitedremotechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private Adapter adapter;
    private ArrayList<Model> maliste;
    private RecyclerView.LayoutManager layoutManager;
    String jsonUrl = "https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc\n" +
            "\n";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        maliste = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, jsonUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.v("ok","non");

                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i=0 ; i<jsonArray.length(); i++){
                        JSONObject item = jsonArray.getJSONObject(i);

                        Log.v("cc","cc"+item.getJSONObject("owner").getString("login"));
                        String owner =   item.getJSONObject("owner").getString("login");
                        String name =   item.getString("name");

                        String stars = String.valueOf(item.getInt("watchers"));
                        String description = item.getString("description");

                        maliste.add(new Model(name,owner,description,stars));


                    }
                    adapter = new Adapter(MainActivity.this,maliste);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                Log.v("adapter","adapt"+mlist.toString());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);

    }
}

