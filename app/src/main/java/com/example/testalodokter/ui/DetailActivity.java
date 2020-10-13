package com.example.testalodokter.ui;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testalodokter.R;
import com.example.testalodokter.utils.DummyData;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class DetailActivity extends AppCompatActivity implements ImageListener {

    public static final String EXTRA_DATA = "extra_data";
    private int[] imageList;
    private CarouselView carouselView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        carouselView = findViewById(R.id.carouselView);

        try {
            String mData = getIntent().getStringExtra(EXTRA_DATA);
            assert mData != null;
            generateImagesList(mData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateImagesList(String mData) {
        switch (mData) {
            case "0":
                imageList = DummyData.imagesRapid();
                carouselView.setPageCount(imageList.length);
                carouselView.setImageListener(this);
                break;
            case "1":
                imageList = DummyData.imagesInfus();
                carouselView.setPageCount(imageList.length);
                carouselView.setImageListener(this);
                break;
            case "2":
                imageList = DummyData.imagesObat();
                carouselView.setPageCount(imageList.length);
                carouselView.setImageListener(this);
                break;
        }
    }

    @Override
    public void setImageForPosition(int position, ImageView imageView) {
        imageView.setImageResource(imageList[position]);
    }
}