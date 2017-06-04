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


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();

    ArrayList<String> title_list_promotions = new ArrayList<>();
    ArrayList<String> price_list_promotions = new ArrayList<>();
    ArrayList<String> image_list_promotions = new ArrayList<>();
    ArrayList<String> detail_inform_list_promotions = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_blank, container, false);


        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<String>> t = new GenericTypeIndicator<ArrayList<String>>() {
                };
                title_list_promotions = dataSnapshot.child("promotions").child("title").getValue(t);
                image_list_promotions = dataSnapshot.child("promotions").child("image").getValue(t);
                price_list_promotions = dataSnapshot.child("promotions").child("price").getValue(t);
                detail_inform_list_promotions = dataSnapshot.child("promotions").child("detail_inform").getValue(t);
                meth();

            }

            private void meth() {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(title_list_promotions, price_list_promotions,
                        image_list_promotions, detail_inform_list_promotions);
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
