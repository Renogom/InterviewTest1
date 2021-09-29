package com.m.edutabtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m.edutabtest.R;
import com.m.edutabtest.models.Airline;
import com.m.edutabtest.models.Data;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PassengerDetailAdapter extends RecyclerView.Adapter<PassengerDetailAdapter.ViewHolder> {
    List<Data> dataArrayList = new ArrayList<>();
    Context context;

    public PassengerDetailAdapter(List<Data> dataArrayList, Context context) {
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
    public void onBindViewHolder(@NonNull PassengerDetailAdapter.ViewHolder holder, int position) {
        holder.setData(dataArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView passenger_name, trips, airline_name,airline_id,airline_country,airline_slogon,
                airline_headquarters,airline_website,airline_established;
        private ImageView image;
        Data data;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            passenger_name = itemView.findViewById(R.id.passenger_name);
            trips = itemView.findViewById(R.id.trips);
            airline_name = itemView.findViewById(R.id.airline_name);
            airline_id=itemView.findViewById(R.id.airline_id);

            airline_country=itemView.findViewById(R.id.airline_country);
            airline_slogon=itemView.findViewById(R.id.airline_slogon);
            airline_headquarters=itemView.findViewById(R.id.airline_headquarters);
            airline_website=itemView.findViewById(R.id.airline_website);
            airline_established=itemView.findViewById(R.id.airline_established);
        }

        public void setData(Data object) {
            this.data = object;

            for (Airline airline:object.getAirline()){
                Picasso.with(context).load(airline.getLogo()).into(image);
                airline_id.setText("Airline Id: "+airline.getId());
                airline_name.setText("Airline Name: "+airline.getName());
                airline_country.setText("Country: "+airline.getCountry());
                airline_slogon.setText("Slogon: "+airline.getSlogan());
                airline_headquarters.setText("Headquarters: "+airline.getHead_quaters());
                airline_website.setText("Website: "+airline.getWebsite());
                airline_established.setText("Established: "+airline.getEstablished());
            }

            passenger_name.setText("Passenger Name: "+object.getName());
            trips.setText("Trip count: "+object.getTrips()+"");

        }
    }
}
