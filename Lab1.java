   import java.util.*;

class Lab1 
{
   public static final int NUMITEMS = 18;
   
   public static void main(String[] args)  {
  	   Scanner scanner = new Scanner(System.in);
  	   int[] holes = new int[NUMITEMS];
  	   for(int i = 0; i < holes.length; i++) {
     	   System.out.print("#" + (i + 1) + ": ");
     	   holes[i] = scanner.nextInt();
  	   }
  	   System.out.println("Sum: " + sum(holes));
  	   System.out.println("Average: " + avg(holes));
  	   System.out.println("Minimum: " + min(holes));
  	   System.out.println("Maximum: " + max(holes));
  	   System.out.println("Number of Holes in One: " + ones(holes));
   }
   
   public static int sum(int[] array) {
  	   int sum = 0;
  	   for(int i = 0; i < array.length; i++){
     	sum += array[i];
  	   }
  	   return sum;
   }
   
   public static double avg(int[] array) {
  	   double avg = sum(array) / 18.0;
  	   return avg;
   }
   
   public static int min(int[] array){
  	   int min = array[0];
  	   for(int i = 0; i < array.length; i++){
     	   if(array[i] < min){
           	min = array[i];
     	   }
  	   }
  	   return min;
   }
   
   public static int max(int[] array){
     	int max = array[0];
     	for(int i = 0; i < array.length; i++) {
     	   if(array[i] > max)
     	{
        	max = array[i];
     	}
  	   }
   	return max;
   }
   
   public static int ones(int[] array){
  	   int count = 0;
  	   for(int i = 0; i < array.length; i++){
        	if(array[i] == 1){
           	count++;
     	   }
  	   }
  	   return count;
      }
   }
}