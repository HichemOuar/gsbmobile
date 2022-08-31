package com.example.gsbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter2 extends RecyclerView.Adapter<UserAdapter2.ViewHolder> {

    Context context;
    List<User2> data;
    // ImageView profilepic;

    TextView nomrap;
    TextView daterap;
    TextView produitrap;
    TextView motifrap;
    TextView commentrap;
    public UserAdapter2(List<User2> data, Context context)
    {
        this.context=context;
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User2 geter1 =  data.get(position);
        String  nom, date, produit, motif, comment;

        nom=geter1.getNom();
        date=geter1.getDate();
        produit=geter1.getProduit();
        motif=geter1.getMotif();
        comment=geter1.getComment();
        // image=geter1.getAvatarUrl();

        nomrap.setText(nom);
        daterap.setText(date);
        produitrap.setText(produit);
        motifrap.setText(motif);
        commentrap.setText(comment);
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


            nomrap=(TextView)itemView.findViewById(R.id.nom_rap);
            daterap=(TextView)itemView.findViewById(R.id.date);
            produitrap=(TextView)itemView.findViewById(R.id.nom_med);
            motifrap=(TextView)itemView.findViewById(R.id.motiff);
            commentrap=(TextView)itemView.findViewById(R.id.comment);



        }
    }
}
