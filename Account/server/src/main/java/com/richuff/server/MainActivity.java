package com.richuff.server;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.richuff.server.adapter.LauchImproveAdapter;
import com.richuff.server.adapter.LauchSimpleAdapter;

public class MainActivity extends AppCompatActivity {

    private int[] launchImage = {R.drawable.iv_f,R.drawable.iv_h,R.drawable.iv_o,R.drawable.iv_t};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewPager vp =  findViewById(R.id.vp);
        //LauchSimpleAdapter adapter = new LauchSimpleAdapter(this,launchImage);
        LauchImproveAdapter adapter = new LauchImproveAdapter(getSupportFragmentManager(),launchImage);
        vp.setAdapter(adapter);
    }
}