package core;

public abstract class  AbstractSorterArray implements SorterArray {
     int array[];
     int length;
     public AbstractSorterArray(int array[]){
          length = array.length;
          this.array = array;

     }

     public int length(){
          return this.length;
     }


     public void swap(int x, int y){
          int temp = array[x];
          array[x] = array[y];
          array[y] = temp;
     }

     public void insert(int x, int value){
          if(x >= 0 && x < length){
               array[x] = value;
          }
     }

     public int get(int x){
          if(x < 0 && x > length){
               System.out.println("need to create error");
          }

          return array[x];

     }

     public boolean compare(int x , int y){
          if(array[x] < array[y]){
               return true;
          }else{
               return false;
          }
     }

     public String toString(){
          String retString = "[";
          for (int i = 0; i< length-1; i++){
               retString += " " + array[i] + " ,";
          }
          retString += " " + array[length-1] + " ";
          retString += "]";

          return retString;
     }



}
