package kmp;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class KMP {
private static int[] a;
public static void main(String[] args) throws IOException {
long initialTime = System.currentTimeMillis();
Scanner sc=new Scanner(System.in);
//System.out.println("Please enter the first string:");
char[] Target=new Scanner(new File("file path")).useDelimiter("\\Z").next().toCharArray();
//sc.next().toCharArray();
//System.out.println("Please enter the Pattern string:");
char[] Pattern=sc.next().toCharArray();
//"The Project Gutenberg EBook of The Complete Works of William Shakespeare, by William Shakespeare  This eBook is for the use of anyone anywhere at no cost and with".toCharArray(); //{'T','A','A','C','C','C','T','A','A','C'};
sc.close();
a = new int[Pattern.length];
nextTable(Pattern);
KMP(Target,Pattern);
long finalTime = System.currentTimeMillis();
long timeTaken = finalTime - initialTime;
System.out.println("\nTime taken = " + timeTaken);
}
private static void KMP(char[] Target, char[] Pattern) {
int n = Target.length;
int m = Pattern.length;
boolean found = false;
int i = 0, j = 0;
while( i < n){
if(Target[i] == Pattern[j]){
i++;
j++;
}
else if( j == 0 )
i++;
else
j = a[ j - 1 ] + 1;
if( j == m ){
j = 0;
System.out.println("Pattern found at index: "+(i-m));
found = true;
}
}
if(!found)
System.out.println("Pattern doesn't exist in Target");
}
private static void nextTable(char[] Pattern) {
int m = Pattern.length;
a[0] = -1;
int k;
for (int i = 1 ; i < m ; i++) {
k = a[ i - 1 ];
while ( k >= 0 && Pattern[ k+1 ] != Pattern[ i ]) {
k = a[ k ];
}
if ( Pattern[ k+1 ] == Pattern[ i ] )
a[ i ] = k+1 ;
else
a[ i ] = -1;
}
}
}
