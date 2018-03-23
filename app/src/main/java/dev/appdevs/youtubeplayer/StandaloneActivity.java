package dev.appdevs.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener{

    private String GOOGLE_API_KEY = "1009522858392-sluc7m8q04016oc3ji05nhtinl9suivs.apps.googleusercontent.com";
    private String YOUTUBE_VIDEO_ID = "L05qFblcTIk";
    private String YOUTBE_PLAYLIST = "PLrEnWoR732-ALHolmlvCuhIfuSbRhdWpy";
    private Button btnPlayVideo;
    private Button btnPlayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlayList = (Button) findViewById(R.id.btnPlayList);
        btnPlayVideo.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTBE_PLAYLIST);
                break;
            default:

        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
