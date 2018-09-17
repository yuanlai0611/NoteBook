/*
 * Copyrights(c) 2018 - 9 - 17
 * made by yuandalai
 *
 */

package com.example.yuanyuanlai.notebook.base.mvp;

public interface IPresenter<V extends IMvpView> {

    void attachView(V mvpView);

    void detachView();

}