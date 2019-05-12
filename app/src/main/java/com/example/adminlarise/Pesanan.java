package com.example.adminlarise;

import java.io.Serializable;

public class Pesanan implements Serializable {
    private String nama;
    private int biaya;
    private boolean isOnChart;
    private String no;

    public Pesanan(){}

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public boolean isOnChart() {
        return isOnChart;
    }

    public void setOnChart(boolean onChart) {
        isOnChart = onChart;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
