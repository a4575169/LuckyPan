package xc.com.luckypan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LuckyPanView mLuckyPanView;
    private ImageView mStartBtn;
    private ImageView iv_back;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        mLuckyPanView = (LuckyPanView) findViewById(R.id.id_luckypan);
        mStartBtn = (ImageView) findViewById(R.id.id_start_btn);
        tv_title=(TextView)findViewById(R.id.tv_title);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String[] datas = extras.getStringArray("DATA");
            mLuckyPanView.mStrs = datas;
            tv_title.setText("幸运转盘-"+datas[0]);
        } else {
            Log.e("xc", "datas=null");
        }

        iv_back.setOnClickListener(this);
        mStartBtn.setOnClickListener(this);

//        mStartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!mLuckyPanView.isStart()) {
//                    mStartBtn.setImageResource(R.drawable.stop);
////                    mLuckyPanView.luckyStart(1);
//                    mLuckyPanView.luckyStart();
//                } else {
//                    if (!mLuckyPanView.isShouldEnd())
//
//                    {
//                        mStartBtn.setImageResource(R.drawable.start);
//                        mLuckyPanView.luckyEnd();
//                    }
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.id_start_btn:
                if (!mLuckyPanView.isStart()) {
                    mStartBtn.setImageResource(R.drawable.stop);
//                    mLuckyPanView.luckyStart(1);
                    mLuckyPanView.luckyStart();
                } else {
                    if (!mLuckyPanView.isShouldEnd())

                    {
                        mStartBtn.setImageResource(R.drawable.start);
                        mLuckyPanView.luckyEnd();
                    }
                }
                break;
            default:
                break;
        }
    }
}
