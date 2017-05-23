package com.example.hp.s_100;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> title_list = new ArrayList<>();
    private ArrayList<String> price_list = new ArrayList<>();
    private ArrayList<String> image_list = new ArrayList<>();
    private ArrayList<String> detail_inform_list = new ArrayList<>();
    private Listener listener;
    private RelativeLayout rel_layout;
    private TextView detail_inform;

    public static interface Listener {
        public void onClick(String name);
    }


    public MyRecyclerViewAdapter(ArrayList<String> title_list, ArrayList<String> price_list, ArrayList<String> image_list, ArrayList<String> detail_inform_list) {
        this.title_list = title_list;
        this.price_list = price_list;
        this.image_list = image_list;
        this.detail_inform_list = detail_inform_list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;

        }
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final CardView cardView = holder.cardView;
        ImageView imageview = (ImageView) cardView.findViewById(R.id.img_cardview);
        Picasso.with(cardView.getContext()).load(String.valueOf(image_list.get(position))).into(imageview);

        TextView title = (TextView) cardView.findViewById(R.id.title_cardview);
        title.setText(title_list.get(position));
        TextView price = (TextView) cardView.findViewById(R.id.price);
        price.setText(price_list.get(position));
        detail_inform = (TextView) cardView.findViewById(R.id.detail_inform);
        detail_inform.setText(detail_inform_list.get(position));

        rel_layout = (RelativeLayout) cardView.findViewById(R.id.rel_layout);
        final ExpandableLinearLayout expandable = (ExpandableLinearLayout) cardView.findViewById(R.id.expandable);
        final ImageView img_more = (ImageView) cardView.findViewById(R.id.img_btn_more);

        rel_layout.setOnClickListener(new View.OnClickListener() {
            // false - panel gone
            boolean b = false;

            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(cardView.getContext(),
                        R.anim.rotate);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (b == false) {
                            img_more.setImageResource(R.drawable.ic_expand_less_black_24dp);
                            b = true;
                        } else {
                            img_more.setImageResource(R.drawable.ic_expand_more_black_24dp);
                            b = false;
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                img_more.startAnimation(animation);
                expandable.toggle();

            }
        });


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(title_list.get(position).toString());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return title_list.size();
    }

}
