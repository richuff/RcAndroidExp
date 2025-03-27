package com.richuff.server.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.richuff.server.R;

import java.util.ArrayList;
import java.util.List;

public class LauchSimpleAdapter extends PagerAdapter {
    private List<View> mView = new ArrayList<>();
    public LauchSimpleAdapter(Context mcontext,int[] launchImage) {
        for (int i=0;i<launchImage.length;i++){
            View inflate = LayoutInflater.from(mcontext).inflate(R.layout.view_page, null);
            ImageView iv = inflate.findViewById(R.id.iv);
            RadioGroup rg = inflate.findViewById(R.id.rg);

            Button btn = inflate.findViewById(R.id.btn);

            iv.setImageResource(launchImage[i]);
            for (int j = 0; j < launchImage.length; j++) {
                RadioButton rb = new RadioButton(mcontext);
                rb.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                rb.setPadding(10,10,10,10);
                rg.addView(rb);
            }
            ((RadioButton) rg.getChildAt(i)).setChecked(true);
            if (i == launchImage.length-1){
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener( v ->{
                    Toast.makeText(mcontext,"welcome", Toast.LENGTH_SHORT).show();
                });
            }
            mView.add(inflate);
        }
    }

    @Override
    public int getCount() {
        return mView.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View item = mView.get(position);
        container.addView(item);
        return item;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mView.get(position));
    }
}
