/*
 * Copyrights(c) 2018 - 9 - 17
 * made by yuandalai
 *
 */

package com.example.yuanyuanlai.notebook.base.mvp;

public class BasePresenter<T extends IMvpView> implements IPresenter<T>{

    private T mMvpView;



    @Override
    public void attachView(T mvpView) {

    }

    @Override
    public void detachView() {

    }
}
