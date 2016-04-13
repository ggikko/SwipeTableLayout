package ggikko.me.swipetabletest.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetabletest.R;
import ggikko.me.swipetabletest.helper.ItemTouchHelperAdapter;
import ggikko.me.swipetabletest.inneradapter.LeftRecyclerViewInnerAdapter;
import ggikko.me.swipetabletest.inneradapter.RightRecyclerViewInnerAdapter;

/**
 * Created by ggikko on 16. 4. 13..
 */
public class RightRecyclerViewAdapter extends RecyclerView.Adapter<RightRecyclerViewAdapter.RightSideViewHolder> implements ItemTouchHelperAdapter {

     List<String> pf_grade_list = new ArrayList<>();
     List<String> interest_rate_list = new ArrayList<>();
     List<String> loan_application_termlist_list = new ArrayList<>();
     List<String> bad_rate_list = new ArrayList<>();
     List<String> grade_cb_kcb_list = new ArrayList<>();
     List<String> grade_cb_nice_list = new ArrayList<>();
     List<String> dti_list = new ArrayList<>();
     List<String> loan_application_amount_list = new ArrayList<>();
     List<String> remain_loan_application_amount_list = new ArrayList<>();
     List<String> fund_start_time_list = new ArrayList<>();

    int renderingPosition = 0;

    private Context mContext;

    public RightRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> pf_grade_list, List<String> interest_rate_list,
                        List<String> loan_application_termlist_list, List<String> bad_rate_list,
                        List<String> grade_cb_kcb_list, List<String> grade_cb_nice_list,
                        List<String> dti_list, List<String> loan_application_amount_list,
                        List<String> remain_loan_application_amount_list, List<String> fund_start_time_list) {

        this.pf_grade_list = pf_grade_list;
        this.interest_rate_list = interest_rate_list;
        this.loan_application_amount_list = loan_application_amount_list;
        this.loan_application_termlist_list = loan_application_termlist_list;
        this.bad_rate_list = bad_rate_list;
        this.grade_cb_kcb_list = grade_cb_kcb_list;
        this.grade_cb_nice_list = grade_cb_nice_list;
        this.dti_list = dti_list;
        this.remain_loan_application_amount_list = remain_loan_application_amount_list;
        this.fund_start_time_list = fund_start_time_list;

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

    /** helper overriding */
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Log.e("ggikko","fromposition : "+ fromPosition +" toposition :" + toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        notifyItemRemoved(position);
    }

    /** right side viewholder */
    public class RightSideViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.recycler_right_inner) RecyclerView recycler_right_inner;

        private RightRecyclerViewInnerAdapter mRightRecyclerViewInnerAdapter;
        private RecyclerView.LayoutManager mRightInnerRecyclerViewLayoutManager;

        public RightSideViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            mRightRecyclerViewInnerAdapter = new RightRecyclerViewInnerAdapter(renderingPosition);

            /** rendering position */
            renderingPosition++;

            mRightRecyclerViewInnerAdapter.setData(pf_grade_list, interest_rate_list,loan_application_termlist_list,
                    bad_rate_list,grade_cb_kcb_list, grade_cb_nice_list, dti_list,
                    loan_application_amount_list, remain_loan_application_amount_list,fund_start_time_list );


            mRightInnerRecyclerViewLayoutManager = new LinearLayoutManager(mContext);
            recycler_right_inner.setLayoutManager(mRightInnerRecyclerViewLayoutManager);
            recycler_right_inner.setAdapter(mRightRecyclerViewInnerAdapter);


        }
    }
}
