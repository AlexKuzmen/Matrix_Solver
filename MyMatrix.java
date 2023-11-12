import java.util.*;

public class MyMatrix{

  private double[][] matrix;
  private double[] doub;
  int row;

  public MyMatrix(int r){
    matrix = new double[r][r+1];
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Matrix rows " + r + ". Input ");
    for(int t = 0; t < r; t++){
      System.out.print("int, ");
    }
    System.out.println("result");

    for(int i = 0; i < matrix.length; i++){
      doub = new double[matrix[0].length];
      System.out.print("Row [" + i + "]: ");
      String abc = keyboard.nextLine();
      String[] abcd = abc.split(",");
      for(int a = 0; a < abcd.length; a++){
        doub[a] = Double.parseDouble(abcd[a]);
      }
      matrix[i] = doub;
    }
    row = r;
  }

  public double mult(int r, int c){
    if(matrix[r][c]==0){
      return 0.0;
    }
    else{
      return 1/matrix[r][c];
    }
  }//find multiple to get 1 at specified row and column

  public void simpRow(int r, int c){//create a 1 at specified r and c (changes entire c's)

    double m = this.mult(r,c);

    for(int i = 0; i < row+1; i++){
      matrix[r][i] = matrix[r][i]*m;
    }

  }//multiply row by mult

  public void setRow(int r2, int r1, int c){//multiplies r1 by r2 c value
    for(int i = 0; i < row+1; i++){
      matrix[r1][i] = matrix[r1][i]*matrix[r2][c];
    }
  }

  public void subRow(int r2, int r1, int c){//replace r2 with substraction of r1-r2
    this.simpRow(r1,c);//simplify r1 to get 1 at c value
    this.setRow(r2,r1,c); //now r1 has same c value as r2

    if(matrix[r2][c]==matrix[r1][c]){
      for(int i = 0; i < row+1; i++){
        matrix[r2][i] = matrix[r1][i]-matrix[r2][i];
      }
    }else{
      for(int i = 0; i < row+1; i++){
        matrix[r2][i] = matrix[r1][i]+matrix[r2][i];
      }
    }

  }//end subRow
  
  public void echelon(){//method to find solution! row = row #'s
//EXAMPLE:    this.subRow(1,0,0);//I want to change row 1 with row 0 at column 0
    System.out.print("Echelon:");
    for(int r = 0; r < row-1; r++){//change 0 to 1?
//column is equal to row?
      for(int t = r+1; t <row; t++){
        this.subRow(t, r, r);
      }
    }
    this.print();
//figure out how to know how many times you need to swap rows to get 0s at indicated positions?
//maybe cycle throught a single column in every row after setting the first row to 1
//Then, cycle through while going down to the next row to set its next index to 1 and substract and so on
// this will not form a reduced echelon, create that method below
//this should only return a half complete echelon
//to create fully reduced echelon complete the other half by thinking of it as being flipped and the start of this echelon!
  }//end echelon





  public void redEchelon(){
    System.out.print("\nReduced Echelon:");

    for(int r = row-1; r>0; r--){
      for(int t = r-1; t>-1;t--){
        this.subRow(t,r,r);
      }
    }
    for(int i = 0; i < row; i++){
      this.simpRow(i,i);
    }
    this.print();
  }

  public void check(){
    int check = 0;
    for(int r = 0; r < row;r++){
      check = 0;
      for(int c = 0; c < row;c++){
        if(matrix[r][c]==0){
          check++;
        }
      }
      if(!(matrix[r][row]==0)&&(check == row)){
        System.out.println("\nRow[" + r + "] shows there are no solutions.");
      }else if((matrix[r][row]==0)&&(check == row)){
        System.out.println("\nRow[" + r + "] shows there MAY be infinite solitions.");
      }
    }
  }

  
  public void print(){

    for(int i = 0; i < row; i++){
        System.out.println("");
      for(int c = 0; c < row+1; c++){

        if(!(c==row)){
          System.out.print(matrix[i][c] + " ");
        }
        else{
          System.out.print("| " + matrix[i][c]);
        }
      }
      
    }
  }//end print
  
}//end myMatric.java
