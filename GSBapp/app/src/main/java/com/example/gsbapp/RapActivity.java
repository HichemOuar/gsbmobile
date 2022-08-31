package com.example.gsbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RapActivity extends AppCompatActivity {






    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<User2> user;

    RequestQueue reqQue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rap);

        recyclerView=(RecyclerView)findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        user=new ArrayList<>();

        loadurl();

    }



    public void loadurl() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            String URL_Data = "https://cedricdsst.com/gsbV3/getRapport/"+value;
            //The key argument here must match that used in the other activity


        JsonArrayRequest stringRequest = new JsonArrayRequest(URL_Data, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                getvalue(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        reqQue = Volley.newRequestQueue(this);

        reqQue.add(stringRequest);
    }}





    public void getvalue(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            User2 userlist = new User2();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                userlist.setNom(json.getString("prat"));
                userlist.setDate(json.getString("date_visite"));
                userlist.setProduit(json.getString("produit"));
                userlist.setMotif("motif: "+json.getString("motif"));
                userlist.setComment(json.getString("comment"));


                // userlist.setAvatarUrl(json.getString("avatar_url"));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            user.add(userlist);
        }

        adapter = new UserAdapter2(user, this);

        recyclerView.setAdapter(adapter);
    }
}