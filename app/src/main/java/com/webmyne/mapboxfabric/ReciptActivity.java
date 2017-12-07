package com.webmyne.mapboxfabric;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import custom.Animation;
import custom.AnimationListener;
import custom.BounceAnimation;
import custom.SlideInUnderneathAnimation;
import custom.SlideOutAnimation;


public class ReciptActivity extends AppCompatActivity {

    private ImageView imgRecipt;
    private ImageView imgMachine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipt);

        init();
        actionListener();
    }

    private void init() {
        imgRecipt = (ImageView) findViewById(R.id.imgReceipt);
        imgMachine = (ImageView) findViewById(R.id.imgMachine);
    }

    private void actionListener() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgRecipt.setVisibility(View.VISIBLE);

                slideAnime(true);

            }
        }, 2000);

    }

    private void slideAnime(final boolean isDown) {
        if (isDown) {
            new SlideInUnderneathAnimation(imgRecipt)
                    .setDirection(Animation.DIRECTION_UP)
                    .setDuration(2000)
                    .setListener(new AnimationListener() {
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    slideAnime(false);
                                }
                            }, 7000);
                        }
                    })
                    .animate();
        } else {
            int lh = imgRecipt.getLayoutParams().height;
            System.out.println("lh=" + lh);
            imgRecipt.animate()
                    .translationY(lh)
                    .alpha(1.0f)
                    .setDuration(2000)
                    .setListener(null);
        }

    }

    private void slideOut() {
        new SlideOutAnimation(imgMachine)
                .setDirection(Animation.DIRECTION_RIGHT)
                .setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        bounceAnimation();
                    }
                })
                .animate();
    }


    private void bounceAnimation() {
        new BounceAnimation(imgRecipt)
                .setNumOfBounces(3)
                .setDuration(Animation.DURATION_SHORT)
                .animate();
    }


}
