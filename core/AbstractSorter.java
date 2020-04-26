package core;
import visual.*;
public abstract class  AbstractSorter implements Sorter{

     public final Thread thread;
     public  final RectanglesPanel panel;


     protected AbstractSorter(Thread thread, RectanglesPanel panel){
          this.thread = thread;
          this.panel = panel;
     }





}
