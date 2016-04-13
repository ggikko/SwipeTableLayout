package ggikko.me.swipetabletest.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import ggikko.me.swipetabletest.MainActivity;

/**
 * Created by ggikko on 16. 4. 13..
 */
public class RecyclerOnScrollListener extends RecyclerView.OnScrollListener {

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 11;

    private Context mContext;

    int firstVisibleItem, visibleItemCount, totalItemCount, firstCompleteItem,lastCompleteItem;

    private int currentPage = 0;

    RecyclerViewPositionHelper mRecyclerViewHelper;

    public RecyclerOnScrollListener(Context context) {
        this.mContext = context;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        mRecyclerViewHelper = RecyclerViewPositionHelper.createHelper(recyclerView);
        firstCompleteItem= mRecyclerViewHelper.findFirstCompletelyVisibleItemPosition();
        lastCompleteItem= mRecyclerViewHelper.findLastCompletelyVisibleItemPosition();


        if(firstCompleteItem == 0){
            ((MainActivity)mContext).visibleDivider("start");
        }else{
            ((MainActivity)mContext).visibleDivider("normal");
        }

//        if(lastCompleteItem == 11){
//            ((MainActivity)mContext).visibleDivider("end");
//        }
    }

}
