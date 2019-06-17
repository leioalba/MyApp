package cn.edu.gdpt.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ImageView img_main_menu;
    private TabLayout tablayout_main;

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
        drawerLayout = findViewById(R.id.dl_left);

        tablayout_main.addTab(tablayout_main.newTab().setText("市场汇率"));
        tablayout_main.addTab(tablayout_main.newTab().setText("汇率转换"));
        img_main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDrawerLayout();
            }
        });
    }
}
