package com.menucalc.ans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Reza on 10/05/2016.
 */
public class ButtonAdapterMakanan extends BaseAdapter {

    private Menu menuMakanan;
    private ArrayList<Menu> menu;
    private Context context;
    private TextView tvMenu, tvHarga;
    private String[] makanan;
    private int[] hargaMakanan;
    private ImageView bintang;

    public ButtonAdapterMakanan(Context context, String[] makanan, int[] hargaMakanan) {
        this.context = context;
        this.makanan = makanan;
        this.hargaMakanan = hargaMakanan;
    }

    @Override
    public int getCount() {
        return makanan.length;
    }

    @Override
    public Object getItem(int position) {
        return makanan[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            // get layout from btn_menu.xml
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.btn_menu, null);
        }

        // set text view
        tvMenu = (TextView) convertView.findViewById(R.id.txtMenu);
        tvHarga = (TextView) convertView.findViewById(R.id.txtHarga);
        bintang = (ImageView) convertView.findViewById(R.id.iconBintang);

        if(position==0) {
            bintang.setVisibility(View.VISIBLE);
        } else {
            bintang.setVisibility(View.GONE);
        }
        /*memanggil isi tabel makanan dan dicetak
        panggilMakanan();*/

        //tampilkan nilai dari masing2 array
        tvMenu.setText(makanan[position]);
        tvHarga.setText("Rp " + String.valueOf(hargaMakanan[position]) + ",-");

        return convertView;
    }
}

