package sorting;

public class Select_sort {
	
	public void selection_sort(int arr[]) {
		int pos;
		int temp;
		for(int i=0; i<arr.length; i++) {
			pos = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[pos]) { //find the index of the minimum element
					pos = j;
				}
			}
			temp = arr[pos];  //swap the current element with the minimum element
			arr[pos] = arr[i];
			arr[i] = temp;
		}
	}
	public void display(int arr[]) {
		for (int i=0; i<arr.length; ++i) {
			System.out.print(arr[i]+" "); 
		}
	}
	public static void main(String args[]) {
		Select_sort ob = new Select_sort();
		int arr[] = {64,25,12,22,11}; 
		ob.selection_sort(arr); 
		ob.display(arr);
	}

}
