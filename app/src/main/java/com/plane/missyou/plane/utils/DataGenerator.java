package com.plane.missyou.plane.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.plane.missyou.plane.R;
import com.plane.missyou.plane.view.fragment.AddPlaneFragment;
import com.plane.missyou.plane.view.fragment.HomeFragment;
import com.plane.missyou.plane.view.fragment.MessageFragment;
import com.plane.missyou.plane.view.fragment.UserInfoFragment;

/**
 * Created by MissC on 2017/5/4.
 */

public class DataGenerator {

    public static final int []mTabs = new int[]{
            R.drawable.tab_home_selector,
            R.drawable.tab_attention_selector,
            R.drawable.tab_discovery_selector,
            R.drawable.tab_profile_selector
    };

    public static final String []mTabTitle = new String[]{"首页","飞机","消息","我的"};

    public static final int []mTabPesRessed = new int[]{
            R.drawable.ic_tab_strip_icon_feed_selected,
            R.drawable.ic_tab_strip_icon_category_selected,
            R.drawable.ic_tab_strip_icon_pgc_selected,
            R.drawable.ic_tab_strip_icon_profile_selected
    };

    public static Fragment[] getFraments() {
        Fragment fragments[] = new Fragment[4];

        fragments[0] = HomeFragment.newInstance();
//        fragments[1] = ShareFragment.newInstance();
        fragments[2] = MessageFragment.newInstance();
        fragments[3] = UserInfoFragment.newInstance();
        fragments[1] = AddPlaneFragment.newInstance();
        return fragments;
    }

    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabs[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }

    public static Drawable getDrawable(Context context, int drawableResId) {
        Drawable drawable;

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            drawable = context.getResources().getDrawable(drawableResId, context.getTheme());
        } else {
            drawable = VectorDrawableCompat.create(context.getResources(), drawableResId, context.getTheme());
        }
        return drawable;
    }

    public static Drawable getDrawable(Context context, int drawableResId, int colorFilter) {
        Drawable drawable = getDrawable(context, drawableResId);
        drawable.setColorFilter(ContextCompat.getColor(context, colorFilter), PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static Bitmap getBitmap(Context context, int drawableResId) {
        Drawable drawable = getDrawable(context, drawableResId);
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight() );
        drawable.draw(canvas);
        return bitmap;
    }
}
