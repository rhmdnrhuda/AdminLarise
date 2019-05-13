package com.example.adminlarise;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.ViewHolder> {

    Context context;
    List<PesananObjek> MainImageUploadInfoList;
    Button set;
    public PesananAdapter(Context context, List<PesananObjek> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }
    public void setSet(Button b){
        this.set = b;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view,this.set);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PesananObjek po = MainImageUploadInfoList.get(position);

        holder.txtNama.setText(po.getKey());
        holder.txtStatus.setText(po.getStatus());
        holder.txtTotal.setText(String.valueOf(po.getTotal()));
        holder.ubah.setText("Ubah Status");
        holder.map.setText("Lihat Lokasi");


    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtNama,txtStatus,txtTotal;
        public Button ubah,map;

        public ViewHolder(View itemView,Button set) {

            super(itemView);

            txtNama = itemView.findViewById(R.id.nama);
            txtStatus = itemView.findViewById(R.id.status);
            txtTotal = itemView.findViewById(R.id.total);
            ubah = itemView.findViewById(R.id.proses);
            map= itemView.findViewById(R.id.map);
        }

        @Override
        public void onClick(View v) {
            Global.updateStatus(Global.po.);
        }
    }
}
