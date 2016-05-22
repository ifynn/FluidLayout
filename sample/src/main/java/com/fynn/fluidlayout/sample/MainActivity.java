package com.fynn.fluidlayout.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.fynn.fluidlayout.FluidLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FluidLayout fluidLayout;
    private Button btnCenter;
    private Button btnBtm;
    private Button btnTop;
    private Button btnNormal;
    private ToggleButton btnStroke;

    private String[] tags = new String[]{
            "倩女幽魂", "单机斗地主", "天堂战记", "妖精的尾巴", "极限挑战", "我们相爱吧", "倚天屠龙记",
            "明星大侦探", "丰乳肥臀", "大主宰", "盗墓笔记", "鬼吹灯", "盘龙", "完美世界", "柠檬初上", "WIFI",
            "锁屏", "异术超能", "东方不败", "巅峰战舰", "小说", "污", "蒲公英", "网红", "霍建华", "林心如",
            "南极", "Java", "Android", "谷歌", "手机", "iPad", "充电宝", "黔驴技穷", "水果", "植物大战僵尸",
            "倩女幽魂", "单机斗地主", "天堂战记", "妖精的尾巴", "极限挑战", "我们相爱吧", "倚天屠龙记",
            "切水果", "手机", "iPad", "充电宝", "黔驴技穷", "水果", "植物大战僵尸", "切水果", "手机", "iPad",
            "充电宝", "黔驴技穷", "水果", "植物大战僵尸", "切水果", "手机", "iPad", "充电宝", "黔驴技穷",
            "水果", "植物大战僵尸", "切水果", "手机", "iPad", "充电宝", "黔驴技穷", "水果", "植物大战僵尸",
            "切水果", "手机", "iPad", "充电宝", "黔驴技穷", "水果", "植物大战僵尸", "切水果", "手机", "iPad",
            "充电宝", "黔驴技穷", "水果", "植物大战僵尸", "切水果", "手机", "iPad", "充电宝", "黔驴技穷",
            "水果", "植物大战僵尸", "切水果", "植物大战僵尸", "切水果", "植物大战僵尸", "切水果", "切水果",
            "充电宝", "黔驴技穷", "水果", "植物大战僵尸", "切水果", "手机", "iPad", "充电宝", "黔驴技穷",
            "倩女幽魂", "单机斗地主", "天堂战记", "妖精的尾巴", "极限挑战", "我们相爱吧", "倚天屠龙记",
            "水果", "植物大战僵尸", "切水果", "手机", "iPad", "充电宝", "黔驴技穷", "水果", "植物大战僵尸",
            "切水果", "手机", "iPad", "充电宝", "黔驴技穷", "水果", "植物大战僵尸", "切水果", "手机", "iPad",
            "充电宝", "黔驴技穷", "水果", "植物大战僵尸", "切水果", "手机", "iPad", "充电宝", "黔驴技穷",
            "水果", "植物大战僵尸", "切水果", "植物大战僵尸", "切水果", "植物大战僵尸", "切水果", "切水果"};

    private int gravity = Gravity.TOP;
    private boolean hasBg = true;
    private boolean isNormal = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fluidLayout = (FluidLayout) findViewById(R.id.fluid_layout);
        btnCenter = (Button) findViewById(R.id.btn_center);
        btnBtm = (Button) findViewById(R.id.btn_btm);
        btnTop = (Button) findViewById(R.id.btn_top);
        btnStroke = (ToggleButton) findViewById(R.id.btn_stroke);
        btnNormal = (Button) findViewById(R.id.btn_normal);

        btnTop.setOnClickListener(this);
        btnBtm.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnNormal.setOnClickListener(this);

        btnStroke.setChecked(hasBg);

        btnStroke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                hasBg = isChecked;
                genTag(hasBg);
            }
        });

        genTag(true);
    }

    @Override
    public void onClick(View v) {
        if (v == btnTop) {
            gravity = Gravity.TOP;
            isNormal = false;
            genTag(hasBg);

        } else if (v == btnCenter) {
            gravity = Gravity.CENTER;
            isNormal = false;
            genTag(hasBg);

        } else if (v == btnBtm) {
            gravity = Gravity.BOTTOM;
            isNormal = false;
            genTag(hasBg);

        } else if (v == btnNormal) {
            isNormal = !isNormal;
            genTag(hasBg);
        }
    }

    private void genTag(boolean hasBg) {
        fluidLayout.removeAllViews();
        fluidLayout.setGravity(gravity);
        for (int i = 0; i < tags.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(tags[i]);
            tv.setTextSize(13);

            if (i == 12) {
                if (!isNormal) {
                    tv.setHeight(100);
                    tv.setGravity(Gravity.CENTER);
                }
                tv.setBackgroundResource(R.drawable.text_bg_highlight);

            } else {
                if (hasBg) {
                    tv.setBackgroundResource(R.drawable.text_bg);
                }
            }

            if (i % 8 == 0) {
                tv.setTextColor(Color.parseColor("#FF0000"));
            } else if (i % 28 == 0) {
                tv.setTextColor(Color.parseColor("#66CD00"));
            } else {
                tv.setTextColor(Color.parseColor("#666666"));
            }

            FluidLayout.LayoutParams params = new FluidLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(12, 12, 12, 12);
            fluidLayout.addView(tv, params);
        }
    }
}
