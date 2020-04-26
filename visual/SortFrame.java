package visual;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.*;
import core.*;
import sorting.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;



public  class SortFrame extends JFrame implements ActionListener{
    private JPanel fullWrapper;
    private JPanel buttonWrapper;
    private RectanglesPanel sorterWrapper;
    private JButton startButton;
    private JButton stopButton;
    private JComboBox<String> sortSelection;
    private JSlider speed;
    private Timer timer;
    private String[] sortArray = {"Bubble Sort","Insertion Sort","Merge Sort", "Quick Sort"};
    private DemoSorterArray array;
    private boolean running;
    private int alength;
    private int aMax;
    private JSlider rangeSlider;
    private JSlider maxSlider;
    private JSlider speedSlider;

    static final int SS_MIN = 1;
    static final int SS_MAX = 5;
    static final int SS_INIT = 2;


    static final int RS_MIN = 100;
    static final int RS_MAX = 500;
    static final int RS_INIT = 300;


    static final int MS_MIN = 100;
    static final int MS_MAX = 400;
    static final int MS_INIT = 250;


    public SortFrame(){
	        super("Sorting Viewer");

             running = false;
             Random r = new Random();
	            // initialize the wrappers
	         buttonWrapper = new JPanel(new GridLayout(0, 1));


              alength = 200;
              aMax = 450;
              int[] arr =newArr(alength,aMax);
              array = new DemoSorterArray(arr,aMax);


	         sorterWrapper = new RectanglesPanel(array);
	         fullWrapper = new JPanel(new BorderLayout());
	         // initialize the wrappers
	         startButton = new JButton("Start");
	         sortSelection = new JComboBox<String>(sortArray);

              speedSlider = new JSlider(JSlider.HORIZONTAL,
                                      SS_MIN, SS_MAX, SS_INIT);
               speedSlider.setMajorTickSpacing(1);
               speedSlider.setPaintTicks(true);
               speedSlider.setPaintLabels(true);
               speedSlider.setSnapToTicks(true);


              rangeSlider = new JSlider(JSlider.HORIZONTAL,
                                      RS_MIN, RS_MAX, RS_INIT);
               rangeSlider.setMajorTickSpacing(100);
               rangeSlider.setPaintTicks(true);
               rangeSlider.setPaintLabels(true);
               rangeSlider.setSnapToTicks(true);

               maxSlider = new JSlider(JSlider.HORIZONTAL,
                                       MS_MIN, MS_MAX, MS_INIT);
                maxSlider.setMajorTickSpacing(50);
                maxSlider.setPaintTicks(true);
                maxSlider.setPaintLabels(true);
                maxSlider.setSnapToTicks(true);


	         // add to buttonWrapper
	         buttonWrapper.add(startButton);
	         buttonWrapper.add(sortSelection);
              buttonWrapper.add(speedSlider);
              buttonWrapper.add(rangeSlider);
              buttonWrapper.add(maxSlider);

	         fullWrapper.add(buttonWrapper,BorderLayout.WEST);
	         fullWrapper.add(sorterWrapper,BorderLayout.CENTER);

	         add(fullWrapper);
	         setSize(230 + 80 + alength*2, aMax + 50);
	         setVisible(true);
              setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         setLocationRelativeTo(null);
              startButton.addActionListener(this);

              System.out.println(this.getSize());
         }

        public void actionPerformed(ActionEvent e) {
             if(running != true){
               new Thread() {
                    Thread thread = this;
                   public void run() {
                        running = true;
                             int[] arr =newArr(alength,aMax);
                             DemoSorterArray arrayNew = new DemoSorterArray(arr, aMax);
                             sorterWrapper.updateArray(arrayNew);
                             sorterWrapper.repaint();

                             String name = sortArray[sortSelection.getSelectedIndex()];

                             switch(name){
                                  case "Quick Sort":
                                        QuickSort quicksort = new QuickSort(thread,sorterWrapper);
                                        quicksort.sort();
                                        break;
                                   case "Insertion Sort":
                                        InsertionSort insertionsort = new InsertionSort(thread,sorterWrapper);
                                        insertionsort.sort();
                                        break;
                                   case "Merge Sort":
                                        MergeSort mergesort = new MergeSort(thread, sorterWrapper);
                                        mergesort.sort();
                                        break;
                                   case "Bubble Sort":
                                        BubbleSort bubblesort = new BubbleSort(thread, sorterWrapper);
                                        bubblesort.sort();
                                        break;
                                   default:
                                        BubbleSort sort = new BubbleSort(thread, sorterWrapper);
                                        sort.sort();
                                        break;
                              }

                              running = false;
                              System.out.println(name);
                              System.out.println(sorterWrapper.getArrayString());
                       }
                   }.start();

              }

       }

       public int[] newArr(int size, int range){
            Random r = new Random();
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i ++){
                 arr[i] = r.nextInt((range - 1) + 1) + 1;
            }
            return arr;
       }
}
