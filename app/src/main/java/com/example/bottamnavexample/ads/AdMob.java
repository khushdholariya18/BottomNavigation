package com.example.bottamnavexample.ads;

import android.content.Context;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class AdMob {


    public static void serBanner(LinearLayout banner, Context context){
        if (AdsUnit.isAds){
            MobileAds.initialize(context, initializationStatus -> {});

            AdView adView = new AdView(context);
            banner.addView(adView);

            adView.setAdUnitId(AdsUnit.Banner);
            adView.setAdSize(AdSize.BANNER);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }
    }
}
