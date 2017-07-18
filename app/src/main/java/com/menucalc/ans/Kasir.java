package com.menucalc.ans;

/**
 * Created by Reza on 17/05/2016.
 */
public class Kasir {
    public int nomor;
    public String menu;
    public int harga;

    public Kasir(int nomor, String menu, int harga) {
        this.nomor = nomor;
        this.menu = menu;
        this.harga = harga;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
