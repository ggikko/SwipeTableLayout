package ggikko.me.swipetabletest.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetabletest.MainActivity;
import ggikko.me.swipetabletest.R;
import ggikko.me.swipetabletest.inneradapter.LeftRecyclerViewInnerAdapter;

/**
 * Created by ggikko on 16. 4. 13..
 */
public class LeftRecyclerViewAdapter extends RecyclerView.Adapter<LeftRecyclerViewAdapter.LeftSideViewHolder> {

    private Context mContext;
    List<Integer> data = new ArrayList<>();

    public LeftRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    @Override
    public LeftSideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_left_row,parent,false);

        return new LeftSideViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LeftSideViewHolder holder, int position) {

    }

    /** 왼쪽 행 개수 */
    @Override
    public int getItemCount() {
        return 1;
    }

    /** left side viewholder */
    public class LeftSideViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.recycler_left_inner) RecyclerView recycler_left_inner;

        private LeftRecyclerViewInnerAdapter mLeftRecyclerViewInnerAdapter;
        private RecyclerView.LayoutManager mLeftInnerRecyclerViewLayoutManager;

        public LeftSideViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            mLeftRecyclerViewInnerAdapter = new LeftRecyclerViewInnerAdapter();
            mLeftInnerRecyclerViewLayoutManager = new LinearLayoutManager(mContext);
            recycler_left_inner.setLayoutManager(mLeftInnerRecyclerViewLayoutManager);
            recycler_left_inner.setAdapter(mLeftRecyclerViewInnerAdapter);

        }
    }
}
