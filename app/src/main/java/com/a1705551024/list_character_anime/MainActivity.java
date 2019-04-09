package com.a1705551024.list_character_anime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnfujisaki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfujisaki = findViewById(R.id.btn_fuujisaki);
        btnfujisaki.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_fuujisaki:
            Intent goes_to_yuusuke_fujisaki_activity = new Intent(MainActivity.this, Yusuke_Fujisaki_Det.class);
            startActivity(goes_to_yuusuke_fujisaki_activity);
            break;
        }
    }
}
