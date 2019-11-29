package com.bawei.myapplication;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TableLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;
    ArrayList<String> name = new ArrayList<>();
    private RadioGroup m_rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.m_vp);
        tab = findViewById(R.id.m_tab);
        m_rg = findViewById(R.id.m_rg);
        findViewById(R.id.m_b1);
        findViewById(R.id.m_b2);
        findViewById(R.id.m_b3);
        final ArrayList<Fragment> list = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        BookFragment bookFragment = new BookFragment();
        BookFragment bookFragment1 = new BookFragment();
        list.add(homeFragment);
        list.add(bookFragment);
        list.add(bookFragment1);
        name.add("地方");
        name.add("发给");
        name.add("共和国");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);

            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return name.get(position);
            }
        });
        tab.setupWithViewPager(vp);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                m_rg.check(m_rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        vp.setCurrentItem(0);
        m_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.m_b1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.m_b2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.m_b3:
                        vp.setCurrentItem(3);
                        break;

                }
            }
        });

    }
    public void gg(){
        vp.setCurrentItem(2);
    }
}
