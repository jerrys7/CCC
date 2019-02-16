
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class fileReading {
    
    public static void finiteOneLine() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int number = 5; // any number
        int[] array = new int[number]; 
        StringTokenizer st;
        String s;
        s = f.readLine();
        int k = 0;
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            array[k] = Integer.parseInt(st.nextToken());
            s = f.readLine();
            k++;
        };
    }
    
    public static void nLines() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
        ArrayList<Integer> num = new ArrayList();
        
        StringTokenizer st;
        String s;
        s = f.readLine();
        
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            num.add(Integer.parseInt((st.nextToken())));
            while(st.hasMoreTokens()){
                num.add(Integer.parseInt(st.nextToken()));
            }
            s = f.readLine();
        }
        
        int size = num.get(0); //use this to get n
        num.remove(0); //take inputs of everything, distribute however
    }
    
    public static void 2nLines() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
        ArrayList<Integer> num = new ArrayList();
        
        StringTokenizer st;
        String s;
        s = f.readLine();
        
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            num.add(Integer.parseInt((st.nextToken())));
            while(st.hasMoreTokens()){
                num.add(Integer.parseInt(st.nextToken()));
            }
            s = f.readLine();
        } 
    }
    
}
