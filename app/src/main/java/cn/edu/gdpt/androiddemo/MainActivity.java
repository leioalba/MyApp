package cn.edu.gdpt.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import cn.edu.gdpt.androiddemo.Adapter.FragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ImageView img_main_menu;
    private TabLayout tablayout_main;
    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
        initView();
    }

    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

    private void initView() {
        img_main_menu = (ImageView) findViewById(R.id.img_main_menu);
        tablayout_main = (TabLayout) findViewById(R.id.tablayout_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager_main);
        drawerLayout = findViewById(R.id.dl_left);

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);
        tablayout_main.setupWithViewPager(viewPager);

        img_main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDrawerLayout();
            }
        });
    }
}
