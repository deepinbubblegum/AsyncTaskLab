package com.deepin.asynctasklab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar,mProgressBar2;
    TextView mTextView,mTextView2;
    EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar2 = findViewById(R.id.progressBar2);
        mTextView = findViewById(R.id.display);
        mTextView2 = findViewById(R.id.display2);
        mEditText = findViewById(R.id.edit);
    }

    public void startTask(View view) {
        int limit = Integer.parseInt(mEditText.getText().toString());
        new SimpleTask(mProgressBar,mProgressBar2,mTextView,mTextView2).execute(limit);
    }
}
