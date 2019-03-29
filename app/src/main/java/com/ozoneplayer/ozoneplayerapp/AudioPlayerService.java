package com.ozoneplayer.ozoneplayerapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class AudioPlayerService extends Service {
    private Context mContext;
    private SimpleExoPlayer player;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;


        player = ExoPlayerFactory.newSimpleInstance(mContext, new DefaultTrackSelector());

        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(
                mContext,
                Util.getUserAgent(mContext, "AudioPlayer")
        );

        MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse("https://github.com/nzkozar/ExoplayerExample/blob/master/sample.m4a?raw=true"));



        player.prepare(mediaSource);
        player.setPlayWhenReady(true);

    }

    private void startForeground() {
    }

    @Override
    public void onDestroy() {
        player.release();
        player = null;
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
}
