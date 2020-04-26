package sorting;
import core.*;
import visual.*;

public class BubbleSort extends AbstractSorter{
     private String name;
     public BubbleSort(Thread thread, RectanglesPanel panel){
          super(thread,panel);
          name = "BubbleSort";
     }

     public String name(){
          return name;
     }

     public void sort(){
          for(int i = 0; i < panel.arrayLength()-1; i++){
              for(int j = 0; j < panel.arrayLength() - i - 1; j++){
                  if(panel.get(j) > panel.get(j+1)){
                       panel.swap(j,j+1);
                       update();
                  }
            }
        }
     }

     public void update(){
          super.panel.repaint();
         try
         {
              thread.sleep(5);
         }catch(InterruptedException z){System.out.println(z);}
     }
}
