package com.jd.jd158.movieapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jd158 on 6/04/2017.
 */
public class Movie implements Parcelable{

    //public static Movie getOriginalTitle;

    private String mOriginalTitle;
    private String mSynopsis;
    private String mVoteAvg;
    private String mReleaseDate;
    private String mImagePath;
    private String mMovieId;

    public Movie(String OriginalTitle, String Synopsis, String VoteAvg, String ReleaseDate,
                 String ImagePath, String MovieId) {

        mOriginalTitle = OriginalTitle;
        mSynopsis = Synopsis;
        mVoteAvg = VoteAvg;
        mReleaseDate = ReleaseDate;
        mImagePath = ImagePath;
        mMovieId = MovieId;

    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mOriginalTitle);
        dest.writeString(mImagePath);
        dest.writeString(mMovieId);
        dest.writeString(mReleaseDate);
        dest.writeString(mSynopsis);
        dest.writeString(mVoteAvg);
    }

    // "De-parcel object
    public Movie(Parcel in) {
        mOriginalTitle = in.readString();
        mImagePath = in.readString();
        mMovieId = in.readString();
        mReleaseDate = in.readString();
        mSynopsis= in.readString();
        mVoteAvg= in.readString();

    }

}
