package com.example.hp.s_100.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.example.hp.s_100.R;


public class AboutFragment extends Fragment {


    public AboutFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout relativelayout = (RelativeLayout) inflater.inflate(R.layout.fragment_about, container, false);
        return relativelayout;
    }


}
