/*
 * Copyrights(c) 2018 - 9 - 17
 * made by yuandalai
 *
 */

package com.example.yuanyuanlai.notebook.base.mvp;

public interface IMvpView {

    void otherSuccess(int flag);

    void onFailure(int errorCode, String message, int flag);

    void showWait(String message, boolean isBack, int flag);

    void hideWait(int flag);

}
