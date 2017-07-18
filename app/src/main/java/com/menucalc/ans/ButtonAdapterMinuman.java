package com.menucalc.ans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Reza on 10/05/2016.
 */
public class ButtonAdapterMinuman extends BaseAdapter {

    /*private DBAdapter dbAdapter;
    protected ArrayList<String> info_menu;*/
    private final String[] minuman;
    private final int[] hargaMinuman;
    private Context context;
    private TextView tvMenu,tvHarga;
    private ImageView bintang;

    public ButtonAdapterMinuman(Context context, String[] minuman, int[] hargaMinuman) {
        this.context = context;
        this.minuman = minuman;
        this.hargaMinuman = hargaMinuman;
    }

    @Override
    public int getCount() {
        return minuman.length;
    }

    @Override
    public Object getItem(int position) {
        return minuman[position];
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
        if(position==3) {
            bintang.setVisibility(View.VISIBLE);
        } else {
            bintang.setVisibility(View.GONE);
        }
        /*memanggil isi tabel makanan dan dicetak
        panggilMinuman();*/

        //tampilkan nilai dari masing2 array
        tvMenu.setText(minuman[position]);
        tvHarga.setText("Rp "+ String.valueOf(hargaMinuman[position])+",-");

        return convertView;
    }

    /*public void panggilMinuman() {
        info_menu.clear();
        dbAdapter.openDB(); //membuka database
        int nomor,hargaMinuman;
        String nama;
        List<Menu> menuList= dbAdapter.getAllMinuman();

        /*while (cursor.moveToNext()) {
            nomor = cursor.getInt(1);
            info_menu.add(String.valueOf(nomor));
            nama = cursor.getString(2);
            info_menu.add(nama);
            arrayHargaMakanan = cursor.getInt(3);
            info_menu.add(String.valueOf(arrayHargaMakanan));
            menuMinuman = new Menu(nomor, nama, arrayHargaMakanan);
            tvMenu.setText(menuMinuman.getMenulist());
            tvHarga.setText(menuMinuman.getHargalist());
        }
        dbAdapter.close();
    }*/
}

