package visual;

import java.awt.*;
import javax.swing.*;
import core.*;
public class RectanglesPanel extends JPanel  {
    DemoSorterArray array ;
    RectanglesPanel(DemoSorterArray array) {
        this.array = array;

        Dimension g = new Dimension(array.length(),array.length());
        this.setPreferredSize(g);
        System.out.println("label 1");
    }

    public void updateArray(DemoSorterArray array){
         System.out.println("updateArray called");
         this.array = array;
    }

    public void insert(int x, int value){
         array.insert(x,value);
    }

    public void swap(int x, int y){
         array.swap(x,y);
    }

    public int arrayLength(){
         return array.length();
    }

    public int get(int x){
          return array.get(x);

    }

    public boolean compare(int x, int y){
         return array.compare(x,  y);
    }

    public String getArrayString(){
         return array.toString();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setOpaque(true);
        super.setBackground(Color.gray);
        int y = 20;
        int x = 60;
        g.setColor(Color.red);
        for(int i = 0; i < array.length(); i++){
          int offset = array.max() - array.get(i);
          g.fillRect(x, y + offset, 2, array.get(i));
          x += 2;
        }

        System.out.println(this.getSize());

    }


 }
