package dev.appdevs.youtubeplayer;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener
    {
        private String GOOGLE_API_KEY = "1009522858392-sluc7m8q04016oc3ji05nhtinl9suivs.apps.googleusercontent.com";
        private String YOUTUBE_VIDEO_ID = "L05qFblcTIk";

        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
            Toast.makeText(this, "Initialized Youtube Player successfully", Toast.LENGTH_LONG).show();
            youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
            youTubePlayer.setPlaybackEventListener(playbackEventListener);
            if (!wasRestored) {
                youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
            }
        }

        private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {
                Toast.makeText(YouTubeActivity.this, "Good video si playing ok", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPaused() {
                Toast.makeText(YouTubeActivity.this, "The video has paused", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopped() {

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        };

        YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(String s) {

            }

            @Override
            public void onAdStarted() {
                Toast.makeText(YouTubeActivity.this, "CLick ad now", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(YouTubeActivity.this, "Video has started", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onVideoEnded() {

            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        };

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            Toast.makeText(this, "Failed to initializedd youtube player", Toast.LENGTH_LONG).show();
        }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_you_tube);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);


    }

}
