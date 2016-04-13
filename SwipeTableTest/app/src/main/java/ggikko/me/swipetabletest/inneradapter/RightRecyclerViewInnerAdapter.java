package ggikko.me.swipetabletest.inneradapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetabletest.R;

/**
 * Created by ggikko on 16. 4. 13..
 */
public class RightRecyclerViewInnerAdapter extends RecyclerView.Adapter<RightRecyclerViewInnerAdapter.RightSideInnerViewHolder> {




    public RightRecyclerViewInnerAdapter(int adapterPosition) {
        this.parentPostion = adapterPosition;
    }



    @Override
    public RightSideInnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_right_inner_row,parent,false);

        return new RightSideInnerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RightSideInnerViewHolder holder, int position) {
//        Log.e("ggikko", "parentposition : " + parentPostion + " position : " + position);

    }

    @Override
    public int getItemCount() {
        return pf_grade_list.size();
    }

    /** left side viewholder */
    public class RightSideInnerViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.table_value) TextView table_value;
        public RightSideInnerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
