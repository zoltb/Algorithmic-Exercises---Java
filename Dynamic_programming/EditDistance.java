import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here

    int sLength = s.length();
    int tLength = t.length();

    char[] sCharArray = s.toCharArray();
    char[] tCharArray = t.toCharArray();

    int[][] matrix = new int [sLength+1][tLength+1];

    if (sLength == 0)
      return tLength;
    if (tLength ==0)
      return sLength;


    for (int i = 0; i <= sLength; i++) {
      for (int j = 0; j <= tLength; j++) {
        if (i == 0) {
          matrix[i][j] = j;
        }
        else if (j == 0) {
          matrix[i][j] = i;
        }
        else if(sCharArray[i-1] == tCharArray[j-1]){
          matrix[i][j] = Math.min(Math.min((matrix[i][j-1])+1, (matrix[i-1][j])+1), matrix[i-1][j-1]);
        }
        else {
          matrix[i][j]  = Math.min(Math.min((matrix[i][j-1])+1, (matrix[i-1][j])+1), (matrix[i-1][j-1])+1);
        }
      }
    }
    return matrix[sLength][tLength];
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
