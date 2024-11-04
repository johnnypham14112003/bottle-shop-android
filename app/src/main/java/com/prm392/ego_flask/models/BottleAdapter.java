package com.prm392.ego_flask.models;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.prm392.ego_flask.R;

import java.util.List;

public class BottleAdapter extends RecyclerView.Adapter<BottleAdapter.ViewHolder> {
    private List<Bottle> components;
    private Context context;

    public BottleAdapter(List<Bottle> components, Context context) {
        this.components = components;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_row_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bottle component = components.get(position);
        holder.tvNameProduct.setText(component.getName());
        holder.tvProductPrice.setText(Double.toString(component.getPrice()));
        Glide.with(context).load(component.getImageUrl()).into(holder.imgProduct);

        // Set click listener cho btnDetail
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetailsDialog(component);
            }
        });
    }

    private void showProductDetailsDialog(Bottle bottle) {
        // Tạo Dialog hiển thị chi tiết sản phẩm
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Chi tiết sản phẩm");

        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_product_details, null);
        TextView tvName = dialogView.findViewById(R.id.tvName);
        TextView tvPrice = dialogView.findViewById(R.id.tvPrice);
        ImageView ivImage = dialogView.findViewById(R.id.ivImage);

        // Gán thông tin vào các view trong dialog
        tvName.setText(bottle.getName());
        tvPrice.setText("Giá: " + bottle.getPrice() + "đ");
        Glide.with(context).load(bottle.getImageUrl()).into(ivImage);

        builder.setView(dialogView);
        builder.setPositiveButton("Đóng", null);
        builder.show();
    }

    @Override
    public int getItemCount() {
        return components.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameProduct, tvProductPrice;
        ImageView imgProduct;
        CardView cardView;
        Button btnDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameProduct = itemView.findViewById(R.id.productName);
            tvProductPrice = itemView.findViewById(R.id.productPrice);
            imgProduct = itemView.findViewById(R.id.productImage);
            cardView = itemView.findViewById(R.id.productItem);
            btnDetail = itemView.findViewById(R.id.btnDetail); // Thêm btnDetail
        }
    }
}
