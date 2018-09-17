package com.example.yuanyuanlai.notebook;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.yuanyuanlai.notebook.base.BaseFragment;

public class EditFragment extends BaseFragment {

    public static final String FILE_PATH_KEY = "FILE_PATH_KEY";
    private EditText mTitleEditText;
    private EditText mContentEditText;

    public static EditFragment getInstance(String filePath) {
        EditFragment editFragment = new EditFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FILE_PATH_KEY, filePath);
        editFragment.setArguments(bundle);
        return editFragment;
    }

    @Override
    public void onRestoreState(Bundle savedInstanceState) {

    }

    @Override
    public void onSaveState(Bundle outState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_edit;
    }

    @Override
    public void onCreateAfter(Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void findViewById(View view) {

        mTitleEditText = (EditText)view.findViewById(R.id.title);
        mContentEditText = (EditText)view.findViewById(R.id.content);

    }
}
