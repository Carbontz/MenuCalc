package com.menucalc.ans;

import android.content.Context;
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
public class TabMinumanMenuFragment extends Fragment {

    private GridView gridView;
    private ButtonAdapterMinuman baMinuman;
    static final String[] arrayMinuman = new String[] {
            "Kopi", "Teh Panas","Cappucino", "Kopi Ginseng","Teh Tarik","Teh Es" };
    static final int[] arrayHargaMinuman = { 2000,2000,4000,5000,4000,3000};
    private int subHargaMinuman;
    private TextView tvAngkaTotal;
    private Button btnResetMinuman;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inisiasi UI
        View inflatedView =  inflater.inflate(R.layout.tab_minuman_frag_menu, container, false);
        gridView = (GridView) inflatedView.findViewById(R.id.gvMinuman);
        baMinuman = new ButtonAdapterMinuman(getContext(),arrayMinuman,arrayHargaMinuman);
        gridView.setAdapter(baMinuman);

        tvAngkaTotal = (TextView) inflatedView.findViewById(R.id.tvAngkaTotal);

        //clickable
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),arrayMinuman[position]+" "+ arrayHargaMinuman[position],Toast.LENGTH_SHORT).show();
            }
        });

        //clickable
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),arrayMinuman[position]+" "+ arrayHargaMinuman[position]+" Dipesan",Toast.LENGTH_SHORT).show();
                subHargaMinuman +=arrayHargaMinuman[position];
                tvAngkaTotal.setText(String.valueOf(subHargaMinuman));
            }
        });

        btnResetMinuman = (Button) inflatedView.findViewById(R.id.btnResetMinuman);
        btnResetMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subHargaMinuman =0;
                tvAngkaTotal.setText(String.valueOf(subHargaMinuman));
            }
        });

        return inflatedView;
    }
}



