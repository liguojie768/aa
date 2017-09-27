package com.lee.administrator.test0426;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by 李国杰 on 2016/5/3.
 */
public class Welcome extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("welcome");
        setContentView(R.layout.ll);
        new Thread(new Mythread()).start();

    }
    public  class Mythread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("yes welcome");
                Intent intent = new Intent();
                intent.setClass(Welcome.this, LoginActivity.class);
                Welcome.this.startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("no welcome");
            }
        }
    }
}
