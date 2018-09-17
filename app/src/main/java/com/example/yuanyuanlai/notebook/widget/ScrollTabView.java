package com.example.yuanyuanlai.notebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.yuanyuanlai.notebook.R;

public class ScrollTabView extends HorizontalScrollView {

    private Context mContext;
    private LinearLayout mLinearLayout;
    private LayoutInflater mLayoutInflater;
    private ScrollTabView scrollTabView;

    public ScrollTabView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ScrollTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public ScrollTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        scrollTabView = this;
        this.setOverScrollMode(OVER_SCROLL_NEVER);
        this.setHorizontalScrollBarEnabled(false);

        mLayoutInflater = LayoutInflater.from(mContext);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLinearLayout = new LinearLayout(mContext);
        mLinearLayout.setPadding(1, 0, 1, 0);
        mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        addView(mLinearLayout, params);
    }

    public void addTabView(int coinId, int id, OnClickListener onClickListener) {
        ImageButton imageButton = (ImageButton) mLayoutInflater.inflate(R.layout.item_tab_icon, mLinearLayout, false);
        imageButton.setImageResource(coinId);
        imageButton.setId(id);
        imageButton.setOnClickListener(onClickListener);
        mLinearLayout.addView(imageButton, mLinearLayout.getChildCount());
        this.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollTabView.smoothScrollBy(1000, 0);
            }
        }, 5);
    }
}
