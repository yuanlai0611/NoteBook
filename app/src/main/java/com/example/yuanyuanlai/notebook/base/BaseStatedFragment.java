/*
 * Copyrights(c) 2018 - 9 - 16
 * made by yuandalai
 *
 */

package com.example.yuanyuanlai.notebook.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

abstract class BaseStatedFragment extends Fragment {

    private Bundle savedState;
    private static final String SAVE_KEY = "SAVE_KEY";

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!restoreStateFromArguments())
            onFirstLaunched();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        saveStateToArguments();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        saveStateToArguments();
    }

    private void saveStateToArguments() {
        if (getView() != null)
            savedState = saveState();
        if (savedState != null) {
            Bundle bundle = getArguments();
            if (bundle != null)
                bundle.putBundle(SAVE_KEY, savedState);
        }

    }

    private Bundle saveState() {
        Bundle state = new Bundle();
        // For Example
        //state.putString("text", tv1.getText().toString());
        onSaveState(state);
        return state;
    }

    private boolean restoreStateFromArguments() {
        Bundle bundle = getArguments();
        if (bundle == null)
            return false;
        savedState = bundle.getBundle(SAVE_KEY);
        if (savedState == null)
            return false;
        restoreState();
        return true;
    }

    private void restoreState() {
        if (savedState != null) {
            onRestoreState(savedState);
        }
    }

    /**
     * 子类重写，用于恢复状态保存，不用空判断
     * On restore state.
     *
     * @param savedInstanceState the saved instance state
     */
    public abstract void onRestoreState(Bundle savedInstanceState);
        // For Example
        //tv1.setText(savedState.getString("text"));

    public abstract void onSaveState(Bundle outState);

    public abstract void onFirstLaunched();

}
