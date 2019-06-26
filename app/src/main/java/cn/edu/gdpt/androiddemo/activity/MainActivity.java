package cn.edu.gdpt.androiddemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.gdpt.androiddemo.R;
import cn.edu.gdpt.androiddemo.adapter.FragmentPagerAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ImageView img_main_menu;
    private TabLayout tablayout_main;
    public static ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private CircleImageView circle;
    private TextView vip,shoucang,duihuan,tvname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
        initView();
        String userInfo = RegisterActivity.username;
        if (userInfo != null){
            tvname.setText(userInfo);
        }
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
        circle = (CircleImageView) findViewById(R.id.circle);
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        vip = (TextView) findViewById(R.id.vip);
        shoucang = (TextView) findViewById(R.id.shoucang);
        duihuan = (TextView) findViewById(R.id.duihuan);
        tvname=(TextView)findViewById(R.id.tv_name);
    }


}
