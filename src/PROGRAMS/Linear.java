package PROGRAMS;

public class Linear {
	
	public int linear(int[] arr, int element_to_search) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == element_to_search) {
				System.out.println(i);
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Linear linear = new Linear();
		linear.linear(new int []{3, 22, 27, 47, 57, 67, 89, 91, 95, 99}, 67);
		
	}

}
