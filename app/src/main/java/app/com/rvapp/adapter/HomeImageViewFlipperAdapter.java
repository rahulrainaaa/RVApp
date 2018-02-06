package app.com.rvapp.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import app.com.rvapp.R;

/**
 * @class HomeImageViewFlipperAdapter
 * @desc Home Page Banner {@link android.widget.AdapterViewFlipper} adapter class.
 */
public class HomeImageViewFlipperAdapter extends ArrayAdapter<Integer> {

    /**
     * private data members.
     */
    private static final Integer list[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher_round};
    private Activity mActiity = null;
    private LayoutInflater mInflater = null;
    private int mResourceId;

    /**
     * @param activity
     * @param resource
     * @constructor HomeImageViewFlipperAdapter
     * @desc Constructor method to initialize the class data members.
     */
    public HomeImageViewFlipperAdapter(@NonNull Activity activity, @LayoutRes int resource) {
        super(activity, resource, list);
        this.mResourceId = resource;
        this.mActiity = activity;
        this.mInflater = activity.getLayoutInflater();
    }

    /**
     * {@link ArrayAdapter} class override method.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Holder holder = null;
        View v = convertView;
        ImageView view = null;
        if (v == null) {
            v = mInflater.inflate(mResourceId, null);
            view = (ImageView) v;
            holder = new Holder();
            holder.i = list[position];
            holder.img = view;
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
            view = holder.img;
            if (holder.i != list[position]) {
                //view.setImageResource(R.mipmap.ic_launcher);
                Picasso.with(mActiity).load(list[position]).into(view);
                holder.i = list[position];
                view.setTag(holder);
            }
        }
        try {
            Picasso.with(mActiity).load(list[position]).into(view);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return view;
    }

    /**
     * @class Holder
     * @desc Static child class to hold the view id for cell reusability.
     */
    private static class Holder {
        ImageView img = null;
        Integer i = null;

    }
}
