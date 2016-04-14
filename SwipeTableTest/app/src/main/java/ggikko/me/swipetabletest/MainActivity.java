package ggikko.me.swipetabletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetabletest.adapter.LeftRecyclerViewAdapter;
import ggikko.me.swipetabletest.adapter.RightRecyclerViewAdapter;
import ggikko.me.swipetabletest.helper.ItemTouchHelperCallback;
import ggikko.me.swipetabletest.helper.OnStartDragListener;
import ggikko.me.swipetabletest.helper.RecyclerOnScrollListener;

public class MainActivity extends AppCompatActivity implements OnStartDragListener {

    @Bind(R.id.recycler_left) RecyclerView mRecycler_left;
    @Bind(R.id.recycler_right) RecyclerView mRecycler_right;
    @Bind(R.id.table_divider) View table_divider;

    private LeftRecyclerViewAdapter mLeftRecyclerViewAdapter;
    private RightRecyclerViewAdapter mRightRecyclerViewAdapter;

    private RecyclerView.LayoutManager mLeftRecyclerViewLayoutManager;
    private RecyclerView.LayoutManager mRightRecyclerViewLayoutManager;

    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLeftRecyclerViewAdapter = new LeftRecyclerViewAdapter(this);
        mLeftRecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecycler_left.setLayoutManager(mLeftRecyclerViewLayoutManager);
        mRecycler_left.setAdapter(mLeftRecyclerViewAdapter);

        mRightRecyclerViewAdapter = new RightRecyclerViewAdapter(this);
        mRightRecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecycler_right.setLayoutManager(mRightRecyclerViewLayoutManager);
        mRecycler_right.setHasFixedSize(true);
        mRecycler_right.setAdapter(mRightRecyclerViewAdapter);

        /** set fixed size for drag and drop */
        mRecycler_right.addOnScrollListener(new RecyclerOnScrollListener(this));

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(mRightRecyclerViewAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecycler_right);

        getTestData();

        /** item size Cached for stopping recyclerview render again */
        if(loan_id_list != null) mRecycler_right.setItemViewCacheSize(loan_id_list.size());

        mLeftRecyclerViewAdapter.setData(loan_id_list);
        mRightRecyclerViewAdapter.setData(pf_grade_list, interest_rate_list,loan_application_termlist_list,
                bad_rate_list,grade_cb_kcb_list, grade_cb_nice_list, dti_list,
                loan_application_amount_list, remain_loan_application_amount_list,fund_start_time_list );


    }

    public void visibleDivider(String point){
        if(point.equals("start")) table_divider.setVisibility(View.GONE);
        if(point.equals("normal")) table_divider.setVisibility(View.VISIBLE);

    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
