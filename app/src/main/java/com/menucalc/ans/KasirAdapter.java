package com.menucalc.ans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Reza on 16/05/2016.
 */
public class KasirAdapter extends BaseAdapter {

    private Menu menu;
    private Context context;
    private TextView noitem,menuitem,hargaitem;

    public KasirAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            // get layout from btn_menu.xml
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_kasir, null);
        }

        // set text view
        noitem = (TextView) convertView.findViewById(R.id.tvNomor);
        menuitem = (TextView) convertView.findViewById(R.id.tvItem);
        hargaitem = (TextView) convertView.findViewById(R.id.tvHarga);

        //set isi teks
        return convertView;

    }
}
