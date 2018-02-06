package app.com.rvapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import app.com.rvapp.R;
import app.com.rvapp.activity.base.BaseAppCompatActivity;
import app.com.rvapp.handler.derived.CellTypeAHandler;
import app.com.rvapp.holder.base.BaseViewHolder;
import app.com.rvapp.holder.derived.HolderAType;
import app.com.rvapp.holder.derived.HolderBType;
import app.com.rvapp.holder.derived.HolderCType;

/**
 * Adapter class for RecyclerView for Home screen.
 */
public class RVAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final String TAG = "RVAdapter";

    public static final int CELL_TYPE_A = 1;
    public static final int CELL_TYPE_B = 2;
    public static final int CELL_TYPE_C = 3;

    private BaseAppCompatActivity mActivity = null;

    public RVAdapter(BaseAppCompatActivity activity) {

        this.mActivity = activity;

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder(" + viewType + ")");

        BaseViewHolder holder = null;
        View view = null;

        if (viewType == CELL_TYPE_A) {

            view = mActivity.getLayoutInflater().inflate(R.layout.item_cell_a, parent, false);
            holder = new HolderAType(view);
            CellTypeAHandler aHandler = new CellTypeAHandler();
            aHandler.loadBanner(mActivity, view);


        } else if (viewType == CELL_TYPE_B) {


            view = mActivity.getLayoutInflater().inflate(R.layout.item_cell_b, parent, false);
            holder = new HolderBType(view);

        } else if (viewType == CELL_TYPE_C) {


            view = mActivity.getLayoutInflater().inflate(R.layout.item_cell_c, parent, false);
            holder = new HolderCType(view);

        }
        return holder;

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder(" + position + ")");
    }

    @Override
    public int getItemCount() {
        return 21;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0 || position == 1) {        // banner image (A).

            return CELL_TYPE_A;

        } else if (position == 10 || position == 3) {     // scrolling view (B).

            return CELL_TYPE_B;

        } else {        // other item cell (C).

            return CELL_TYPE_C;
        }

    }


}
