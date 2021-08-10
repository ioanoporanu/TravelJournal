package com.example.myapplication.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class JourneyAdapter extends RecyclerView.Adapter<JourneyAdapter.JourneyViewHolder> {
    List<Journey> journeyList;
    private Context context;

    public JourneyAdapter(Context context) {
        this.context = context;
    }
    
    public void setJourneyList(List<Journey> journeyList){
           this.journeyList = journeyList;
           notifyDataSetChanged();
    }

    public JourneyAdapter(ArrayList<Journey> journeyList) {
        this.journeyList = journeyList;
    }

    @NonNull
    @NotNull
    @Override
    public JourneyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.journey_layout, parent, false);
        return new JourneyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull JourneyViewHolder holder, int position) {
        String journeyName = journeyList.get(position).getJourneyName();
        holder.nameTextView.setText(journeyName);
        String destination = journeyList.get(position).getDestination();
        holder.destinationTextView.setText(destination);
        String price = journeyList.get(position).getPrice();
        holder.priceTextView.setText(price);
        int image = journeyList.get(position).getImage();
        holder.imageView.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return journeyList.size();
    }

    public class JourneyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView destinationTextView;
        private TextView priceTextView;
        private ImageView imageView;

        public JourneyViewHolder(final View view) {
            super(view);
            nameTextView = view.findViewById(R.id.name);
            destinationTextView = view.findViewById(R.id.destination);
            priceTextView = view.findViewById(R.id.price);
            imageView = view.findViewById(R.id.imageView);
        }
    }
}
