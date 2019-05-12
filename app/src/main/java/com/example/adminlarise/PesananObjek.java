package com.example.adminlarise;

import android.util.Log;

import java.io.Serializable;

public class PesananObjek implements Serializable {
    private String nama;
    private int biaya;
    private boolean isOnChart;
    private String no;
//    private ArrayList<Pesanan> pesanan;
//    private String id;
//    private double latitude;
//    private double longitude;
//    private String status;
//    private int total;

    public PesananObjek(){}

//    public PesananObjek(String id, double latitude,double longitude,ArrayList<Pesanan> pesanan,String status,int total){}

    public PesananObjek(int biaya,boolean isOnChart,String nama, String no) {
        this.nama = nama;
        this.biaya = biaya;
        this.isOnChart = isOnChart;
        this.no =no;

    }

    public String getNama() {
        Log.e("Cek Nama",nama);
        return nama;
    }


    public void setNama(String nama) {

        this.nama = nama;
    }

    public int getBiaya() {
        return biaya;
    }

    public boolean getIsOnChart(){
        return isOnChart;
    }
    public void setBiaya(int biaya) {

        this.biaya = biaya;
    }
//
//    public String getNo() {
//        return no;
//    }
//
//    public void setNo(String no) {
//        this.no = no;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }
}
