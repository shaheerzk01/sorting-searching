package PROGRAMS;

import java.util.Scanner;

public class Searching {
	
    public int binary(int[] arr, int element_to_search) {
		
		int firstindex = 0;
		int lastindex = arr.length ;
		
		// termination condition (element isn't present)
		while(firstindex <= lastindex) {
			int middleindex = firstindex + (lastindex - firstindex) / 2;
			// if the middle element is our goal element, return its index
			if(arr[middleindex] == element_to_search) {
				return middleindex;
			}
			// if the middle element is smaller
		    // point our index to the middle+1, taking the first half out of consideration
			else if(arr[middleindex] < element_to_search) {
				firstindex = middleindex + 1;
			}
			// if the middle element is bigger
	        // point our index to the middle-1, taking the second half out of consideration
			else if(arr[middleindex] > element_to_search) {
				lastindex = middleindex -1;
			}
		}
		
		return -1;
	}
    
    public int fibonacci(int[] arr, int element_to_search) {
		int fibonacciMinus2 = 0;
		int fibonacciMinus1 = 1;
		int fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
		int array_length = arr.length;
		while(fibonacciNumber < array_length) {
			fibonacciMinus2 = fibonacciMinus1;
			fibonacciMinus1 = fibonacciNumber;
	        fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
		}
		int offset = -1;
		while(fibonacciNumber > 1) {
			int i = Math.min(offset+fibonacciMinus2, array_length-1);
			
			if(arr[i] < element_to_search) {
				fibonacciNumber = fibonacciMinus1;
	            fibonacciMinus1 = fibonacciMinus2;
	            fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
	            offset = i;
			}
			else if (arr[i] > element_to_search) {
	            fibonacciNumber = fibonacciMinus2;
	            fibonacciMinus1 = fibonacciMinus1 - fibonacciMinus2;
	            fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
	        }
			else {
				return i;
			}
		}
		if (fibonacciMinus1 == 1 && arr[offset+1] == element_to_search) {
			return offset+1;
		}    
	    return -1;
	}
    
    

    public int jump_search(int[] arr, int element_to_search) {
		int array_length = arr.length;
		int jump_step = (int) Math.sqrt(array_length);
		int previous_step = 0;
		
		while(arr[Math.min(jump_step, array_length) - 1] < element_to_search) {
			previous_step = jump_step;
			jump_step += (int) (Math.sqrt(array_length));
			if(previous_step >= array_length) {
				return -1;
			}
		}
		while(arr[previous_step] < element_to_search) {
			previous_step++;
			if(previous_step == Math.min(jump_step, array_length)) {
				return -1;
			}
		}
		
		if(arr[previous_step] == element_to_search) {
			return previous_step;
		}
		return -1;
	}
    
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Press 1 for Binary search\nPress 2 for fibonacci Search\n"
				+ "Press 3 for jump search");
    	int x = input.nextInt();
		switch(x) {
		case 1:
			long start = System.currentTimeMillis();
			Searching binary = new Searching();
			System.out.println("Enter number to search");
			int h = input.nextInt();
			int[] a = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
			int result = binary.binary(a, h);
			System.out.print("[");
			for(int i=0; i<a.length; i++) {
				System.out.print(" " + a[i]);
			}
			System.out.println(" ]");
			String k = null;
			boolean c = false;
			for(int j=0; j<a.length; j++) {
				if(h==a[j]) {
					System.out.println("\n" + h + " found at index number " + result);
					c = true;
				}else {
					 k = "element not present";
		
				}
			}
			if(c==false) {
				System.out.println(k);
			}
			long end = System.currentTimeMillis();
			long execution = end - start;
		    System.out.println("Execution time: " + execution + " miliseconds ");
			break;
		case 2:
			long start3 = System.currentTimeMillis();
			Searching jump = new Searching();
			System.out.println("Enter number to search");
			int p = input.nextInt();
			int[] q = {3, 22, 27, 47, 57, 67, 89, 91, 95, 99};
			int result3 = jump.jump_search(q, p);
			System.out.print("[");
			for(int i=0; i<q.length; i++) {
				System.out.print(" " + q[i]);
			}
			System.out.println(" ]");
			String u = null;
			boolean m = false;
			for(int j=0; j<q.length; j++) {
				if(p==q[j]) {
					System.out.println("\n" + p + " found at index number " + result3);
					m = true;
				}else if (p!=q[j]) {
					 u = "element not present";
					 
				}
			}
			if(m==false) {
				System.out.println(u);
			}
			long end3 = System.currentTimeMillis();
			long execution3 = end3 - start3;
		    System.out.println("Execution time: " + execution3 + " miliseconds ");
			break;
		case 7:
			long start6 = System.currentTimeMillis();
			Searching fibonacci = new Searching();
			System.out.println("Enter number to search");
			int s1 = input.nextInt();
			int[] f1 = {3, 22, 27, 47, 57, 67, 89, 91, 95, 99};
			int result6 = fibonacci.fibonacci(f1, s1);
			System.out.print("[");
			for(int i=0; i<f1.length; i++) {
				System.out.print(" " + f1[i]);
			}
			System.out.println(" ]");
			String d1 = null;
			boolean q1 = false;
			for(int j=0; j<f1.length; j++) {
				if(s1==f1[j]) {
					System.out.println("\n" + s1 + " found at index number " + result6);
					q1 = true;
				}else if (s1!=f1[j]) {
					 d1 = "element not present";
					 
				}
			}
			if(q1==false) {
				System.out.println(d1);
			}
			long end6 = System.currentTimeMillis();
			long execution6 = end6 - start6;
		    System.out.println("Execution time: " + execution6 + " miliseconds ");
			break;
		}
    }


}
