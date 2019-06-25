package cn.edu.gdpt.androiddemo.utils;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.edu.gdpt.androiddemo.MainActivity;
import cn.edu.gdpt.androiddemo.bean.MyHuilv;
import cn.edu.gdpt.androiddemo.fragment.CoverterFragment;
import cn.edu.gdpt.androiddemo.fragment.HomeFragment;

public class Databinguntil {
   @BindingAdapter( {"imgs","activity"})
    public static void loadimg(ImageView imageView, String src, int activity){
       if(src!=null){
           String converterToFirstSpell = OkhttpUntil.converterToFirstSpell(src);
           if(activity==0){
               if(HomeFragment.activitys!=null){
                   int drawable = HomeFragment.activitys.getResources().getIdentifier(converterToFirstSpell, "drawable", HomeFragment.activitys.getPackageName());
                   imageView.setImageResource(drawable);
               }
           }else if(activity==1){
               if(CoverterFragment.activity!=null){
                   int drawable = CoverterFragment.activity.getResources().getIdentifier(converterToFirstSpell, "drawable", CoverterFragment.activity.getPackageName());
                   imageView.setImageResource(drawable);
               }
           }
       }
     /* if(mode==0){
          if(HomeFragment.activity!=null){
              int drawable = HomeFragment.activity.getResources().getIdentifier(converterToFirstSpell, "drawable", HomeFragment.activity.getPackageName());
              imageView.setImageResource(drawable);
          }
      }else if(mode==1){
          if(CoverterFragment.activity!=null){
              int drawable = CoverterFragment.activity.getResources().getIdentifier(converterToFirstSpell, "drawable", CoverterFragment.activity.getPackageName());
              imageView.setImageResource(drawable);
          }
      }*/
       //   imageView.setImageResource(drawable);
   }
    @BindingAdapter("item")
    public static void jump(LinearLayout imageView,final MyHuilv.DataBean name){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if( MainActivity.viewPager!=null){
                   MainActivity.viewPager.setCurrentItem(1);
                   CoverterFragment.Setdata(name);
               }
            }
        });
    }

  /*  @BindingAdapter("submit")
    public static void submitButton(SubmitButton submitButton, final MyHuilv.DataBean name){
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }*/


}
