
import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
      
    public static void question1() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int number; // any number

                StringTokenizer st;
        String s;
        s = f.readLine();
        String t = "";
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            t=st.nextToken();
            s = f.readLine();
        }
//        System.out.println(t);
//        System.out.println(t.length());
        int[][] array = {{1, 2},{3, 4}}; 
        int length = t.length();
        for(int k=0; k < length; k++){
            if(t.substring(k,k+1).equals("H")){
//                System.out.println("H");
                hFlip(array);
//            for(int l = 0; l <2; l++){
//                for(int j = 0; j < 2; j++){
//                    System.out.print(array[l][j] + " ");
//                }
//                System.out.println("");
//            }                
            }else if(t.substring(k,k+1).equals("V")){
//                System.out.println("V");
                vFlip(array);
//                for(int l = 0; l <2; l++){
//            for(int j = 0; j < 2; j++){
//                System.out.print(array[l][j] + " ");
//            }
//            System.out.println("");
//        }
            }
        }
        
        for(int k = 0; k <2; k++){
            for(int j = 0; j < 2; j++){
                System.out.print(array[k][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void vFlip(int[][] imgArray){
  
        int temp;
        for (int i = 0; i < imgArray.length; i++) {
            for (int j = 0; j < imgArray[i].length / 2; j++) {
                temp = imgArray[i][j];
                imgArray[i][j] = imgArray[i][imgArray.length - 1 - j];
                imgArray[i][imgArray.length - 1 -j] = temp;
            }
        }
        
    }
    public static void hFlip(int [][] imgArray){
        int temp;
        for (int i = 0; i < imgArray.length / 2; i++) {
            for (int j = 0; j < imgArray[i].length; j++) {
                temp = imgArray[i][j];
                imgArray[i][j] = imgArray[imgArray.length - 1 - i][j];
                imgArray[imgArray.length - 1 -i][j] = temp;
            }
        }
    }
    public static boolean isPrime(int n){
        if(n < 2) return false;
    if(n == 2 || n == 3) return true;
    if(n%2 == 0 || n%3 == 0) return false;
    long sqrtN = (long)Math.sqrt(n)+1;
    for(long i = 6L; i <= sqrtN; i += 6) {
        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
    }
    return true;
//        if(n % 2 == 0 || n % 3 == 0){
//            return false;
//        }
//        int i =5;
//        while(i *i <=n){
//            if (n % i == 0 || n %(i+2) ==0){
//                return false;
//            }
//            i = i +6;
//        }
//        return true;
//        boolean flag = true;
//        for(int i = 2; i <= k/2; i++){
//            // condition for nonprime number
//            if(k % i == 0){
//                flag = false;
//                break;
//            }
//        }
//        return flag;
    }
    public static void question2() throws IOException{
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
        int avg = 0;
        
        for(int k =0; k < size; k++){
            int distance = num.get(k)%2+1;
            while (avg != num.get(k)){
                int small = num.get(k) - distance;
                int large = num.get(k) + distance;
                if(isPrime(small)){
                    if(isPrime(large)){
                        System.out.println(large + " " + small);
                        break;
                    }
                }
                distance= distance +2;
            }
        }
        
    }
    public static double[] getColumn(double[][] array, int index){
        double[] column = new double[array[0].length]; 
        for(int i=0; i<column.length; i++){
           column[i] = array[i][index];
        }
        return column;
    }
    
    public static int numX(double[] r){
        int count = 0;
        for(int k = 0; k <3; k++){
            if(r[k] == (0.1)){
                count++;
            }
        }
        return count;
    }
    
    public static int[] calculate1(double[] array){
        
        int index = Arrays.asList(array).indexOf(0.1);
        int[] arr = new int[3];
        if(index == 0){
            arr[index] = (int) (2 * Math.round((array[1])) + Math.round(array[2]));
        }else if (index == 1){
            arr[index] = (int) ((Math.round(array[0]) + Math.round(array[2]))/2);
        }else if(index == 2){
            arr[index] = (int) (2 * Math.round(array[1]) - Math.round(array[0]));
        }
        return arr;
        
    }
    
    public static void question3() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
        ArrayList<String> num = new ArrayList();
        
        StringTokenizer st;
        String s;
        s = f.readLine();
        
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            num.add(st.nextToken());
            while(st.hasMoreTokens()){
                num.add(st.nextToken());
            }
            s = f.readLine();
        }
        
        double[][] square = new double[3][3];
        int j =0;
        for(int k = 0; k < 3; k++){
            for(int i = 0; i < 3; i++){
                if(num.get(j).equals("X")){
                    square[k][i] = 0.1;
                }else{
                    square[k][i] = Double.parseDouble(num.get(j));
                }                
            }
        }
        //check all rows first;
        int[][] nrime = new int[3][3];
        for(int k = 0 ; k < 3; k++){
            if(numX(square[k])==1){
                nrime[k] = calculate1(square[k]);
            }
        }
        
        //check all columns 
        for(int k = 0 ; k < 3; k++){
            if(numX(getColumn(square, k))==1){
                for(int b = 0; b < 3; b++){
                    nrime[b][k] = calculate1(square[k])[b];
                }
            }
        }        
        
        System.out.println(nrime); 
        
    }
    
        public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }   
    }
        
    public static void main(String[] args) throws IOException {
//        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/test.txt";

        FileReader fr = new FileReader(fullFileName);
        BufferedReader f = new BufferedReader(fr);
        
        ArrayList<String> num = new ArrayList();
        
        StringTokenizer st;
        String s;
        s = f.readLine();
        
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            num.add(st.nextToken());
            while(st.hasMoreTokens()){
                num.add(st.nextToken());
            }
            s = f.readLine();
        }
        
        double[][] square = new double[3][3];
        int j =0;
        for(int k = 0; k < 3; k++){
            for(int i = 0; i < 3; i++){
                if(num.get(j).equals("X")){
                    square[k][i] = 0.1;
                }else{
                    square[k][i] = Double.parseDouble(num.get(j));
                }  
                j++;
            }
        }
        //check all rows first;
        int[][] nrime = new int[3][3];
        for(int k = 0 ; k < 3; k++){
            if(numX(square[k])==1){
                nrime[k] = calculate1(square[k]);
            }
        }
        
        //check all columns 
        for(int k = 0 ; k < 3; k++){
            if(numX(getColumn(square, k))==1){
                for(int b = 0; b < 3; b++){
                    nrime[b][k] = calculate1(square[k])[b];
                }
            }
        }        
        
        print(nrime);
    }
}
