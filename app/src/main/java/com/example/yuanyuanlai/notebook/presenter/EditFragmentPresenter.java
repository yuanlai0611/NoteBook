/*
 * Copyrights(c) 2018 - 9 - 17
 * made by yuandalai
 *
 */

package com.example.yuanyuanlai.notebook.presenter;

import com.example.yuanyuanlai.notebook.base.mvp.BasePresenter;

import java.io.File;

public class EditFragmentPresenter extends BasePresenter<EdiFragmentView> {

    private String filePath;

    private String fileName;

    private boolean isCreateFile;

    public EditFragmentPresenter(File file) {
        if (file.isDirectory()) {
            this.fileName = "";
            this.filePath = file.getAbsolutePath();
            isCreateFile = true;
        } else {
            this.fileName = file.getName();
            this.filePath = file.getParent();
        }
    }

    public File getMDFile() {
        return new File(filePath, fileName);
    }

}
