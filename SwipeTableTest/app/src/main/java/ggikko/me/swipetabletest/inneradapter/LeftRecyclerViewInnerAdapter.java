package ggikko.me.swipetabletest.inneradapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetabletest.R;

/**
 * Created by ggikko on 16. 4. 13..
 */
public class LeftRecyclerViewInnerAdapter extends RecyclerView.Adapter<LeftRecyclerViewInnerAdapter.LeftSideInnerViewHolder> {


    @Override
    public LeftSideInnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_left_inner_row,parent,false);

        return new LeftSideInnerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LeftSideInnerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 40;
    }

    /** left side viewholder */
    public class LeftSideInnerViewHolder extends RecyclerView.ViewHolder {

        public LeftSideInnerViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }
}
