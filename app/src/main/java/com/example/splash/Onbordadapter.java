package com.example.splash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Onbordadapter extends PagerAdapter {
    Context mcontext;

    public Onbordadapter(Context mcontext, List<Onborditems> mlistscreeb) {
        this.mcontext = mcontext;
        this.mlistscreeb = mlistscreeb;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutscreen = inflater.inflate(R.layout.onbordresourse,null);

        ImageView imageslide = layoutscreen.findViewById(R.id.introimage);
        TextView title = layoutscreen.findViewById(R.id.introheadline);
        TextView description = layoutscreen.findViewById(R.id.introdescription);

        title.setText(mlistscreeb.get(position).getTitle());
        description.setText(mlistscreeb.get(position).getDescription());
        imageslide.setImageResource(mlistscreeb.get(position).getScreenimg());

        container.addView(layoutscreen);
        return  layoutscreen;



    }

    List<Onborditems> mlistscreeb;



    @Override
    public int getCount() {
        return mlistscreeb.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
