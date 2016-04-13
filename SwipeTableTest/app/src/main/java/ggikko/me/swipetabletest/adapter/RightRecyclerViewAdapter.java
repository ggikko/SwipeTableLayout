package ggikko.me.swipetabletest.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetabletest.R;
import ggikko.me.swipetabletest.inneradapter.LeftRecyclerViewInnerAdapter;
import ggikko.me.swipetabletest.inneradapter.RightRecyclerViewInnerAdapter;

/**
 * Created by ggikko on 16. 4. 13..
 */
public class RightRecyclerViewAdapter extends RecyclerView.Adapter<RightRecyclerViewAdapter.RightSideViewHolder>  {


    private Context mContext;

    public RightRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public RightSideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_right_row,parent,false);
        return new RightSideViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RightSideViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 11;
    }

    /** right side viewholder */
    public class RightSideViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.recycler_right_inner) RecyclerView recycler_right_inner;


        private RightRecyclerViewInnerAdapter mRightRecyclerViewInnerAdapter;
        private RecyclerView.LayoutManager mRightInnerRecyclerViewLayoutManager;


        public RightSideViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            mRightRecyclerViewInnerAdapter = new RightRecyclerViewInnerAdapter();
            mRightInnerRecyclerViewLayoutManager = new LinearLayoutManager(mContext);
            recycler_right_inner.setLayoutManager(mRightInnerRecyclerViewLayoutManager);
            recycler_right_inner.setAdapter(mRightRecyclerViewInnerAdapter);

        }
    }
}
