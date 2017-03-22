package com.test.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by 鹤 on 2015/10/20.
 */
public class PlayActivity extends Activity {

    private VideoView mVideoView;
    private MediaController mMediaController;

//    String path1 = Environment.getExternalStorageDirectory() + "/Movies/dabao.mp4";
String path3 = "http://122.224.82.50:8080/hls/12101000010000773301/index.m3u8";
    String path2 = "http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
            return;

        setContentView(R.layout.activity_play);

        mVideoView = (VideoView) findViewById(R.id.surface_view);
        mVideoView.setVideoURI(Uri.parse("path3"));
//        mVideoView.setVideoPath(path1);//设置本地播放地址
        mMediaController = new MediaController(this);
        mMediaController.show(5000);
        mVideoView.setMediaController(mMediaController);
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//高画质
        mVideoView.requestFocus();
        mMediaController.show(5000);

    }
}
