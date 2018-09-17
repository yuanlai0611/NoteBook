package com.example.yuanyuanlai.notebook.engine;

import android.widget.EditText;

import com.example.yuanyuanlai.notebook.utils.CheckUtils;

public class EditTextPerform {

    private EditText mEditText;

    public EditTextPerform(EditText editText) {
        CheckUtils.checkNull(editText, "EditText不能为空");
        mEditText = editText;
    }

}
