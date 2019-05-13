package com.example.adminlarise;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    MapsActivity mp;

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

        ViewHolder viewHolder = new ViewHolder(view,this.set,MainImageUploadInfoList);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        PesananObjek po = MainImageUploadInfoList.get(position);

        holder.txtNama.setText(po.getKey());
        holder.txtStatus.setText(po.getStatus());
        holder.txtTotal.setText(String.valueOf(po.getTotal()));
//        holder.ubah.setText("Ubah Status");
        holder.map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MapsActivity();
                Global.latitude = MainImageUploadInfoList.get(position).getLatitude();
                Global.longitude= MainImageUploadInfoList.get(position).getLongitude();
                Context context = v.getContext();
                Log.e("ADAPTER", String.valueOf(Global.longitude));
                Intent intent = new Intent(context ,MapsActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtNama,txtStatus,txtTotal;
        public Button ubah,map;
        List<PesananObjek> dp;

        public ViewHolder(View itemView,Button set,List<PesananObjek> dp ) {

            super(itemView);

            txtNama = itemView.findViewById(R.id.nama);
            txtStatus = itemView.findViewById(R.id.status);
            txtTotal = itemView.findViewById(R.id.total);
            ubah = itemView.findViewById(R.id.proses);
            this.map= itemView.findViewById(R.id.map);
            //map.setOnClickListener(this);
            this.dp = dp;
        }

        @Override
        public void onClick(View v) {
//            Global.updateStatus();

        }
    }
}
