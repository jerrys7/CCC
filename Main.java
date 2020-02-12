import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.Map.Entry.comparingByKey;
import java.util.StringTokenizer;
import static java.util.stream.Collectors.toMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 571868
 */
public class Main {
    public static void  question1() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;
        String s;
        s = f.readLine();
        ArrayList <Integer> arrayList1 = new ArrayList();
        ArrayList <Integer> arrayList2 = new ArrayList(); 
        
//        ArrayList <Integer> arrayList3 = new ArrayList();
        while ( s!=null && s.length() > 0){
            st = new StringTokenizer(s);
                arrayList1.add(Integer.parseInt(st.nextToken()));
            if(st.hasMoreTokens()){
                arrayList2.add(Integer.parseInt(st.nextToken()));
            }
//            if (st.hasMoreTokens()){
//                arrayList3.add(Integer.parseInt(st.nextToken())); 
//            }          
            s = f.readLine();
        };
        int size = arrayList1.get(0);
        arrayList1.remove(0);
        //get the size

        Map <Integer, Integer> hm = new HashMap<Integer, Integer>();
        //put values into map
        for(int k = 0; k < size; k++){
            hm.put(arrayList1.get(k), arrayList2.get(k));
        }
        Map<Integer, Integer> sorted = hm .entrySet() .stream() .sorted(comparingByKey()) .collect( toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        Collections.sort(arrayList1);
        //find the list of indicies for indexes 
//        for(int k = 0; k < size; k++){
//            array
//        }
        
//        for (int n = 0; n < size; n++) {
//            for (int m = 0; m < size-1 - n; m++) {
//                if ((arrayList1.get(m).compareTo(arrayList1.get(m+1))) > 0) {
//    //                int swapTime = arrayList1.get(m);
//                    Collections.swap(arrayList1, m+1, m);
////                    System.out.println("3");
//    //                arrayList1.get(m) = arrayList1.get(m + 1);
//    //                arrayList1.get(m + 1) = swapString;
//                    Collections.swap(arrayList2, m+1,m);
////                    System.out.println("4");
//    //                arrayList2.get(m) = arrayList2.get(m + 1);
//    //                b[m + 1] = swapInt;
//                }
//            }
//        }
        double speed = 0.0;
        for(int k=0; k<size-1; k++){            
//            double time = arrayList.get(k+1)-arrayList
//            ArrayList <Integer> dab = new ArrayList();
//        for(int a = 0; a<2; a++){
//            Map.Entry<Integer,Integer> entry = sorted.entrySet().iterator().next();
//            dab.add(entry.getKey());
//            dab.add(entry.getValue());
//        }
            double newSpeed = Math.abs((double)(sorted.get(arrayList1.get(k+1))-sorted.get(arrayList1.get(k))))/(double)(arrayList1.get(k+1)-arrayList1.get(k));
            if(newSpeed > speed){
                speed=newSpeed;  
            }
        }
        
        
        System.out.println(speed);


        
    }
    
//    public static int getMin(ArrayList<Integer> time){ 
//        int minValue = time.get(0); 
//        for(int i=1;i<time.size();i++){ 
//          if(time.get(i) < minValue){ 
//            minValue = time.get(i); 
//          } 
//        } 
//        return minValue; 
//    } 

    
        public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//        String currentDirectory = System.getProperty("user.dir");
//        String fullFileName = currentDirectory + "/test.txt";
//
//        FileReader fr = new FileReader(fullFileName);
//        BufferedReader f = new BufferedReader(fr);
        StringTokenizer st;
        String s;
        s = f.readLine();
        ArrayList <Integer> jump = new ArrayList();
//        ArrayList <Integer> arrayList2 = new ArrayList(); 
        
//        ArrayList <Integer> arrayList3 = new ArrayList();
        while ( s!=null && s.length() > 0){
            st = new StringTokenizer(s);
                jump.add(Integer.parseInt(st.nextToken()));
            while(st.hasMoreTokens()){
                jump.add(Integer.parseInt(st.nextToken()));
            }      
            s = f.readLine();
        };
        //creating the matrix
        int r =jump.get(0);
        int c = jump.get(1);
//        int[][] matrix = new int[r][c];
    // make the array workable
        jump.remove(0);
        jump.remove(0);
        //final value i wish to achieve in reverse
        int finalValue = r*c;
//        int counter = 0;
//        Map <Integer, Integer> hm = new HashMap<Integer, Integer>();
        ArrayList <Integer> coordinate = new ArrayList();
        //make corresponding indexes to the values
       
        for(int k=0; k<r; k++){
            for(int j=0; j<c; j++){
                int v = (k+1)*(j+1);
                coordinate.add(v);
//                System.out.println(coordinate.get(counter));
//                hm.put(index, value.get(counter));
//                System.out.println(index+" " + value.get(counter));
//                counter++; 
            }
        }
        
        //traverse the arraylist for the values
        boolean exist = true;
        while(exist){
            int newIndex = jump.indexOf(finalValue);
            if(newIndex >= 0){
                finalValue = coordinate.get(newIndex);
                if(newIndex ==0){
                    System.out.println("yes");
                    return;
                }
            }else{
                System.out.println("no");
                exist = false;
                return;
            }   
        }
 
        
        
       
            


    }
        
     
    
}
