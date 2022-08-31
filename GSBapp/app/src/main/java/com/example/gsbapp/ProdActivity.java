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

public class ProdActivity extends AppCompatActivity {



    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<User> user;
    String URL_Data="https://cedricdsst.com/gsbV3/getProduit";
    RequestQueue reqQue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod);

        recyclerView=(RecyclerView)findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        user=new ArrayList<>();

        loadurl();

    }



    public void loadurl() {
        JsonArrayRequest stringRequest=new JsonArrayRequest(URL_Data, new Response.Listener<JSONArray>() {

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
    }





    public void getvalue(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            User userlist = new User();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                userlist.setNom(json.getString("MED_NOMCOMMERCIAL"));
                userlist.setAdresse(json.getString("MED_COMPOSITION"));
                userlist.setCoef(json.getString("MED_DEPOTLEGAL"));


                // userlist.setAvatarUrl(json.getString("avatar_url"));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            user.add(userlist);
        }

        adapter = new UserAdapter(user, this);

        recyclerView.setAdapter(adapter);
    }
}