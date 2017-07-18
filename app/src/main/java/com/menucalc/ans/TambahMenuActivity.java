package com.menucalc.ans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Reza on 08/05/2016.
 */
public class TambahMenuActivity extends AppCompatActivity {

    public String tempNama,tempHarga,tempMenu;
    private EditText nama,harga;
    private Spinner menu;
    private Button simpan;
    private DBAdapter dbAdapter;
    private boolean isInserted;
    private Menu menuObject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_tambah_menu);

        //UI references
        nama = (EditText) findViewById(R.id.etNama);
        harga = (EditText) findViewById(R.id.etHarga);
        menu = (Spinner) findViewById(R.id.spinMenu);
        simpan = (Button) findViewById(R.id.btnSimpan);
        dbAdapter = new DBAdapter(this);
        tambahMenu();
    }

    public void tambahMenu() {
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ambil nilai dari form
                tempNama = nama.getText().toString();
                tempMenu = menu.getSelectedItem().toString();
                tempHarga = harga.getText().toString();
                int tempHarga2 = Integer.parseInt(tempHarga);
                if (tempMenu=="Makanan") {
                    //panggil fungsi insert
                    menuObject = new Menu(tempNama,tempHarga2);
                    isInserted = dbAdapter.insertMakanan(menuObject);
                } else {
                    menuObject = new Menu(tempNama,tempHarga2);
                    isInserted = dbAdapter.insertMinuman(menuObject);
                }
                if (isInserted=true) {
                    Toast.makeText(TambahMenuActivity.this, "Menu Berhasil Ditambah!", Toast.LENGTH_LONG).show();
                    nama.setText("");
                    harga.setText("");
                } else  {
                    Toast.makeText(TambahMenuActivity.this, "Menu Gagal Ditambah!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
