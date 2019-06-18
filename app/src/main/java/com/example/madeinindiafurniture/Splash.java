package com.example.madeinindiafurniture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ImageView imageView = findViewById(R.id.splash_img);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imageView.startAnimation(animation);
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();
    }
    class LogoLauncher extends Thread {
        public void run() {

            try {
                sleep(3000);
                Intent intent = new Intent(Splash.this, LoginActivity.class);
                startActivity(intent);
                Splash.this.finish();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
