package com.menucalc.ans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Reza on 06/05/2016.
 */
public class TabMakananMenuFragment extends Fragment {

    private GridView gridView;
    private ButtonAdapterMakanan baMakanan;
    static final String[] arrayMakanan = new String[] {
            "Nasi Goreng", "Nasi Putih","Ayam Balado", "Ayam Bumbu","Ayam Bakar","Dendeng" };
    static final int[] arrayHargaMakanan = { 8000,2000,6000,5000,5000,7000};
    int subHargaMakanan=0;
    private TextView tvAngkaTotal;
    private Button btnResetMakanan;

    private KasirAdapter kasirAdapter = new KasirAdapter(getContext());

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inisiasi UI
        View inflatedView =  inflater.inflate(R.layout.tab_makanan_frag_menu, container, false);
        gridView = (GridView) inflatedView.findViewById(R.id.gvMakanan);
        baMakanan = new ButtonAdapterMakanan(getContext(),arrayMakanan, arrayHargaMakanan);
        gridView.setAdapter(baMakanan);

        tvAngkaTotal = (TextView) inflatedView.findViewById(R.id.tvTotal);

        //clickable
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),arrayMakanan[position]+" "+ arrayHargaMakanan[position]+" Dipesan",Toast.LENGTH_SHORT).show();
                subHargaMakanan+=arrayHargaMakanan[position];
                tvAngkaTotal.setText(String.valueOf(subHargaMakanan));
            }
        });

        btnResetMakanan = (Button) inflatedView.findViewById(R.id.btnResetMakanan);
        btnResetMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subHargaMakanan=0;
                tvAngkaTotal.setText(String.valueOf(subHargaMakanan));
            }
        });
        return inflatedView;
    }
}


