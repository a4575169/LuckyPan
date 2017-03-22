package xc.com.luckypan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static xc.com.luckypan.CustomRuleActivity.customItem;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_eat;
    private TextView tv_ktv;
    private TextView tv_bar;

    private TextView tv_custom;
    private TextView tv_exit;
    private TextView tv_edit1, tv_into1, tv_edit2, tv_into2, tv_edit3, tv_into3;

    private TextView tv_custom1, tv_custom2, tv_custom3;
    private String[] eats = new String[]{"饭桌", "吃口辣子", "大口喝醋", "真心话大冒险", "找人干杯", "喝两杯", "吃口芥末"};
    private String[] ktvs = new String[]{"KTV", "唱英文歌", "飙高音", "情歌对唱", "找人干杯", "喝交杯酒", "唱征服"};
    private String[] bars = new String[]{"酒吧", "掺酒喝", "吹一瓶", "跳脱衣舞", "找人干杯", "喝交杯酒", "唱征服"};
    private String[] strs_custom1, strs_custom2, strs_custom3;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sp = getSharedPreferences("status", MODE_PRIVATE);
        tv_custom = (TextView) findViewById(R.id.tv_custom);
        tv_exit = (TextView) findViewById(R.id.tv_exit);

        tv_eat = (TextView) findViewById(R.id.tv_eat);
        tv_ktv = (TextView) findViewById(R.id.tv_ktv);
        tv_bar = (TextView) findViewById(R.id.tv_bar);

        tv_custom1 = (TextView) findViewById(R.id.tv_custom1);
        tv_custom2 = (TextView) findViewById(R.id.tv_custom2);
        tv_custom3 = (TextView) findViewById(R.id.tv_custom3);

        tv_edit1 = (TextView) findViewById(R.id.tv_edit1);
        tv_into1 = (TextView) findViewById(R.id.tv_into1);
        tv_edit2 = (TextView) findViewById(R.id.tv_edit2);
        tv_into2 = (TextView) findViewById(R.id.tv_into2);
        tv_edit3 = (TextView) findViewById(R.id.tv_edit3);
        tv_into3 = (TextView) findViewById(R.id.tv_into3);

        tv_eat.setOnClickListener(this);
        tv_ktv.setOnClickListener(this);
        tv_bar.setOnClickListener(this);
        tv_custom.setOnClickListener(this);
        tv_exit.setOnClickListener(this);
        tv_custom1.setOnClickListener(this);
        tv_custom2.setOnClickListener(this);
        tv_custom3.setOnClickListener(this);

        tv_edit1.setOnClickListener(this);
        tv_into1.setOnClickListener(this);
        tv_edit2.setOnClickListener(this);
        tv_into2.setOnClickListener(this);
        tv_edit3.setOnClickListener(this);
        tv_into3.setOnClickListener(this);


        strs_custom1 = new String[7];
        strs_custom2 = new String[7];
        strs_custom3 = new String[7];
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sp.getBoolean("customItemOne", false)) {
                strs_custom1[0] = sp.getString("item0_customItemOne", "");
                strs_custom1[1] = sp.getString("item1_customItemOne", "");
                strs_custom1[2] = sp.getString("item2_customItemOne", "");
                strs_custom1[3] = sp.getString("item3_customItemOne", "");
                strs_custom1[4] = sp.getString("item4_customItemOne", "");
                strs_custom1[5] = sp.getString("item5_customItemOne", "");
                strs_custom1[6] = sp.getString("item6_customItemOne", "");
                tv_custom1.setText(strs_custom1[0]);
                tv_custom1.setClickable(false);
                tv_edit1.setVisibility(View.VISIBLE);
                tv_into1.setVisibility(View.VISIBLE);
            }
        if(sp.getBoolean("customItemTwo", false)){
                strs_custom2[0] = sp.getString("item0_customItemTwo", "");
                strs_custom2[1] = sp.getString("item1_customItemTwo", "");
                strs_custom2[2] = sp.getString("item2_customItemTwo", "");
                strs_custom2[3] = sp.getString("item3_customItemTwo", "");
                strs_custom2[4] = sp.getString("item4_customItemTwo", "");
                strs_custom2[5] = sp.getString("item5_customItemTwo", "");
                strs_custom2[6] = sp.getString("item6_customItemTwo", "");
                tv_custom2.setText(strs_custom2[0]);
                tv_custom2.setClickable(false);
                tv_edit2.setVisibility(View.VISIBLE);
                tv_into2.setVisibility(View.VISIBLE);
            }
        if(sp.getBoolean("customItemThree", false)){
                strs_custom3[0] = sp.getString("item0_customItemThree", "");
                strs_custom3[1] = sp.getString("item1_customItemThree", "");
                strs_custom3[2] = sp.getString("item2_customItemThree", "");
                strs_custom3[3] = sp.getString("item3_customItemThree", "");
                strs_custom3[4] = sp.getString("item4_customItemThree", "");
                strs_custom3[5] = sp.getString("item5_customItemThree", "");
                strs_custom3[6] = sp.getString("item6_customItemThree", "");
                tv_custom3.setText(strs_custom3[0]);
                tv_custom3.setClickable(false);
                tv_edit3.setVisibility(View.VISIBLE);
                tv_into3.setVisibility(View.VISIBLE);
            }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_custom:
                break;
            case R.id.tv_exit:
                finish();
                break;
            case R.id.tv_eat:
                Intent intent_eat = new Intent();
                intent_eat.setClass(this, MainActivity.class);
                Bundle bundle_eat = new Bundle();
                bundle_eat.putSerializable("DATA", eats);
                intent_eat.putExtras(bundle_eat);
                startActivity(intent_eat);
                break;
            case R.id.tv_ktv:
                Intent intent_ktv = new Intent();
                intent_ktv.setClass(this, MainActivity.class);
                Bundle bundle_ktv = new Bundle();
                bundle_ktv.putSerializable("DATA", ktvs);
                intent_ktv.putExtras(bundle_ktv);
                startActivity(intent_ktv);
                break;
            case R.id.tv_bar:
                Intent intent_bar = new Intent();
                intent_bar.setClass(this, MainActivity.class);
                Bundle bundle_bar = new Bundle();
                bundle_bar.putSerializable("DATA", bars);
                intent_bar.putExtras(bundle_bar);
                startActivity(intent_bar);
                break;
            case R.id.tv_custom1:
                customItem = "customItemOne";
                startActivity(new Intent(this, CustomRuleActivity.class));
                break;
            case R.id.tv_custom2:
                customItem = "customItemTwo";
                startActivity(new Intent(this, CustomRuleActivity.class));
                break;
            case R.id.tv_custom3:
                customItem = "customItemThree";
                startActivity(new Intent(this, CustomRuleActivity.class));
                break;
            case R.id.tv_edit1:
                customItem = "customItemOne";
                Intent custom1_edit = new Intent();
                custom1_edit.setClass(this, CustomRuleActivity.class);
                Bundle bundle_custom1_edit = new Bundle();
                bundle_custom1_edit.putSerializable("DATA", strs_custom1);
                custom1_edit.putExtras(bundle_custom1_edit);
                startActivity(custom1_edit);
                break;
            case R.id.tv_into1:
                Intent custom1_into = new Intent();
                custom1_into.setClass(this, MainActivity.class);
                Bundle bundle_custom1_into = new Bundle();
                bundle_custom1_into.putSerializable("DATA", strs_custom1);
                custom1_into.putExtras(bundle_custom1_into);
                startActivity(custom1_into);
                break;
            case R.id.tv_edit2:
                customItem = "customItemTwo";
                Intent custom2_edit = new Intent();
                custom2_edit.setClass(this, CustomRuleActivity.class);
                Bundle bundle_custom2_edit = new Bundle();
                bundle_custom2_edit.putSerializable("DATA", strs_custom2);
                custom2_edit.putExtras(bundle_custom2_edit);
                startActivity(custom2_edit);
                break;
            case R.id.tv_into2:
                Intent custom2_into = new Intent();
                custom2_into.setClass(this, MainActivity.class);
                Bundle bundle_custom2_into = new Bundle();
                bundle_custom2_into.putSerializable("DATA", strs_custom2);
                custom2_into.putExtras(bundle_custom2_into);
                startActivity(custom2_into);
                break;
            case R.id.tv_edit3:
                customItem = "customItemThree";
                Intent custom3_edit = new Intent();
                custom3_edit.setClass(this, CustomRuleActivity.class);
                Bundle bundle_custom3_edit = new Bundle();
                bundle_custom3_edit.putSerializable("DATA", strs_custom3);
                custom3_edit.putExtras(bundle_custom3_edit);
                startActivity(custom3_edit);
                break;
            case R.id.tv_into3:
                Intent custom3_into = new Intent();
                custom3_into.setClass(this, MainActivity.class);
                Bundle bundle_custom3_into = new Bundle();
                bundle_custom3_into.putSerializable("DATA", strs_custom3);
                custom3_into.putExtras(bundle_custom3_into);
                startActivity(custom3_into);
                break;
            default:
                break;
        }
    }
}
