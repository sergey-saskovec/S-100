package com.example.hp.s_100.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.hp.s_100.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReferenceFragment extends Fragment {


    public ReferenceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout relativelayout = (RelativeLayout) inflater.inflate(R.layout.fragment_reference, container, false);
        return relativelayout;
    }

}
