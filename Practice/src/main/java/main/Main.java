/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Main {
    public static void main(String[] args) throws Exception {
        mainss();
        
    }
    public static void mainss() throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Adinizi daxil edin:");
        String nl = sc.nextLine();
        Scanner sc1=new Scanner(System.in);
        System.out.println("Soyadinizi daxil edin:");
        String dd=sc1.nextLine();
        
        Scanner fd=new Scanner(System.in);
        System.out.println("Zehmet olmasa gondermek istediyiniz faylin yerlesdiyi kecidi qeyd edin:");
        String lf = fd.nextLine();
        
        Scanner musteri=new Scanner(System.in);
        System.out.println("Bu fayli gondermek istediyiniz sexsin(serverin) ip ve portunu daxil edin(zehmet olmasa : simvolu ile):");
        String next = musteri.nextLine();
        
        String[] ar=next.split(":");
        String ip=ar[0];
        int port=Integer.parseInt(ar[1]);
        Thread od=new Thread(new TCPServer(port));
        Thread fr=new Thread(new TCPClient(ip,port,lf));
        od.start();
        fr.start();
    }
}
