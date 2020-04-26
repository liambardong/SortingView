
package visual;
import core.*;

final class DemoSorterArray extends AbstractSorterArray{

     private int max ;
     public DemoSorterArray(int [] array, int max){
          super(array);
          this.max = max;
     }

     public int max(){
          return max;
     }


}
