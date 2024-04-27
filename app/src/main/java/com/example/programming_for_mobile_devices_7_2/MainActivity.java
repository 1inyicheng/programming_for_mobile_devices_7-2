package com.example.programming_for_mobile_devices_7_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lv;
    private String[] cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // 取得字串陣列的城市名稱陣列
        cities = getResources().getStringArray(R.array.cities);
        // 取得ListView元件
        lv = (ListView) findViewById(R.id.listview);
        lv.setOnItemClickListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("你是住在:" + cities[position]);
    }
}