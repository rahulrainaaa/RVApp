package app.com.rvapp.activity.derived;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import app.com.rvapp.R;
import app.com.rvapp.activity.base.BaseAppCompatActivity;
import app.com.rvapp.adapter.RVAdapter;

public class MainActivity extends BaseAppCompatActivity {

    public static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView = null;
    private RVAdapter mAdapter = null;
    private LinearLayoutManager mLayoutManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mAdapter = new RVAdapter(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

//        mRecyclerView.getRecycledViewPool();

    }
}
