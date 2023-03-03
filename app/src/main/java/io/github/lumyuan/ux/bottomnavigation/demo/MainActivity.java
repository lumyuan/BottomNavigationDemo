package io.github.lumyuan.ux.bottomnavigation.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.github.lumyuan.ux.bottomnavigationview.widget.NavigationView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigationView);
        textView = findViewById(R.id.textView);

        //创建导航条目，推荐2~5个，太少会感觉空空的，太多会挤压文字
        NavigationView.ItemView homeItem = navigationView.newItemView();
        NavigationView.ItemView moduleItem = navigationView.newItemView();
        NavigationView.ItemView mineItem = navigationView.newItemView();

        //给导航条设置标题与图片
        homeItem.setText(R.string.home);
        homeItem.setImageResource(R.drawable.ic_home);

        moduleItem.setText(R.string.module);
        moduleItem.setImageResource(R.drawable.ic_module);

        mineItem.setText(R.string.mine);
        mineItem.setImageResource(R.drawable.ic_mine);

        navigationView.addItemView(homeItem);
        navigationView.addItemView(moduleItem);
        navigationView.addItemView(mineItem);

        //给导航条设置选择监听
        navigationView.setOnItemSelectListener((integer, view) -> {
            NavigationView.Item item = (NavigationView.Item) view;
            textView.setText(item.getTitleView().getText());
            return null;
        });

        //选中某项(0表示第一项)
        //navigationView.setCurrentItem(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView = null;
        navigationView = null;
    }
}