/*
 * Copyrights(c) 2018 - 9 - 17
 * made by yuandalai
 *
 */

package com.example.yuanyuanlai.notebook.model;

public class DataManager {

    private static DataManager mDataManager;

    public static synchronized DataManager getInstance() {
        mDataManager = new DataManager();
        return mDataManager;
    }

    

}
