package com.menucalc.ans;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //inisiasi
    TabLayout tabLayout;
    ViewPager viewPager;
    Button buttonReset,buttonOke;
    int icons[] = {R.drawable.ic_menu,R.drawable.ic_kasir,R.drawable.ic_riwayat};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.tambah_settings) {
            startActivity(new Intent(getApplicationContext(),TambahMenuActivity.class));
            return true;
        } else if (id == R.id.tentang_settings) {
            startActivity(new Intent(getApplicationContext(),TentangActivity.class));
            return true;
        } else return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //inisiasi sumber icon untuk tablayout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager); //menghubungkan tablayout dengan view page
        //menampilkan icon pada tiap2 tablayout
        for (int i=0;i<tabLayout.getTabCount();i++){
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

    }

    //pengaturan fragment adapter
    private class CustomAdapter extends FragmentPagerAdapter {

        //inisiasi objek
        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        //case pemanggilan fragment
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0 :
                    MenuFragment tabMenu = new MenuFragment();
                    return tabMenu;
                case 1 :
                    KasirFragment tabKasir = new KasirFragment();
                    return tabKasir;
                case 2 :
                    RiwayatFragment tabRiwayat = new RiwayatFragment();
                    return tabRiwayat;
                default :
                    return null;
            }
        }

        //memanggil nilai kembali posisi penunjuk fragment
        @Override
        public int getCount() {
            return icons.length;
        }

        //memasang judul pada tab layout (karena tidak pakai judul teks nilai returnya null)
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
