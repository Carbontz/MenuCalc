package com.menucalc.ans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Reza on 06/05/2016.
 */
public class MenuFragment extends Fragment {

    String judulMenu[] = {"Makanan","Minuman"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.frag_menu,container,false);
        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.viewPagerFragMenu);
        final TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabLayoutFragMenu);

        tabLayout.addTab(tabLayout.newTab().setText("Makanan"));
        tabLayout.addTab(tabLayout.newTab().setText("Minuman"));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        viewPager.setAdapter(new PagerAdapter(getFragmentManager(),tabLayout.getTabCount()+1));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return inflatedView;
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm, int context) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    TabMakananMenuFragment tabMakananMenuFragment = new TabMakananMenuFragment();
                    return tabMakananMenuFragment;
                case 1:
                    TabMinumanMenuFragment tabMinumanMenuFragment = new TabMinumanMenuFragment();
                    return tabMinumanMenuFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return judulMenu.length;
        }

        public CharSequence getPageTitle (int position) {
            return judulMenu[position];
        }
    }
}