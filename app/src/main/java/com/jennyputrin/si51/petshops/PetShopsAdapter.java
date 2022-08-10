package com.jennyputrin.si51.petshops;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PetShopsAdapter extends RecyclerView.Adapter<PetShopsAdapter.viewHolder>{
    private List<PetShops> mData;
    private OnItemClickListener onItemClickListener;

    public PetShopsAdapter(List<PetShops> mData, OnItemClickListener onItemClickListener) {
        this.mData = mData;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_petshops,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.bind(mData.get(position),onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat;
        ImageView ivPetShop;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama=itemView.findViewById(R.id.tv_nama);
            tvAlamat=itemView.findViewById(R.id.tv_alamat);
            ivPetShop=itemView.findViewById(R.id.iv_petshop);

        }
        public void bind (final PetShops item, OnItemClickListener onItemClickListener){
            tvNama.setText(item.getNamaPetShop());
            tvAlamat.setText(item.getAlamatPetShop());
            ivPetShop.setImageResource(item.getPicPetShop());
            itemView.setOnClickListener(v -> {
                onItemClickListener.onItemClick(item,getPosition());
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(PetShops item,int position );
    }
}
