package com.example.windows.hack2;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    private Button mRecordView, mPlayView;
    private VideoView mVideoView;
    private int ACTIVITY_START_CAMERA_APP = 0;
    private static final int RESULT_LOAD_IMAGE = 0;
    private static final int MY_PERMISSIONS_REQUEST_STORAGE = 1;
    ImageView iv_image, iv_colour;
    TextView tv_colour;
    private Button mb_gallery;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecordView = (Button) findViewById(R.id.recordButton);
        mPlayView = (Button) findViewById(R.id.playButton);
        mVideoView = (VideoView) findViewById(R.id.videoView);

        iv_image = (ImageView) findViewById(R.id.iv_image);
        iv_colour = (ImageView) findViewById(R.id.iv_colour);
        tv_colour = (TextView) findViewById(R.id.tv_colour);
        mb_gallery = (Button) findViewById(R.id.b_gallery);


        mRecordView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callVideoAppIntent = new Intent();
                callVideoAppIntent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(callVideoAppIntent, ACTIVITY_START_CAMERA_APP);

            }
        });
        mPlayView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.start();

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_START_CAMERA_APP && resultCode == RESULT_OK) {
            //   Intent callVideoAppIntent= new Intent();
            // callVideoAppIntent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
            // startActivityForResult(callVideoAppIntent,ACTIVITY_START_CAMERA_APP);
            Uri videoUri = data.getData();
            mVideoView.setVideoURI(videoUri);
        }
    }




}
