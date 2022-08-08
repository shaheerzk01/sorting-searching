package PROGRAMS;

public class Jump {
	
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
		Jump jump = new Jump();
		int result = jump.jump_search(new int []{3, 22, 27, 47, 57, 67, 89, 91, 95, 99}, 67);
		System.out.println(result);
		
	}

}
