package com.rightside.deef.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.rightside.deef.R;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imageViewProduct;
    private TabLayout tabLayout;
    private ImageButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageViewProduct = findViewById(R.id.imageView_product_image);
        tabLayout = findViewById(R.id.tabLayout);
        buttonBack = findViewById(R.id.imageButton_back);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Glide.with(getApplicationContext())
                .load("https://a-static.mlcdn.com.br/618x463/smart-tv-crystal-uhd-4k-led-50-samsung-50tu8000-wi-fi-bluetooth-hdr-3-hdmi-2-usb/magazineluiza/225605700/42cdf08f2cf47621e3c745ce17e3e69b.jpg")
                .into(imageViewProduct);

        showFragment(new OfferFragment(), "ofertas");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    showFragment(new OfferFragment(), "ofertas");
                } else {
                    showFragment(new CommentsFragment(), "comentarios");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void showFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, tag).commit();
    }
}