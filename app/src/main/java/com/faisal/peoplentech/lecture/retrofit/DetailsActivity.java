package com.faisal.peoplentech.lecture.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.faisal.peoplentech.lecture.retrofit.model.Anim;

import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity {

    TextView movieTitle;
    TextView data;
    TextView movieDescription;
    TextView rating;
    ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        movieTitle = (TextView) findViewById(R.id.title);
        data = (TextView) findViewById(R.id.subtitle);
        movieDescription = (TextView) findViewById(R.id.description);
        rating = (TextView) findViewById(R.id.rating);
        poster = (ImageView) findViewById(R.id.ivPoster);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Anim anim = (Anim) bundle.getSerializable("detailsKey");

        movieTitle.setText(anim.getName());
        data.setText(anim.getCategorie());
        movieDescription.setText(anim.getDescription());
        rating.setText(anim.getRating().toString());

        Log.e("Details","image "+anim.getImg());
        Glide.with(this).load("http://goo.gl/gEgYUd").into(poster);
    }
}
