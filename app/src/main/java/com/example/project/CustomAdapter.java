package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class CustomAdapter extends PagerAdapter {
    private int [] image_resource = {R.drawable.k,R.drawable.k,R.drawable.k};
    private Context context;
    private LayoutInflater layoutInflater;
    public CustomAdapter (Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==(LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = view.findViewById(R.id.image);
        TextView textView= view.findViewById(R.id.text);
        imageView.setImageResource(image_resource[position]);
        textView.setText("image : " + (position+1) );
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
