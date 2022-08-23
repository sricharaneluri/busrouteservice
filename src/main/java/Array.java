import java.util.ArrayList;
import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4};
		int arr1[] = {4,2,6,7,8};
		
		Arrays.sort(arr1);
		System.out.println("array sorted: " +arr1);
		
		ArrayList<Integer> list3 = new ArrayList<>();
		for(int a=0;a<arr1.length;a++) {
			list3.add(arr1[a]);
		}
		
		System.out.println(list3);
		
		
		ArrayList<Integer> list = new ArrayList<>();
//		list = Arrays.asList({1,2,3,4});
		
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
		}
		
		for(int j=0;j<arr1.length;j++) {
			list.add(arr1[j]);
		}
		
		System.out.println(list);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		
		for(Integer k : list) {
			if(!list2.contains(k)) {
				list2.add(k);
			}
			
		}
		
		System.out.println(list2);

	}

}
