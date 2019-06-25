package cn.edu.gdpt.androiddemo.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.edu.gdpt.androiddemo.R;
import cn.edu.gdpt.androiddemo.ViewPaperAdapter;

public class SlapseActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private Button mBtnGo;
    private ViewPaperAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slapse);
        initView();

    }

    private void initView() {
        mViewPager = (ViewPager)findViewById(R.id.vp_guide);
        mBtnGo = (Button)findViewById(R.id.btn_go);

        View view1 = View.inflate(this, R.layout.guide_view, null);
        View view2 = View.inflate(this, R.layout.guide_view, null);
        View view3 = View.inflate(this, R.layout.guide_view, null);

        ((ImageView)view1.findViewById(R.id.tv_pic)).setImageResource(R.drawable.money);
        ((ImageView)view2.findViewById(R.id.tv_pic)).setImageResource(R.drawable.exchanger);
        ((ImageView)view3.findViewById(R.id.tv_pic)).setImageResource(R.drawable.go);
        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SlapseActivity.this, "Go Home", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(SlapseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        view1.findViewById(R.id.tv_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });
        view2.findViewById(R.id.tv_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
            }
        });
        view3.findViewById(R.id.tv_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2);
            }
        });

        ((TextView)view1.findViewById(R.id.tv_title)).setText("各国货币齐聚");
        ((TextView)view1.findViewById(R.id.tv_title)).setTextColor(Color.parseColor("#FF5000"));
        ((TextView)view2.findViewById(R.id.tv_title)).setText("各类货币转换");
        ((TextView)view2.findViewById(R.id.tv_title)).setTextColor(Color.parseColor("#49ca65"));
        ((TextView)view3.findViewById(R.id.tv_title)).setText("欢迎使用！");
        ((TextView)view3.findViewById(R.id.tv_title)).setTextColor(Color.parseColor("#16c5c6"));

        ((TextView)view1.findViewById(R.id.tv_desc)).setText("只有你想得到\n没有我们找得到");
        ((TextView)view2.findViewById(R.id.tv_desc)).setText("给你最低价\n利益最大化");
        ((TextView)view3.findViewById(R.id.tv_desc)).setText("美金欧元任你换\n扫二维码支持下");

        mViewPager = (ViewPager) findViewById(R.id.vp_guide);

        ArrayList<View> views = new ArrayList<>();
        views.add(view1);
        views.add(view2);
        views.add(view3);

        vpAdapter = new ViewPaperAdapter(views);

        mViewPager.setOffscreenPageLimit(views.size());
        mViewPager.setPageMargin(-dip2px(135));
        mViewPager.setAdapter(vpAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position + 1 == mViewPager.getAdapter().getCount()) {
                    if (mBtnGo.getVisibility() != View.VISIBLE) {
                        mBtnGo.setVisibility(View.VISIBLE);
                        mBtnGo.startAnimation(AnimationUtils.loadAnimation(SlapseActivity.this, android.R.anim.fade_in));
                    }
                } else {
                    if (mBtnGo.getVisibility() != View.GONE) {
                        mBtnGo.setVisibility(View.GONE);
                        mBtnGo.startAnimation(AnimationUtils.loadAnimation(SlapseActivity.this, android.R.anim.fade_out));
                    }
                }
            }
        });
        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            private static final float MIN_SCALE = 0.85f;
            private static final float MIN_TXT_SCALE = 0.0f;
            private static final float MIN_TXT_ALPHA = 0.0f;

            @SuppressLint("NewApi")
            @Override
            public void transformPage(View view, float position) {
                View mGuideImage = view.findViewById(R.id.tv_pic);
                View mTitle = view.findViewById(R.id.tv_title);
                View mDesc = view.findViewById(R.id.tv_desc);

                int viewWidth = mDesc.getWidth();

                if (position < -1) {
                    mTitle.setAlpha(0);
                    mDesc.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                    float scaleTxtFactor = Math.max(MIN_TXT_SCALE, 1 - Math.abs(position));
                    mGuideImage.setScaleX(scaleFactor);
                    mGuideImage.setScaleY(scaleFactor);

                    mTitle.setScaleX(scaleTxtFactor);
                    mTitle.setScaleY(scaleTxtFactor);
                    mTitle.setAlpha(MIN_TXT_ALPHA + (scaleTxtFactor - MIN_TXT_SCALE) / (1 - MIN_TXT_SCALE) * (1 - MIN_TXT_ALPHA));

                    mDesc.setAlpha(mTitle.getAlpha());
                    mDesc.setScaleX(scaleTxtFactor);
                    mDesc.setScaleY(scaleTxtFactor);
                } else {
                    mTitle.setAlpha(0);
                    mDesc.setAlpha(0);
                }
            }
        });
    }

    private int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
