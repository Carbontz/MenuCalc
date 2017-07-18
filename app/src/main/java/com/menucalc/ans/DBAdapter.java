package com.menucalc.ans;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reza on 07/05/2016.
 */
public class DBAdapter extends SQLiteOpenHelper {

    //komponen android
    SQLiteDatabase db;
    Cursor cursor;
    Menu menu;

    //database
    private static final String DB_NAMA = "menuCalc"; //deklarasi nama database
    private static final int DB_VERSION = 1; //versi database
    private static final String DB_TABEL_MAKANAN = "MAKANAN"; //nama tabel makanan
    private static final String DB_TABEL_MINUMAN = "MINUMAN"; //nama tabel minuman

    //field table
    private static final String KEY_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_HARGA = "arrayHargaMakanan";

    //perintah membuat tabel makanan
    private static final String TABEL_MAKANAN = "CREATE TABLE "+ DB_TABEL_MAKANAN + " ( "
            +KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_NAMA+" TEXT, "
            +KEY_HARGA+" INTEGER);";

    //perintah membuat tabel minuman
    private static final String TABEL_MINUMAN = "CREATE TABLE "+ DB_TABEL_MINUMAN + " ( "
            +KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +KEY_NAMA+" TEXT, "
            +KEY_HARGA+" INTEGER);";

    //perintah drop tabel
    private static final String DROP_MAKANAN = "DROP TABLE IF EXIST " + DB_TABEL_MAKANAN +";";
    private static final String DROP_MINUMAN = "DROP TABLE IF EXIST " + DB_TABEL_MINUMAN +";";

    public DBAdapter(Context context) {
        super(context, DB_NAMA, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABEL_MAKANAN);
        db.execSQL(TABEL_MINUMAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_MAKANAN);
        db.execSQL(DROP_MINUMAN);
        onCreate(db);
        throw new UnsupportedOperationException();
    }

    //INSERT data ke database
    public boolean insertMakanan(Menu menu){
        //open connection
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAMA,menu.getMenulist());
        values.put(KEY_HARGA,menu.getHargalist());
        //insert row
        long result = db.insert(DB_TABEL_MAKANAN,null,values);
        if (result==-1){
            return false;
        } else {
            db.close();
            return true;
        }
    }

    public boolean insertMinuman(Menu menu){
        //open connection
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAMA,menu.getMenulist());
        values.put(KEY_HARGA,menu.getHargalist());
        //insert row
        long result = db.insert(DB_TABEL_MINUMAN,null,values);
        if (result==-1){
            return false;
        } else {
            db.close();
            return true;
        }
    }

    //Memanggil dan menampilkan semua data tabel makanan dari database
    public List<Menu> getAllMakanan(){
        List<Menu> menuList = new ArrayList<Menu>();
        String selectQuery = "SELECT * FROM " + DB_TABEL_MAKANAN;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        //looping semua row dan menambahkannya ke list
        if (cursor.moveToFirst()) do {
            menu = new Menu();
            menu.setNolist(Integer.parseInt(cursor.getString(0)));
            menu.setMenulist(cursor.getString(1));
            menu.setHargalist(Integer.parseInt(cursor.getString(2)));
            //tambah ke list
            menuList.add(menu);
        } while (cursor.moveToNext());
        return menuList;
    }

    //Memanggil dan menampilkan data tabel minuman dari database
    public List<Menu> getAllMinuman(){
        String selectQuery = "SELECT * FROM " + DB_TABEL_MINUMAN;
        List<Menu> menuList = new ArrayList<Menu>();
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        //looping semua row dan menambahkannya ke list
        if (cursor.moveToFirst()) do {
            int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            String nama = cursor.getString(cursor.getColumnIndex(KEY_NAMA));
            String harga = cursor.getString(cursor.getColumnIndex(KEY_HARGA));

            menu = new Menu();
            menu.setNolist(Integer.parseInt(cursor.getString(0)));
            menu.setMenulist(cursor.getString(1));
            menu.setHargalist(Integer.parseInt(cursor.getString(2)));
            //tambah ke list
            menuList.add(menu);
        } while (cursor.moveToNext());
        return menuList;
    }

    //Membuka database
    public DBAdapter openDB() {
        db = this.getWritableDatabase();
        return this;
    }

    //Menutup database
    public void close() {
        db.close();
    }
}
