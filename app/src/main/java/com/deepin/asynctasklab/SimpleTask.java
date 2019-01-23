package com.deepin.asynctasklab;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

public class SimpleTask extends AsyncTask <Void, Integer, Void> {
    private WeakReference<ProgressBar> mProgressBar;

    SimpleTask(ProgressBar pb){
        mProgressBar = new WeakReference<>(pb);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i < 100 ; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mProgressBar.get().setProgress(values[0]);
    }
}
