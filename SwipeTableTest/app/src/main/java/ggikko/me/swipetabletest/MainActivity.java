package ggikko.me.swipetabletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetabletest.adapter.LeftRecyclerViewAdapter;
import ggikko.me.swipetabletest.adapter.RightRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recycler_left) RecyclerView mRecycler_left;
    @Bind(R.id.recycler_right) RecyclerView mRecycler_right;

    private LeftRecyclerViewAdapter mLeftRecyclerViewAdapter;
    private RightRecyclerViewAdapter mRightRecyclerViewAdapter;

    private RecyclerView.LayoutManager mLeftRecyclerViewLayoutManager;
    private RecyclerView.LayoutManager mRightRecyclerViewLayoutManager;

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
        mRecycler_right.setAdapter(mRightRecyclerViewAdapter);



    }


}
