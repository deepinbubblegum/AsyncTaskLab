package com.deepin.asynctasklab;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class SimpleTask extends AsyncTask <Integer, Integer, Void> {
    private WeakReference<ProgressBar> mProgressBar,mProgressBar2;
    private WeakReference<TextView> mTextView,mTextView2;
    SimpleTask(ProgressBar pb,ProgressBar pb2, TextView tv,TextView tv2){
        mProgressBar = new WeakReference<>(pb);
        mProgressBar2 = new WeakReference<>(pb2);
        mTextView = new WeakReference<>(tv);
        mTextView2 = new WeakReference<>(tv2);

    }

    @Override
    protected Void doInBackground(Integer... Integers) {
        for (int i = 0; i <= Integers[0]; i++){
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
        mProgressBar2.get().setProgress(100 - values[0]);
        mTextView.get().setText(values[0]+" %");
        mTextView2.get().setText(100 - values[0]+" %");
    }
}
