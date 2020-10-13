package com.example.testalodokter.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testalodokter.R;
import com.example.testalodokter.ui.DetailActivity;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.ViewHolder> {

    private Activity activity;
    private int[] imageList;

    public AdapterMenu(Activity activity, int[] imageList) {
        this.activity = activity;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.imageView.setImageResource(imageList[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, DetailActivity.class).putExtra(DetailActivity.EXTRA_DATA, String.valueOf(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivImage);
            cardView = itemView.findViewById(R.id.parent);
        }
    }
}
