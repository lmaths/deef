package com.rightside.deef.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rightside.deef.R;
import com.rightside.deef.client.model.Offer;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    private List<Offer> offers;
    private Context context;

    public OfferAdapter(List<Offer> offers, Context context) {
        this.offers = offers;
        this.context = context;
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ofertas, parent, false);

        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        Offer offer = offers.get(position);

        Glide.with(context).load(offer.getUrlPhoto()).circleCrop().into(holder.imageViewStorePicture);
        holder.textViewStoreName.setText(offer.getStoreName());
        holder.textViewSellerName.setText(offer.getSellerName());
        holder.textViewPrice.setText(String.valueOf(offer.getPrice()));

    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public class OfferViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewStorePicture;
        private TextView textViewStoreName;
        private TextView textViewSellerName;
        private TextView textViewPrice;

        public OfferViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewStorePicture = itemView.findViewById(R.id.imageView_store_picture);
            textViewStoreName = itemView.findViewById(R.id.textView_store_name);
            textViewSellerName = itemView.findViewById(R.id.textView_seller_name);
            textViewPrice = itemView.findViewById(R.id.textView_price);
        }
    }
}
