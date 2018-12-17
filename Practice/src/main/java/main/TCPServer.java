/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.SneakyThrows;
import ss.FileUtility;

/**
 *
 * @author Acer
 */
public class TCPServer implements Runnable {

    private static Object obj;
    private int w;

    public TCPServer(int port) {
        w = port;
    }

    @SneakyThrows
    @Override
    public void run() {
        ServerSocket ds = new ServerSocket(w);
        System.out.println("Server Musterini gozleyir");
        
            Socket connection = ds.accept();

            InputStream inputStream = connection.getInputStream();
            DataInputStream ff = new DataInputStream(inputStream);

            int length = ff.readInt();
            if (length > 0) {

                byte[] arr = new byte[length];
                ff.readFully(arr);

                byte[] message = arr;
                FileUtility.writeBytes("C:\\Users\\Acer\\Desktop\\picture.jpg", message);
            } else {
                throw new NegativeArraySizeException();
            }

        
    }
}
