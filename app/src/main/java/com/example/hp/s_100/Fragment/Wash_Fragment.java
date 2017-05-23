package com.example.hp.s_100.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.s_100.DetailActivity;
import com.example.hp.s_100.MyRecyclerViewAdapter;
import com.example.hp.s_100.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Wash_Fragment extends Fragment {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();

    ArrayList<String> title_list = new ArrayList<>();
    ArrayList<String> price_list = new ArrayList<>();
    ArrayList<String> image_list = new ArrayList<>();
    ArrayList<String> detail_inform_list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_wash_, container, false);


        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<String>> t = new GenericTypeIndicator<ArrayList<String>>() {
                };
                title_list = dataSnapshot.child("wash").child("title").getValue(t);
                image_list = dataSnapshot.child("wash").child("image").getValue(t);
                price_list = dataSnapshot.child("wash").child("price").getValue(t);
                detail_inform_list = dataSnapshot.child("wash").child("detail_inform").getValue(t);
                meth();

            }

            private void meth() {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(title_list, price_list, image_list, detail_inform_list);
                recyclerView.setAdapter(adapter);

                adapter.setListener(new MyRecyclerViewAdapter.Listener() {
                    @Override
                    public void onClick(String name) {
                        Intent intent = new Intent(getActivity(), DetailActivity.class);
                        intent.putExtra(DetailActivity.EXTRA_WASHNO, name);
                        getActivity().startActivity(intent);
                    }
                });
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        return recyclerView;
    }

}





