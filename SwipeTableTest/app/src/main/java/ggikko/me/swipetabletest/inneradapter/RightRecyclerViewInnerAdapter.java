package ggikko.me.swipetabletest.inneradapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ggikko.me.swipetabletest.R;

/**
 * Created by ggikko on 16. 4. 13..
 */
public class RightRecyclerViewInnerAdapter extends RecyclerView.Adapter<RightRecyclerViewInnerAdapter.RightSideInnerViewHolder> {


    @Override
    public RightSideInnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_right_inner_row,parent,false);

        return new RightSideInnerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RightSideInnerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 40;
    }

    /** left side viewholder */
    public class RightSideInnerViewHolder extends RecyclerView.ViewHolder {

        public RightSideInnerViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }
}
