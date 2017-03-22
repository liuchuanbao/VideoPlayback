package com.test.myapplication;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;

import java.io.IOException;
import java.net.URL;

/**
 * TextureView+Meidaplayer播放视频
 *
 */
public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "xyc";

     TextureView textureView;
     String strUrl = "http://114.215.249.192:8088/0321%E5%AE%9D%E5%AE%9D.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textureView  = (TextureView) findViewById(R.id.textureView);
        final MediaPlayer mediaPlayer = new MediaPlayer();
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                mediaPlayer.setSurface(new Surface(surface));//设置播放窗口
                try {
                    mediaPlayer.setDataSource(strUrl);//添加播放地址
                } catch (IOException e) {
                    Log.e(TAG, "onSurfaceTextureAvailable: "+e.toString());
                    e.printStackTrace();
                }
                mediaPlayer.prepareAsync();//进入准备装填
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.start();
                    }
                });//准备播放完成监听
            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            }
        });
    }
}
