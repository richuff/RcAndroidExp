package com.richuff.server.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richuff.server.R;

public class DynamicFragment extends Fragment {

    public static DynamicFragment newInstance(Bundle savedInstanceState) {
        DynamicFragment fragment = new DynamicFragment();

        Bundle args = new Bundle();
        args.putString("test","my message");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        Bundle arguments = getArguments();
        if (arguments!= null){
            TextView v1 = view.findViewById(R.id.imm);
            TextView v2 = view.findViewById(R.id.ims);
            v1.setText(arguments.getShort("test"));
            v2.setText(arguments.getString("test"));
        }
        return view;
    }
}