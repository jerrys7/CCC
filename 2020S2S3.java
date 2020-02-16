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

public class Main {
    public static void  question1() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;
        String s;
        s = f.readLine();
        ArrayList <Integer> arrayList1 = new ArrayList();
        ArrayList <Integer> arrayList2 = new ArrayList(); 
        
        while ( s!=null && s.length() > 0){
            st = new StringTokenizer(s);
                arrayList1.add(Integer.parseInt(st.nextToken()));
            if(st.hasMoreTokens()){
                arrayList2.add(Integer.parseInt(st.nextToken()));
            }     
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
        
        double speed = 0.0;
        for(int k=0; k<size-1; k++){            
            double newSpeed = Math.abs((double)(sorted.get(arrayList1.get(k+1))-sorted.get(arrayList1.get(k))))/(double)(arrayList1.get(k+1)-arrayList1.get(k));
            if(newSpeed > speed){
                speed=newSpeed;  
            }
        }
        
        
        System.out.println(speed);


        
    }
    
    public static void question2() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s;
        s = f.readLine();
                ArrayList <Integer> jump = new ArrayList();
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

        jump.remove(0);
        jump.remove(0);
        //final value i wish to achieve in reverse
        int finalValue = r*c;

        ArrayList <Integer> coordinate = new ArrayList();
        //make corresponding indexes to the value
        for(int k=0; k<r; k++){
            for(int j=0; j<c; j++){
                int v = (k+1)*(j+1);
                coordinate.add(v);
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
        public static boolean arePermutation(String string1, String string2){  
 
            int l1 = string1.length();  
            int l2 = string2.length();  


            if (l1 != l2)  
            return false;  
            char char1[] = string1.toCharArray(); 
            char char2[] = string2.toCharArray(); 

            Arrays.sort(char1);  
            Arrays.sort(char2);  

            for (int i = 0; i < l1; i++)  
            if (char1[i] != char2[i])  
                return false;  

            return true;  
        }         
    
        public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> num = new ArrayList();
        StringTokenizer st;
        String s;
        s = f.readLine();
        
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            num.add((st.nextToken()));
            while(st.hasMoreTokens()){
                num.add(st.nextToken());
            }
            s = f.readLine();
        }
        
        int count =0;
        String sub = num.get(0);
        int s1 = sub.length();
        String master = num.get(1);
        ArrayList<String> permutes = new ArrayList();
        for(int k = 0; k < master.length()-s1+1; k++){
            if(arePermutation(master.substring(k, k+s1), sub) && permutes.contains(master.substring(k, k+s1))==false){
                permutes.add(master.substring(k, k+s1));
                count++;
            }
                
        }
        System.out.println(count);
    }
        
     
    
}
