/*
 * Copyrights(c) 2018 - 9 - 17
 * made by yuandalai
 *
 */

package com.example.yuanyuanlai.notebook.presenter;

import com.example.yuanyuanlai.notebook.base.mvp.IMvpView;

public interface EdiFragmentView extends IMvpView{

   public static final int CALL_LOAOD_FILE = 1;
   public static final int CALL_NO_SAVE = 2;
   public static final int CALL_SAVE = 3;
   public static final int CALL_EXIT = 4;

   void onReadSuccess(String name, String content);

}
