package com.example.adminlarise;

import android.util.Log;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PesananObjek implements Serializable {
    private int total;
    private String id;
    private String status;
    private double latitude;
    private String key;
    private double longitude;
    private ArrayList<Pesanan> pesanan;
    private String catatan;
    public String Alamat;
    public PesananObjek(){

    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public PesananObjek(String status, double latitude, double longitude) {
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String generateId(){
        return new SimpleDateFormat("dd-MM-yyyy-HH:mm", Locale.getDefault()).format(new Date());
    }

    public String getId() {
        Log.e("Lonte",id);
        return id;
    }

    public void setId() {
        this.id = generateId();
    }



    public void add(Pesanan pesanan){
        this.pesanan.add(pesanan);
        total+=pesanan.getBiaya();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void hapus(Pesanan pesanan){
        this.pesanan.remove(pesanan);
    }

    public int getTotal() {
        total=0;
        if (pesanan!=null){
            for (int i=0;i<pesanan.size();i++){
                total+=pesanan.get(i).getBiaya();
            }
        }
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Pesanan> getPesanan() {
        return pesanan;
    }

    public void setPesanan(ArrayList<Pesanan> pesanan) {
        this.pesanan = pesanan;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
