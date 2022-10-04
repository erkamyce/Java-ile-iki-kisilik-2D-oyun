package gumball;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author makol
 */
public class nesneler extends JPanel implements KeyListener,Runnable,ActionListener{
    JLabel yazi ;
    JLabel yazi1 ;
    Timer timer = new Timer(5, this);
    
    Random r =new Random();
    public int carpisma1=0,carpisma2=0;
    int atesdiry;
   class ates{
       private int x;
       private int y;
       public ates (int x,int y){
           this.x=x;
           this.y=y;
       }
       public int getX(){
        return x;
       }
       public void setX(int x){
           this.x=x;
       }
       public int getY(){
        return y;
       }
       public void setY(int y){
           this.y=y;
       }
    
    }
    private ArrayList<ates> atesler = new ArrayList<ates>();
    //extends jpanel jpanelin butun fonksiyonlarini kulanmani sagliyo
    String Hedef1 = "C:\\Users\\makol\\Documents\\NetBeansProjects\\gumball\\src\\gumball\\hedef1.png" ;
    String Hedef2 = "C:\\Users\\makol\\Documents\\NetBeansProjects\\gumball\\src\\gumball\\hedef1.png" ;
    //Hedef//
    int hedef1x=540,hedef2x=50;
    int hedef1y=0,hedef2y=0;
    int hedef1w=50,hedef2w=50;
    int hedef1h=50,hedef2h=50;
    //Hedef//
    String arkaplan = "C:\\Users\\makol\\Documents\\NetBeansProjects\\gumball\\src\\gumball\\oyun1.png";
    //1.Karakter Ozelliklaeri// 
    int can = 0;
    int k_x = 0;
    int k_y = 860;
    int k_w = 30;
    int k_h = 40;
    String karakter1 = "C:\\Users\\makol\\Documents\\NetBeansProjects\\gumball\\src\\gumball\\karakter1.1.png";
    //1.Karakter Ozellikleri// 
    //2.karakter Ozellikleri//
    int can1 = 0;
    int k1_x = 0;
    int k1_y = 860;
    int k1_w = 30;
    int k1_h = 40;
    //2.Karakter Ozellikleri//
    String karakter2 = "C:\\Users\\makol\\Documents\\NetBeansProjects\\gumball\\src\\gumball\\karakter1.1.png";
    //Buyuk Platform Ozellikleri//
    int bp_x = 0;
    int bp_y = 900;
    int bp_w = 1080;
    int bp_h = 100;
    String bPlatform = "C:\\Users\\makol\\Documents\\NetBeansProjects\\gumball\\src\\gumball\\Katman1.png";
    //Buyuk Platform Ozellikleri//
    //Orta Platform Ozellikleri//
    int op_x = 0;
    int op_y = 0;
    int op_w = 0;
    int op_h = 0;
    //Orta Platform Ozellikleri//
    //KucukPlatform Ozellikleri//
    int kp_x = 0;
    int kp_y = 0;
    int kp_w = 0;
    int kp_h = 0;
    //KucukPlatform Ozellikleri//
    //carpisma
    public boolean kontrolet(){
        for (ates ates : atesler) {
            if (new Rectangle(ates.getX(), ates.getY(), 10, 20).intersects(new Rectangle(hedef1x, 0, 50, 50))) {
                carpisma1+=1;
                return true;
            }
        }
        return false;
    }
    public boolean kontrolet1(){
        for (ates ates : atesler) {
            if (new Rectangle(ates.getX(), ates.getY(), 10, 20).intersects(new Rectangle(hedef2x, 0, 50, 50))) {
                carpisma2+=1;
                return true;
                
            }
        }
        return false;
    }
    
