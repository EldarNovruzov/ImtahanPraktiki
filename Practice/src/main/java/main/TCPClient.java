/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import lombok.SneakyThrows;
import ss.FileUtility;

/**
 *
 * @author Acer
 */
public class TCPClient implements Runnable {

    private String host;
    private int port;
    private String yy;

    public TCPClient(String a, int b, String c) {
        host = a;
        port = b;
        yy = c;
    }
    
    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(5000);
        Socket hh = new Socket(host, port);
        OutputStream outputStream = hh.getOutputStream();
        DataOutputStream ss = new DataOutputStream(outputStream);
        byte[] arrd = FileUtility.readBytes(yy);
        ss.writeInt(arrd.length);
        ss.write(arrd);
        System.out.println("Fayl ugurla gonderildi");
        hh.close();
    }

}
