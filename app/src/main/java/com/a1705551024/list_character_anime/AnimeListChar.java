package com.a1705551024.list_character_anime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.jar.Attributes;


public class AnimeListChar extends AppCompatActivity {
    private static final String TAG = "Animelistchar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_list_char);
        Log.d(TAG,"onCreate: started.");

        getIncomingIntent();
    }

    public void getIncomingIntent(){
        Log.d(TAG,"GetIncomingIntentData: check incoming intent.");
        if(getIntent().hasExtra("namechar") && getIntent().hasExtra("imgchar") && getIntent().hasExtra("chardesc") && getIntent().hasExtra("quirkchar")
                && getIntent().hasExtra("powerchar") && getIntent().hasExtra("speedchar") && getIntent().hasExtra("techniquechar") && getIntent().hasExtra("intelligencechar") && getIntent().hasExtra("cooperativenesschar")
                && getIntent().hasExtra("directto")){
            Log.d(TAG,"GetIncomingIntentData: Get Intent Extra.");

            String Imgchar = getIntent().getStringExtra("imgchar");
            String Namechar = getIntent().getStringExtra("namechar");
            String Descchar = getIntent().getStringExtra("chardesc");
            String Quirkchar = getIntent().getStringExtra("quirkchar");

            //Content Table
            String Powerchar = getIntent().getStringExtra("powerchar");
            String Speedchar = getIntent().getStringExtra("speedchar");
            String Techniquechar = getIntent().getStringExtra("techniquechar");
            String Intelligencechar = getIntent().getStringExtra("intelligencechar");
            String Cooperativenesschar = getIntent().getStringExtra("cooperativenesschar");
            String Directlink = getIntent().getStringExtra("directto");

            setName(Imgchar, Namechar, Descchar, Quirkchar, Powerchar, Speedchar, Techniquechar, Intelligencechar, Cooperativenesschar, Directlink);
        }
    }

    private void setName(String Imgchar, String Namechar, String Descchar, String Quirkchar, String Powerchar, String Speedchar, String Techniquechar, String Intelligencechar, String Cooperativenesschar, String Directto ){
        Log.d(TAG, "setImage: Setting img and name.");
        setTitle(Namechar);
        Spanned Text;

        TextView name = findViewById(R.id.name_char);
        name.setText(Namechar);

        TextView desc = findViewById(R.id.char_desc);
        desc.setText(Descchar);

        TextView quirk = findViewById(R.id.quirk_desc);
        quirk.setText(Quirkchar);

        // Content Table

        TextView power = findViewById(R.id.power_char);
        power.setText(Powerchar);

        TextView speed = findViewById(R.id.speed_char);
        speed.setText(Speedchar);

        TextView technique = findViewById(R.id.technique_char);
        technique.setText(Techniquechar);

        TextView intelligence = findViewById(R.id.intelligence_char);
        intelligence.setText(Intelligencechar);

        TextView cooperativeness = findViewById(R.id.cooperativeness_char);
        cooperativeness.setText(Cooperativenesschar);

        TextView directto = findViewById(R.id.sourcefandom);
        Text = Html.fromHtml("<a href='"+Directto+"'>Boku No Hero Fandom</a>");

        directto.setMovementMethod(LinkMovementMethod.getInstance());
        directto.setText(Text);

        ImageView image = findViewById(R.id.img_char);
        Glide.with(this)
                .load(Imgchar)
                .into(image);
    }
}
