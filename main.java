import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
//create matrix
    MyMatrix matrix = new MyMatrix(3);
    
    matrix.echelon();

    matrix.check();
    
    matrix.redEchelon();
    
  }
  
}
