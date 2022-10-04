/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gumball;

import javax.swing.JFrame;
import sun.management.Agent;

/**
 *
 * @author makol
 */
public class Gumball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame f = new JFrame(); //jframe nesnesi olusturma
        f.setTitle("furgan");    //jframe isim ekleme
        f.setSize(1080, 1080);   //jframenin boyutu
        f.setLocation(0, 0);     //jframenin ekrandaki konumu
        f.setResizable(false);   //jframenin boyutunu degistiren tus
        f.setVisible(true);      //jframeyi ekranda gosterme
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);  //jframeyi kapatinca programi durduran kod
        nesneler x = new nesneler();
        Thread t1 = new Thread(x);
        Thread t2 = new Thread(x);
            t1.start();
        t2.start();
                
        nesneler game = new nesneler();
        f.add(game);
        
    }
    
}
