package com.example.projectexercise.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectexercise.CustomViewPager;

import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;
import com.example.projectexercise.ui.Itemdetailpage.Page1Bottom;
import com.example.projectexercise.ui.Itemdetailpage.Page1Top;
import com.example.projectexercise.ui.Itemdetailpage.Page2Bottom;
import com.example.projectexercise.ui.Itemdetailpage.Page2Top;
import com.example.projectexercise.ui.Itemdetailpage.Page3Bottom;
import com.example.projectexercise.ui.Itemdetailpage.Page3Top;
import com.example.projectexercise.ui.Itemdetailpage.Page4Bottom;
import com.example.projectexercise.ui.Itemdetailpage.Page4Top;
import com.example.projectexercise.ui.Itemdetailpage.Page5Bottom;
import com.example.projectexercise.ui.Itemdetailpage.Page5Top;

import com.example.projectexercise.R;
import com.example.projectexercise.adapter.viewpager.ViewPagerSearchItemAdapter;
import com.example.projectexercise.adapter.viewpager.ViewPagerSearchItemAdapter2;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.Map;

public class ItemDetailPage extends AppCompatActivity {
    TabLayout tabLayout;
    CustomViewPager pager_1,pager_2;
    ViewPagerSearchItemAdapter pager1Adapter;//viewpager1調適器
    ViewPagerSearchItemAdapter2 pager2Adapter;//viewpager2調適器
    private Toolbar toolbar;
    public ResultMoDataModel page_list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        pager_1 = findViewById(R.id.pager_1);
        pager_2 = findViewById(R.id.pager_2);

        toolbar.setTitle("進度表查詢");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetailPage.this, SearchPage.class);
                startActivity(intent);
            }
        });

        page_list = (ResultMoDataModel) getIntent().getSerializableExtra("item_data");
        pager1Adapter = new ViewPagerSearchItemAdapter(this.getSupportFragmentManager());
        pager_1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pager_2.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pager2Adapter = new ViewPagerSearchItemAdapter2(this.getSupportFragmentManager());
        pager_2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pager_1.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        pager_1.setSlidingEnable(false);
        pager_2.setSlidingEnable(false);
        setupAdapter(pager_1);
        setupAdapter2(pager_2);
        //pager_2要在前，不然標題會沒有字。
        tabLayout.setupWithViewPager(pager_2);
        tabLayout.setupWithViewPager(pager_1);

    }
    public void setupAdapter(ViewPager viewPager){
        pager1Adapter.addFragment(new Page1Top(), "本階製令");
        pager1Adapter.addFragment(new Page2Top(), "前關製令");
        pager1Adapter.addFragment(new Page3Top(), "後關製令");
        pager1Adapter.addFragment(new Page4Top(), "裝配製令");
        pager1Adapter.addFragment(new Page5Top(), "銷售訂單");
        viewPager.setAdapter(pager1Adapter);
    }

    public void setupAdapter2(ViewPager viewPager){
        pager2Adapter.addFragment(new Page1Bottom());
        pager2Adapter.addFragment(new Page2Bottom());
        pager2Adapter.addFragment(new Page3Bottom());
        pager2Adapter.addFragment(new Page4Bottom());
        pager2Adapter.addFragment(new Page5Bottom());
        viewPager.setAdapter(pager2Adapter);
    }
    public ResultMoDataModel getPage(){
        return page_list;
    }
}