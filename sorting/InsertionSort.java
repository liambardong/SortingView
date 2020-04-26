package sorting;
import core.*;
import visual.*;

public class InsertionSort extends AbstractSorter{
     public String name;
     public InsertionSort(Thread thread, RectanglesPanel panel){
          super(thread,panel);
     }

     public String name(){
          return name;
     }

     public void sort(){
          for( int i = 1; i < (panel.arrayLength()); ++i){

               int currNum = panel.get(i);
               int j = i - 1;
               int k = 0;
               while(j >= 0 && panel.get(j) > currNum){
                    k = j+1;
                    panel.insert(k,panel.get(j));
                    update();
                    j = j -1;
               }
               k = j+1;
               panel.insert(k, currNum);
               update();

          }
     }

     public void update(){

          super.panel.repaint();
         try
         {
              thread.sleep(1);
         }catch(InterruptedException z){System.out.println(z);}
     }
}
