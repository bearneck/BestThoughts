package com.grcen.bestthoughts.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.grcen.bestthoughts.Bean.Picture;
import com.grcen.bestthoughts.R;
import com.grcen.bestthoughts.adapters.PictureAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment-mm";
    public static final String POSITION = "POSITION";
    private Context mContext;
    private int mPosition;

    public static MainFragment newInstance(int position) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        switch (mPosition) {
            // gif界面
            case 0:{
                view = inflater.inflate(R.layout.fragment_gif, container, false);
                initGifView(view);
                break;
            }
            // 视频界面
            case 1:{
                view = inflater.inflate(R.layout.fragment_video, container, false);
                initVideoView(view);
                break;
            }
            // 图片界面
            case 2: {
                view = inflater.inflate(R.layout.fragment_picture, null);
                initPictureView(view);
                break;
            }
            // 文字界面
            case 3:{
                view = inflater.inflate(R.layout.fragment_text, container, false);
                initTextView(view);
                break;
            }
            default:
                Log.i(TAG, "onCreateView: 未知错误");
        }
        return view;
    }

    // 初始化文字界面控件
    private void initTextView(View view) {

    }

    // 初始化图片界面控件
    private Picture[] pictures = {
            new Picture("琳琳","老陈好帅",233,666,999,"https://graph.baidu.com/resource/1025ad5cdbcfb098df3b401551352015.jpg","https://ss0.baidu.com/73x1bjeh1BF3odCf/it/u=950331994,3932022251&fm=85&s=7A94E6064F445747064E12740300806C"),
            new Picture("老陈","你也是是真的牛逼",123,126,559,"https://upload.jianshu.io/users/upload_avatars/6560575/d69fb270-103a-4eec-b070-d5e7aa2e9c96.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96","https://cdn2.jianshu.io/assets/web/web-note-ad-1-c2e1746859dbf03abe49248893c9bea4.png")

    };
    private List<Picture> pictureList = new ArrayList<>();
    private PictureAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;

    @SuppressLint("ResourceAsColor")
    private void initPictureView(View view) {
        initPictures();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PictureAdapter(pictureList);
        recyclerView.setAdapter(adapter);

        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeColors(R.color.colorPrimary);//改变刷新颜色
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshPictures();
            }
        });
    }

    private void refreshPictures() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //CONTEXT:getActivity().getApplicationContext()
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initPictures();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initPictures() {
        pictureList.clear();//随机调取数据
        for (int i =0;i<20;i++){
            Random random = new Random();
            int index = random.nextInt(pictures.length);
            pictureList.add(pictures[index]);
        }
    }


    // 初始化视频界面控件
    private void initVideoView(View view) {

    }

    // 初始化Gif界面控件
    private void initGifView(View view) {

    }

}
