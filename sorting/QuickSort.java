package sorting;
import core.*;
import visual.*;

public class QuickSort extends AbstractSorter{
     private String name;

     public QuickSort(Thread thread, RectanglesPanel panel){
          super(thread,panel);
          name = "QuickSort";
     }

     public void sort(){
          quickSort(0,panel.arrayLength()-1);
     }

     public String name(){
          return name;
     }

     private int partition(int low, int high){
     //int pivot = arr[high];
          int index = low - 1;
          for(int j = low; j < high; j++){
               if(panel.compare(j,high) == true){
                    index++;
                    panel.swap(index,j);
                    update();
               }
          }
          panel.swap(index+1,high);
          update();
          return index+1;
     }

     private void quickSort(int low,int high){
          if(low < high){
               int pi = partition(low,high);
               quickSort(low, pi-1);
               quickSort(pi+1,high);
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
