package xc.com.luckypan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomRuleActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_cancel;
    private TextView tv_sure;
    private EditText et_name, et_item1, et_item2, et_item3, et_item4, et_item5, et_item6;
    private String str_name, str_item1, str_item2, str_item3, str_item4, str_item5, str_item6;
    private String[] mStrs;
    private ImageView iv_back;
    private SharedPreferences sp;
    public static String customItem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_rule);
        sp = getSharedPreferences("status", MODE_PRIVATE);
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        tv_sure = (TextView) findViewById(R.id.tv_sure);
        et_name = (EditText) findViewById(R.id.et_name);
        et_item1 = (EditText) findViewById(R.id.et_item1);
        et_item2 = (EditText) findViewById(R.id.et_item2);
        et_item3 = (EditText) findViewById(R.id.et_item3);
        et_item4 = (EditText) findViewById(R.id.et_item4);
        et_item5 = (EditText) findViewById(R.id.et_item5);
        et_item6 = (EditText) findViewById(R.id.et_item6);
        iv_back = (ImageView) findViewById(R.id.iv_back);

        tv_cancel.setOnClickListener(this);
        tv_sure.setOnClickListener(this);
        iv_back.setOnClickListener(this);

        if (sp.getBoolean(CustomRuleActivity.customItem, false)) {
            et_name.setText(sp.getString("item0_" + customItem, ""));
            et_item1.setText(sp.getString("item1_" + customItem, ""));
            et_item2.setText(sp.getString("item2_" + customItem, ""));
            et_item3.setText(sp.getString("item3_" + customItem, ""));
            et_item4.setText(sp.getString("item4_" + customItem, ""));
            et_item5.setText(sp.getString("item5_" + customItem, ""));
            et_item6.setText(sp.getString("item6_" + customItem, ""));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.tv_sure:
                str_name = et_name.getText().toString().trim();
                str_item1 = et_item1.getText().toString().trim();
                str_item2 = et_item2.getText().toString().trim();
                str_item3 = et_item3.getText().toString().trim();
                str_item4 = et_item4.getText().toString().trim();
                str_item5 = et_item5.getText().toString().trim();
                str_item6 = et_item6.getText().toString().trim();

                mStrs = new String[]{str_name, str_item1, str_item2, str_item3, str_item4, str_item5, str_item6};

                if (str_name.isEmpty() || str_item1.isEmpty() ||
                        str_item2.isEmpty() || str_item3.isEmpty() ||
                        str_item4.isEmpty() || str_item5.isEmpty() ||
                        str_item6.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "请完善盘快内容", Toast.LENGTH_SHORT).show();
                } else if (str_name.length() > 6) {
                    Toast.makeText(getApplicationContext(), "自定义名称不能超过6个字符", Toast.LENGTH_SHORT).show();
                } else if (str_item1.length() > 8 || str_item2.length() > 8 || str_item3.length() > 8 || str_item4.length() > 8
                        || str_item5.length() > 8 || str_item6.length() > 8) {
                    Toast.makeText(getApplicationContext(), "自定义内容不能超过8个字符", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean(customItem, true).commit();
                    edit.putString("item0_" + customItem, mStrs[0]).commit();
                    edit.putString("item1_" + customItem, mStrs[1]).commit();
                    edit.putString("item2_" + customItem, mStrs[2]).commit();
                    edit.putString("item3_" + customItem, mStrs[3]).commit();
                    edit.putString("item4_" + customItem, mStrs[4]).commit();
                    edit.putString("item5_" + customItem, mStrs[5]).commit();
                    edit.putString("item6_" + customItem, mStrs[6]).commit();
                    Log.e("xc", "customItem=" + customItem);
                    Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            case R.id.iv_back:
                finish();
                break;
            default:
                break;
        }
    }
}
