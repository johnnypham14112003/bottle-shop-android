package com.prm392.ego_flask.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.prm392.ego_flask.R;

import java.util.List;

public class BottleAdapter extends RecyclerView.Adapter<BottleAdapter.ViewHolder>{
    private List<Bottle> components;
    private Context context;

    public BottleAdapter(List<Bottle> components, Context context) {
        this.components = components;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bottle component = components.get(position);
        holder.nameTextView.setText(component.getName());
        Glide.with(context).load(component.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return components.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imgBottleOrange);
            cardView = itemView.findViewById(R.id.btnBottleOrange);
        }
    }
}
