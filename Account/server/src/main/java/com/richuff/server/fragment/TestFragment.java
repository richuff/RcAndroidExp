package com.richuff.server.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.richuff.server.R;

public class TestFragment extends Fragment {


    public static TestFragment newInstance(int count,int position, int imageId) {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("imageId", imageId);
        args.putInt("count",count);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        Context mcontext = getContext();
        View minflate = LayoutInflater.from(mcontext).inflate(R.layout.view_page, null);

        if (bundle != null){
            int position = bundle.getInt("position");
            int imageId = bundle.getInt("imageId");
            int count = bundle.getInt("count");

            ImageView iv = minflate.findViewById(R.id.iv);
            RadioGroup rg = minflate.findViewById(R.id.rg);

            Button btn = minflate.findViewById(R.id.btn);

            iv.setImageResource(imageId);
            for (int j = 0; j < count; j++) {
                RadioButton rb = new RadioButton(mcontext);
                rb.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                rb.setPadding(10,10,10,10);
                rg.addView(rb);
            }
            ((RadioButton) rg.getChildAt(position)).setChecked(true);
            if (position == count-1){
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener( v ->{
                    Toast.makeText(mcontext,"welcome", Toast.LENGTH_SHORT).show();
                });
            }
        }
        return minflate;
    }
}