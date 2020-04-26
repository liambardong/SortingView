package sorting;
import core.*;
import visual.*;

public class MergeSort extends AbstractSorter{
     private String name;
     public MergeSort(Thread thread, RectanglesPanel panel){
          super(thread,panel);
          name = "MergeSort";
     }

     public String name(){
          return name;
     }

     public void sort(){
          mergeSort( 0, panel.arrayLength()-1);
     }


     // Still slow for some reason, neeed to keep working on merge sort.
   public void merge(int left,int middle, int right){
        int lengthOne = middle-left + 1;
        int lengthTwo = right - middle;
        int leftArray[] = new int[lengthOne];
        int rightArray[] = new int[lengthTwo];
        for(int i=0; i<(lengthOne);++i){
                 leftArray[i] = panel.get(left+i);
            }
         for(int j=0; j<(lengthTwo);++j){
              rightArray[j] = panel.get(middle+1+j);
         }

    // Merge the two arrays
         int idxLeft = 0, idxRight = 0;
         int idxArray = left;
         //update(arr);
         while (idxLeft < (lengthOne) && idxRight < (lengthTwo)){
              if(leftArray[idxLeft] <= rightArray[idxRight]){
                   panel.insert(idxArray,leftArray[idxLeft]);
                   idxLeft ++;

              }else{
                   panel.insert(idxArray,rightArray[idxRight]);
                   idxRight ++;

              }
             update();
              idxArray ++;

    }
    while (idxLeft < (lengthOne)){
        panel.insert(idxArray,leftArray[idxLeft]);
        idxLeft ++;
        idxArray ++;
        update();
    }
    while (idxRight < (lengthTwo)){
        panel.insert(idxArray,rightArray[idxRight]);
        idxRight ++;
        idxArray ++;
        update();
    }


   }

   public void mergeSort( int l, int r){

        if(l < r){
           int m = (l+r)/2;
           mergeSort(l,m);
           mergeSort(m+1,r);
           merge(l,m,r);

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
