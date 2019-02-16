import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void Question1() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int[] tele = new int[4];
        StringTokenizer st;
        String s;
        s = f.readLine();
        int k = 0;
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            tele[k] = Integer.parseInt(st.nextToken());
            s = f.readLine();
            k++;
        };
        if (tele[0] == 8 || tele[0] == 9){
            if(tele[1] == tele[2]){
                if(tele[3] == 8 || tele[3] == 9){
                    System.out.println("ignore");
                }else{
                    System.out.println("answer");
                }
            }else{
                System.out.println("answer");
            }
        }else{
            System.out.println("answer");
        }
    }
    
    public static void Question2() throws IOException{

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;
        String s;
        s = f.readLine();
        ArrayList<String> first = new ArrayList();
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            first.add(st.nextToken());
            s = f.readLine();
        };
        first.remove(0);
        String one = first.get(0);
        String two = first.get(1);
        int occupied = 0;
        char c = 'c';
        for(int k = 0; k < one.length(); k++){
            if(one.charAt(k) == two.charAt(k) && one.charAt(k) == c){
                occupied++;
            }
        }
        
        
        System.out.println(occupied);
        f.close();
    }
    
    public static void Question3() throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
        
        StringTokenizer st;
        String s;
        s = f.readLine();
        int[] dist = new int[4];
        int k = 0;
        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            dist[k] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                k++;
                dist[k] = Integer.parseInt(st.nextToken());
            }
            
            s = f.readLine();
            
        }
        int[] pos = new int[5];
        pos[0] = 0;
        for(int m = 1; m < pos.length; m++){
            pos[m] = pos[m-1] + dist[m-1];
        }
        for(int a = 0; a < 5; a++){
            for(int b = 0; b < 5; b++){
                System.out.print(Math.abs(pos[a] - pos[b]) + " ");
            }
            System.out.println("");
        }
        f.close();
    }
    
    public static void rotateMatrix(int[][] matrix){
        if(matrix == null)
            return;
        if(matrix.length != matrix[0].length)//INVALID INPUT
            return;
        getTranspose(matrix);
        rorateAlongMidRow(matrix);      
     }

    public static void getTranspose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix.length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void rorateAlongMidRow(int[][] matrix) {
        int len = matrix.length ;
        for(int i = 0; i < len/2; i++){
            for(int j = 0;j < len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1 -i][j];
                matrix[len -1 -i][j] = temp;
            }
        }
    }
    
    public static boolean isSorted(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false; // It 
            }
        }
        
        return true;
    
    }
    
    public static int[] getColumn(int[][] array, int index){
        int[] column = new int[array[0].length]; 
        for(int i=0; i<column.length; i++){
           column[i] = array[i][index];
        }
        return column;
    }
    
    public static boolean matrixIsSorted(int[][] a){
        for(int k = 0; k < a[0].length; k++){
            if(isSorted(a[k])== false){
                return false;
            }
        } 
        return true;
    }
    public static int[][] Question4() throws IOException{
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
        
        int size = num.get(0);
        int[][] matrix = new int[size][size];
        num.remove(0);
        int k = 0;
        
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                matrix[row][col] = num.get(k);
                k++;
            }
        }
        int[][] temp = new int [size][size];
        int r = 0;
        for (int m = 0; m < 4; m++){
            temp = matrix;
            if(matrixIsSorted(matrix) && isSorted(getColumn(matrix, 0))){
                 return temp;
            }else{
                rotateMatrix(matrix);
                r++;
            }
        }
        while(matrixIsSorted(matrix) && isSorted(getColumn(matrix, 0)) == false){
            rotateMatrix(matrix);
        }
        
        return matrix;
        
    }
    public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }   
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
//        String currentDirectory = System.getProperty("user.dir");
//        String fullFileName = currentDirectory + "/text.txt";
//
//        FileReader fr = new FileReader(fullFileName);
//        BufferedReader f = new BufferedReader(fr);
        print(Question4());
        


        
    }
    
}
