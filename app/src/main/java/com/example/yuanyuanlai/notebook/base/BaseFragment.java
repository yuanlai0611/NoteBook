/*
 * Copyrights(c) 2018 - 9 - 16
 * made by yuandalai
 *
 */

package com.example.yuanyuanlai.notebook.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends BaseStatedFragment implements BaseFragmentInterface {

    public static final String FILE_PATH_KEY = "FILE_PATH_KEY";
    private boolean isFirstFocused = true;
    private Context mContext;
    private View rootView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        if (rootView == null) {
            rootView = View.inflate(mContext, getLayoutId(), null);
            findViewById(rootView);
        }
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstFocused) {
            isFirstFocused = false;
            initData();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mContext = null;
        rootView = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onFirstLaunched() {
        setHasOptionsMenu(hasMenu());
        onCreateAfter(null);
    }

    public boolean hasMenu() {
        return false;
    }

    public boolean onBackPressed() {
        return false;
    }

    public abstract void findViewById(View view);

}
