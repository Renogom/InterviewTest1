package com.m.edutabtest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.m.edutabtest.R;
import com.m.edutabtest.activityy.PassengerDetailActivity;
import com.m.edutabtest.models.Airline;
import com.m.edutabtest.models.Data;
import com.m.edutabtest.models.DataOffliner;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PassengerAdapterOffline extends RecyclerView.Adapter<PassengerAdapterOffline.ViewHolder> {
    List<DataOffliner> dataArrayList = new ArrayList<>();
    Context context;

    public PassengerAdapterOffline(List<DataOffliner> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.passenger_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PassengerAdapterOffline.ViewHolder holder, int position) {
        holder.setData(dataArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView passenger_name, trips, airline_name, airline_id, airline_country, airline_slogon,
                airline_headquarters, airline_website, airline_established;
        private ImageView image;
        DataOffliner data;
        CardView card_click;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            passenger_name = itemView.findViewById(R.id.passenger_name);
            trips = itemView.findViewById(R.id.trips);
            airline_name = itemView.findViewById(R.id.airline_name);
            airline_id = itemView.findViewById(R.id.airline_id);

            airline_country = itemView.findViewById(R.id.airline_country);
            airline_slogon = itemView.findViewById(R.id.airline_slogon);
            airline_headquarters = itemView.findViewById(R.id.airline_headquarters);
            airline_website = itemView.findViewById(R.id.airline_website);
            airline_established = itemView.findViewById(R.id.airline_established);

            card_click = itemView.findViewById(R.id.card_click);
        }

        public void setData(DataOffliner object) {
            this.data = object;

            image.setImageResource(R.drawable.ic_baseline_wifi_off_24);

            passenger_name.setText("Passenger Name: " + object.getName());
            trips.setText("Trip count: " + object.getTrips() + "");
            airline_id.setText("Airline Id: " +  object.getName_airline());
            airline_name.setText("Airline Name: " + object.getId_airline());
            airline_country.setText("Country: " + object.getName_airline());
            airline_slogon.setText("Slogon: " + object.getLogo());
            airline_headquarters.setText("Headquarters: " +object.getName_airline());
            airline_website.setText("Website: " +  object.getHead_quaters());
            airline_established.setText("Established: " + object.getWebsite());



            card_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PassengerDetailActivity.class);
                    intent.putExtra("ID", object.get_id());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }
    }
}
