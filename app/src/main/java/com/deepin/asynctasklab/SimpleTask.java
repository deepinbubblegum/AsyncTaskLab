package com.deepin.asynctasklab;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class SimpleTask extends AsyncTask <Void, Integer, Void> {
    private WeakReference<ProgressBar> mProgressBar;
    private WeakReference<TextView> mTextView;
    SimpleTask(ProgressBar pb, TextView tv){
        mProgressBar = new WeakReference<>(pb);
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i <= 100 ; i++){
            try {
                Thread.sleep(50);
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
        mTextView.get().setText(values[0]+" %");
    }
}