    //carpisma
    //constructor//
    
    
    public nesneler(){
         addKeyListener(this);
         timer.start();
         
         
    }
    //Constructor//
    //Nesne Cizimleri//
    @Override
    public void paintComponent(Graphics g){
     super.paintComponent(g);
     ImageIcon ico = new ImageIcon(this.arkaplan);
     ico.paintIcon(this, g, 0, 0);
     ImageIcon ico1 = new ImageIcon(this.karakter1);
     ico1.paintIcon(this, g, this.k1_x,this.k1_y);
     ImageIcon ico2 = new ImageIcon(this.bPlatform);
     ico2.paintIcon(this, g, this.bp_x, this.bp_y);
     ImageIcon ico3 = new ImageIcon(this.karakter2);
     ico3.paintIcon(this, g,this.k_x,this.k_y);
     ImageIcon ico4 = new ImageIcon(this.Hedef1);
     ico4.paintIcon(this, g, this.hedef1x, this.hedef1y);
     ImageIcon ico5 = new ImageIcon(this.Hedef2);
     ico5.paintIcon(this, g, this.hedef2x, this.hedef2y);
     //ImageIcon ico = new ImageIcon(this.arkaplan);
     //ico.paintIcon(this, g, 0, 0);
     //ImageIcon ico = new ImageIcon(this.arkaplan);
     //ico.paintIcon(this, g, 0, 0);
     //ImageIcon ico = new ImageIcon(this.arkaplan);
     //ico.paintIcon(this, g, 0, 0);
        for (ates ates : atesler) {
            if (ates.getY()<0) {
                atesler.remove(ates);
            }
        }
        g.setColor(Color.BLUE);
        for (ates ates: atesler) {
            g.fillRect(ates.getX(), ates.getY(), 10, 20);
        }
        for (ates ates : atesler) {
            if (ates.getY()<0) {
                atesler.remove(ates);
            }
        }
        g.setColor(Color.BLUE);
        for (ates ates: atesler) {
            g.fillRect(ates.getX(), ates.getY(), 10, 20);
        }
        if (kontrolet()) {
            
            timer.stop();
            String mesaj3= "2. oyuncu kazandi ";
            JOptionPane.showMessageDialog(this, mesaj3);
            System.exit(0);
           
        }
        
        if (kontrolet1()) {
            timer.stop();
            String mesaj3= "1. oyuncu kazandi ";
            JOptionPane.showMessageDialog(this, mesaj3);
            System.exit(0);
        
        }
        
        
        repaint();
    }
    //Nesne Cizimleri//
    
    @Override
    public boolean isFocusTraversable() {
		    return true;
	}
    
 
   

    @Override
    public  void keyPressed(KeyEvent ke) {
        int tus = ke.getKeyCode();
        int tus1= ke.getKeyCode();
        int a1 = ke.getKeyCode();
        int a2 = ke.getKeyCode();
        if (tus == KeyEvent.VK_A && this.k1_x>=0) {
            this.k1_x=this.k1_x-20;
        }
        if (tus == KeyEvent.VK_D && this.k1_x<=1040) {
            this.k1_x= this.k1_x+20;
        }
       
        if (tus1 == KeyEvent.VK_F && this.k_x>=0) {
            this.k_x=this.k_x-20;
        }
        if (tus1 == KeyEvent.VK_H && this.k_x<=1040) {
            this.k_x= this.k_x+20;
        }
        if (a1==KeyEvent.VK_SPACE) {
            atesler.add(new ates(this.k1_x+10, 860));
        }
        if (a2==KeyEvent.VK_0) {
            atesler.add(new ates(this.k_x+10, 860));
        }
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    public void yercekimi (){
        if (this.k1_y<=851) {
            this.k1_y+=10;
        }
    
    
    }

    @Override
    public void run() {
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        int a;
        a = r.nextInt(5)*5;
        hedef1x=hedef1x+a;
        if (hedef1x>=1080) {
            hedef1x=-a;
        }
        if (hedef1x<=0) {
            hedef1x=+a;
        }
        
        hedef2x=hedef2x+a;
        if (hedef2x>=1080) {
            hedef2x=-a;
        }
        if (hedef2x<=0) {
            hedef2x=+a;
        }
        for(ates ates :  atesler){
            ates.setY(ates.getY()-10);
        }
        for(ates ates :  atesler){
            ates.setY(ates.getY()-10);
        }
        
        repaint();
    }

    
}
