package org.francis.progressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import org.francis.progressbar.view.HorizontalProgressBar;
import org.francis.progressbar.view.RoundProgressBar;

public class MainActivity extends AppCompatActivity {


    private HorizontalProgressBar progressBar;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int progress = progressBar.getProgress();
            progressBar.setProgress(++progress);
            mProgressBar.setProgress(progress);
            if(progress >=100){
                mHandler.removeMessages(0);
            }
            mHandler.sendEmptyMessageDelayed(0,100);
        }
    };
    private RoundProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (HorizontalProgressBar) findViewById(R.id.id_progressbar);
        mProgressBar = (RoundProgressBar) findViewById(R.id.id_progressbar1);
        mHandler.sendEmptyMessage(0);
    }
}
