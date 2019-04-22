package com.tarwisoft.ofertoncine2;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tarwisoft.ofertoncine2.model.ClaseGlobal;
import com.tarwisoft.ofertoncine2.view.CompraFragment;
import com.tarwisoft.ofertoncine2.view.ConfirmacionFragment;
import com.tarwisoft.ofertoncine2.view.ProductoFragment;

public class CompraActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {


    private TextView txtTest;
    private ViewPager mViewPager;
    private RadioGroup mPageGroup;
    public ClaseGlobal global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);


        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(this);
        mPageGroup = (RadioGroup) findViewById(R.id.page_group);
        mPageGroup.setOnCheckedChangeListener(this);

        showToolbar("Comprar: Advengers",true);


    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        int radioButtonId = mPageGroup.getChildAt(position).getId();
        mPageGroup.check(radioButtonId);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
        int index = radioGroup.indexOfChild(checkedRadioButton);
        mViewPager.setCurrentItem(index);

    }

    public void showToolbar(String title, boolean upButton){
        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return ProductoFragment.newInstance("ProductoFragment, Instance 1");
                case 1:
                    return CompraFragment.newInstance("CompraFragment, Instance 1");
                default:
                    return ConfirmacionFragment.newInstance("ConfirmacionFragment, Instance 1");
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

    }
}
