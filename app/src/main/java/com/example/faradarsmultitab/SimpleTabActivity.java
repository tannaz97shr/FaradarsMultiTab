package com.example.faradarsmultitab;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class SimpleTabActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabs;
    SlidePagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_tab);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        tabs=(TabLayout) findViewById(R.id.tabLayout);
        setUpViewPager();
        tabs.setupWithViewPager(viewPager);
        String type = getIntent().getStringExtra("type");
        if("simple".equals(type)){
            tabs.setTabMode(TabLayout.MODE_FIXED);
        }else if("scrolable".equals(type)) {
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        }else if("IconAndText".equals(type)){
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
            setUpTabIcons();
        }

    }

    private void setUpTabIcons() {
        if(tabs.getTabCount()<4) return;
        tabs.getTabAt(0).setIcon(R.drawable.ic_food);
        tabs.getTabAt(1).setIcon(R.drawable.ic_movie);
        tabs.getTabAt(2).setIcon(R.drawable.ic_discount);
        tabs.getTabAt(3).setIcon(R.drawable.ic_travel);
    }


    private void prepareSlides() {
        String[] titles = getResources().getStringArray(R.array.titles);
        String[] descriptions= getResources().getStringArray(R.array.descriptions);
        int[] bgColors= new int[]
                {R.color.bgColor1, R.color.bgColor2, R.color.bgColor3, R.color.bgColor4};
        int[] imgIds = new int[]
                {R.drawable.ic_food, R.drawable.ic_movie, R.drawable.ic_discount, R.drawable.ic_travel};

        for (int i=0; i<4; i++){
            pagerAdapter.addFragment(
                    SlideFragment.newSlide(ContextCompat.getColor(this , bgColors[i]),
                            imgIds[i], titles[i],descriptions[i]),titles[i]);
        }
    }

    private void setUpViewPager() {
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        prepareSlides();
    }

    public class SlidePagerAdapter extends FragmentPagerAdapter{
        List<Fragment> fragments;
        List<String> tabTitles;

        public SlidePagerAdapter( FragmentManager fm) {
            super(fm);
            fragments=new ArrayList<>();
            tabTitles = new ArrayList<>();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment (Fragment fragment, String tabTitle){
            fragments.add(fragment);
            tabTitles.add(tabTitle);
            notifyDataSetChanged();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles.get(position);
        }
    }

}
