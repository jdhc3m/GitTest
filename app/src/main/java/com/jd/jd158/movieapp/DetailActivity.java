package com.jd.jd158.movieapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView mTitle;
    TextView mSynopsis;
    TextView mReleaseDate;
    TextView mUserRating;
    Uri mUriImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = (TextView) findViewById(R.id.title);
        mSynopsis = (TextView) findViewById(R.id.synopsis);
        mReleaseDate = (TextView) findViewById(R.id.release_date);
        mUserRating = (TextView) findViewById(R.id.user_rating);

        Intent intentThatDtartThisActivity = getIntent();

        if (intentThatDtartThisActivity != null){
            if (intentThatDtartThisActivity.hasExtra(Intent.EXTRA_TEXT)){


            }
        }
    }
}
