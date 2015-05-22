/*package com.tugasakhirhore.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.youtube.player.*;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.tugasakhirhore.senyumceria.R;
 
public class Video extends Activity {
 
    private int REQ_PLAYER_CODE     = 1;
    private static String YT_KEY    = "AIzaSyDy6h_ypbuhy5Dw5dSQWdsETUzB2ZFpdK4";
    private static String VIDEO_ID  = "sjOfxnlGAF4";    // Your video id here
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         
        Intent videoIntent = YouTubeStandalonePlayer.createVideoIntent(this, YT_KEY, VIDEO_ID, 0, true, false);
         
        startActivityForResult(videoIntent, REQ_PLAYER_CODE);
         
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_PLAYER_CODE && resultCode != RESULT_OK) {
            YouTubeInitializationResult errorReason = YouTubeStandalonePlayer.getReturnedInitializationResult(data);
            if (errorReason.isUserRecoverableError()) {
                errorReason.getErrorDialog(this, 0).show();
            } else {
                String errorMessage = String.format("PLAYER ERROR!!", errorReason.toString());
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
            }
        }
    }
}

	import android.content.Intent;
	import android.os.Bundle;
	import android.view.Window;
	import android.view.WindowManager;
	import android.widget.Toast;
	 
	import com.google.android.youtube.player.YouTubeBaseActivity;
	import com.google.android.youtube.player.YouTubeInitializationResult;
	import com.google.android.youtube.player.YouTubePlayer;
	import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
	import com.google.android.youtube.player.YouTubePlayerView;
	import com.tugasakhirhore.senyumceria.R;
	 
	public class Video  extends YouTubeBaseActivity implements
	        YouTubePlayer.OnInitializedListener {
	 
	    private static final int RECOVERY_DIALOG_REQUEST = 1;
	 
	    // YouTube player view
	    private YouTubePlayerView youTubeView;
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	 
	        setContentView(R.layout.main);
	 
	        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
	 
	        // Initializing video player with developer key
	        youTubeView.initialize(Config.DEVELOPER_KEY, this);
	 
	    }
	 
	    @Override
	    public void onInitializationFailure(YouTubePlayer.Provider provider,
	            YouTubeInitializationResult errorReason) {
	        if (errorReason.isUserRecoverableError()) {
	            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
	        } else {
	            String errorMessage = String.format(
	                    getString(R.string.error_player), errorReason.toString());
	            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
	        }
	    }
	 
	    @Override
	    public void onInitializationSuccess(YouTubePlayer.Provider provider,
	            YouTubePlayer player, boolean wasRestored) {
	        if (!wasRestored) {
	 
	            // loadVideo() will auto play video
	            // Use cueVideo() method, if you don't want to play it automatically
	            player.loadVideo(Config.YOUTUBE_VIDEO_CODE);
	 
	            // Hiding player controls
	            player.setPlayerStyle(PlayerStyle.CHROMELESS);
	        }
	    }
	 
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        if (requestCode == RECOVERY_DIALOG_REQUEST) {
	            // Retry initialization if user performed a recovery action
	            getYouTubePlayerProvider().initialize(Config.DEVELOPER_KEY, this);
	        }
	    }
	 
	    private YouTubePlayer.Provider getYouTubePlayerProvider() {
	        return (YouTubePlayerView) findViewById(R.id.youtube_view);
	    }
	 
	

}
*/