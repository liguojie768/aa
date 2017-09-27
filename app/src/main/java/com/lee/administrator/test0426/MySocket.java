package com.lee.administrator.test0426;

import android.os.Bundle;
import android.os.Message;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * Created by 李国杰 on 2016/4/28.
 */
public class MySocket implements Runnable {
    final private String ip = "192.168.0.112";
    final private int port = 8888;
    private Socket mySocket;
    private DataOutputStream out;                //用于往Socket种写入数据
    private DataInputStream in;
    private  int flag;
   // Handler myHandler;
    public MySocket(int i){
        flag = i;
    }

    public void run() {
       // myHandler = new Handler();
        try {
            System.out.println(flag);

            mySocket = new Socket(ip,port);
            out = new DataOutputStream(mySocket.getOutputStream());//Returns an output stream
            in = new DataInputStream(mySocket.getInputStream());	//Returns a Input stream
            if(1 == flag)
            {
                out.writeUTF("aaaaaaa");
                System.out.print(0);
                out.flush();

            }else if(2 == flag){
                System.out.print(1);
                out.writeUTF("bbbbbbbb");
                out.flush();

            }else {
                out.writeUTF("ddddddd");
                out.flush();
                String a =in.readUTF();
                System.out.println(a);
                out.writeUTF("aaaaaaa");


                System.out.println("message");
                Message msg = new Message();
                Bundle b = new Bundle();// 存放数据
                b.putString("color", a);
                msg.setData(b);
                MainActivity.myHandler.sendMessage(msg); // 向Handler*/

            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            System.out.print(false);
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
