package com.menucalc.ans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Reza on 06/05/2016.
 */
public class KasirFragment extends Fragment {

    static final String[] arrayMakanan = new String[] {
            "Nasi Goreng", "Nasi Putih","Ayam Balado", "Ayam Bumbu","Ayam Bakar","Dendeng" };
    static final int[] arrayHargaMakanan = { 8000,2000,6000,5000,5000,7000};
    static final String[] arrayMinuman = new String[] {
            "Kopi", "Teh Panas","Cappucino", "Kopi Ginseng","Teh Tarik","Teh Es" };
    static final int[] arrayHargaMinuman = { 2000,2000,4000,5000,4000,3000};
    private ListView listView;
    private KasirAdapter kasirAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView =  inflater.inflate(R.layout.frag_kasir, container, false);
        listView = (ListView) inflatedView.findViewById(R.id.listView);
        kasirAdapter = new KasirAdapter(getContext());
        listView.setAdapter(kasirAdapter);
        return inflatedView;
    }
}
