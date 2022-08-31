package com.example.gsbapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Context context;
    List<User> data;
    // ImageView profilepic;

    TextView nomprat;
    TextView adresseprat;
    TextView coefprat;
    public UserAdapter(List<User> data, Context context)
    {
        this.context=context;
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User geter1 =  data.get(position);
        String  nom, adresse, coef;

        nom=geter1.getNom();
        adresse=geter1.getAdresse();
        coef=geter1.getCoef();
        // image=geter1.getAvatarUrl();

        nomprat.setText(nom);
        adresseprat.setText(adresse);
        coefprat.setText(coef);
        // Picasso.get().load(image).into(profilepic);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

            // profilepic=(ImageView)itemView.findViewById(R.id.profilepic);


            nomprat=(TextView)itemView.findViewById(R.id.nom);
            adresseprat=(TextView)itemView.findViewById(R.id.motif);
            coefprat=(TextView)itemView.findViewById(R.id.coef);



        }
    }
}
