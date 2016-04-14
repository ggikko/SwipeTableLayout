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

    private int parentPostion = 10;

    private final int PF_GRADE = 0;
    private final int INTEREST_RATE = 1;
    private final int LOAN_APPLICATION_TERMLIST = 2;
    private final int BAD_RATE = 3;
    private final int GRADE_CB_KCB = 4;
    private final int GRADE_CB_NICE = 5;
    private final int DTI = 6;
    private final int LOAN_APPLICATION_AMOUNT = 7;
    private final int REMAIN_LOAN_APPLICATION_AMOUNT = 8;
    private final int FUND_START_TIME = 9;


    public RightRecyclerViewInnerAdapter(int adapterPosition) {
        this.parentPostion = adapterPosition;
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
    public int getItemViewType(int position) {
//        Log.e("ggikko", "inner position : " + position);


        return super.getItemViewType(position);
    }

    @Override
    public RightSideInnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_right_inner_row,parent,false);

        return new RightSideInnerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RightSideInnerViewHolder holder, int position) {
        Log.e("ggikko", "parentposition : " + parentPostion + " position : " + position);
        switch (parentPostion){
            case PF_GRADE :{
                holder.table_value.setText(pf_grade_list.get(position));
                break;
            }case INTEREST_RATE :{
                holder.table_value.setText(interest_rate_list.get(position));
                break;
            }case LOAN_APPLICATION_TERMLIST :{
                holder.table_value.setText(loan_application_termlist_list.get(position));
                break;
            }case BAD_RATE :{
                holder.table_value.setText(bad_rate_list.get(position));
                break;
            }case GRADE_CB_KCB :{
                holder.table_value.setText(grade_cb_kcb_list.get(position));
                break;
            }case GRADE_CB_NICE :{
                holder.table_value.setText(grade_cb_nice_list.get(position));
                break;
            }case DTI :{
                holder.table_value.setText(dti_list.get(position));
                break;
            }case LOAN_APPLICATION_AMOUNT :{
                holder.table_value.setText(loan_application_amount_list.get(position));
                break;
            }case REMAIN_LOAN_APPLICATION_AMOUNT :{
                holder.table_value.setText(remain_loan_application_amount_list.get(position));
                break;
            }case FUND_START_TIME:{
                holder.table_value.setText(fund_start_time_list.get(position));
                break;
            }case 10:{
                holder.table_value.setText("haha");
            }
        }

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
