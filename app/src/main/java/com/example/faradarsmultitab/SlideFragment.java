package com.example.faradarsmultitab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SlideFragment extends Fragment {

    private int bgColor=0;
    private int imgResId=0;
    private String title="";
    private String description="";

    public static SlideFragment newSlide(int bgColor, int imgResId, String title, String description){
        SlideFragment fragment=new SlideFragment();
        Bundle args= new Bundle();
        args.putInt("bgcolor",bgColor);
        args.putInt("imgResId",imgResId);
        args.putString("title",title);
        args.putString("descriptions",description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args=getArguments();
        if(args==null) return;
        bgColor=args.getInt("bgcolor");
        imgResId=args.getInt("imgResId");
        title=args.getString("title");
        description=args.getString("descriptions");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.slide,container,false);
        ((ImageView)view.findViewById(R.id.img_view)).setImageResource(imgResId);
        ((TextView)view.findViewById(R.id.tv_title)).setText(title);
        ((TextView)view.findViewById(R.id.tv_description)).setText(description);
        view.findViewById(R.id.parent_layout).setBackgroundColor(bgColor);
        return view;
    }
}
