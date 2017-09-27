package com.lee.administrator.test0426;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by 李国杰 on 2016/4/27.
 */
public class MainActivity extends Activity {
    public static Handler myHandler;
    ToggleButton updown;
    Button show;
    TextView text;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myHandler = new MyHandler();
        updown = (ToggleButton)findViewById(R.id.mTogBtn);
        show = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.textView) ;
        updown.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    new Thread(new MySocket(1)).start();
                    System.out.println("kai");
                }else{
                    System.out.println("guan");
                    new Thread(new MySocket(2)).start();
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new MySocket(3)).start();

            }
        });
    }

    public class MyHandler extends Handler {//接收子线程发来的消息
        @SuppressLint("HandlerLeak")
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String color = b.getString("color");
            text.setText(color);

        }

    }
    String  cut(String a){

        System.setProperty("user.timezone", "GMT+8");
        //时区设置

        String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        ContentValues values = new ContentValues();
        values.put("tem", Integer.valueOf(a.substring(0, 2)));
        values.put("time", time);

        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,"test_db",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.insert("user",null,values);
        db.close();
        System.out.println("数据库");
        return ("温度"+a.substring(0,2)+"湿度"+a.substring(2,4)+"光照"+a.substring(4, 7)+a.substring(7, 9));
    }

}

