package com.bogbog.arviceblot.recognize;

import android.content.Context;

/**
 * Created by Logan on 2015-05-02.
 */
public class SpeakerListenerManager {
    private Speaker speaker;
    private Listener listener;

    public SpeakerListenerManager(Context context) {
        speaker = new Speaker(context);
        listener = new Listener();
    }
}
