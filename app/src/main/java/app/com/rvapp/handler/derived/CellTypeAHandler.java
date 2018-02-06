package app.com.rvapp.handler.derived;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterViewFlipper;

import app.com.rvapp.R;
import app.com.rvapp.activity.base.BaseAppCompatActivity;
import app.com.rvapp.adapter.HomeImageViewFlipperAdapter;
import app.com.rvapp.handler.base.BaseHandler;


public class CellTypeAHandler extends BaseHandler implements View.OnTouchListener {

    private BaseAppCompatActivity mActivity = null;
    private AdapterViewFlipper mFlipperBanner = null;
    private HomeImageViewFlipperAdapter mFlipperAdapter = null;

    public void loadBanner(BaseAppCompatActivity activity, View view) {

        this.mActivity = activity;
        mFlipperBanner = (AdapterViewFlipper) view.findViewById(R.id.banner);
        mFlipperAdapter = new HomeImageViewFlipperAdapter(mActivity, R.layout.layout_banner_image);
        mFlipperBanner.setAdapter(mFlipperAdapter);
        mFlipperBanner.setFlipInterval(3000);
        mFlipperBanner.startFlipping();
        mFlipperBanner.setAutoStart(true);
        mFlipperBanner.setOnTouchListener(this);
        mFlipperBanner.setInAnimation(mActivity, android.R.animator.fade_in);
        mFlipperBanner.setOutAnimation(mActivity, android.R.animator.fade_out);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:       // Action to show next banner display image.
                mFlipperBanner.showNext();
                break;
        }

        return false;
    }

}
