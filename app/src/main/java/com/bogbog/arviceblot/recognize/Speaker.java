package com.bogbog.arviceblot.recognize;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import java.util.Locale;

/**
 * Created by Logan on 2015-05-01.
 */
public class Speaker implements OnInitListener {
    private TextToSpeech textToSpeech;

    public Speaker(Context context) {
        textToSpeech = new TextToSpeech(context, this);
    }

    public void speak(String text) {
        speak(text, false);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void speak(String text, boolean interrupt) {
        if (interrupt) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else {
            textToSpeech.speak(text, TextToSpeech.QUEUE_ADD, null, null);
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            Locale defaultLocale = Locale.getDefault();
            if (textToSpeech.isLanguageAvailable(defaultLocale) == TextToSpeech.LANG_AVAILABLE) {
                textToSpeech.setLanguage(defaultLocale);
            }
        }
    }
}
