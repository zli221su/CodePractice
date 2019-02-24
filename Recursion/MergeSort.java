//Merge Sort
//
//Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.
//Examples
//{1} is sorted to {1}
//{1, 2, 3} is sorted to {1, 2, 3}
//{3, 2, 1} is sorted to {1, 2, 3}
//{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
//Corner Cases
//What if the given array is null? In this case, we do not need to do anything.
//What if the given array is of length zero? In this case, we do not need to do anything.


package Recursion;

public class MergeSort {
	public int[] mergeSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		mergeHelper(array, 0, array.length - 1);
		return array;
	}

	private void mergeHelper(int[] array, int left, int right) {
		// Base case
		if (left > right - 1) {
			return;
		}
		// Recursions
		int mid = (left + right) / 2;
		mergeHelper(array, left, mid);
		mergeHelper(array, mid + 1, right);
		// Operations in current level
		int i = left;
		int j = mid + 1;
		int[] helperArray = new int[right - left + 1];
		int helperIndex = 0;
		while (i <= mid || j <= right) {
			if (i > mid) {
				helperArray[helperIndex++] = array[j++];
			} else if (j > right) {
				helperArray[helperIndex++] = array[i++];
			} else {
				helperArray[helperIndex++] = array[i] < array[j] ? array[i++] : array[j++];
			}
		}
		for (int k = 0; k < helperArray.length; k++) {
			array[left + k] = helperArray[k];
		}
	}

	public static void main(String[] arg) {
		int[] array = new int[] {5,4,3,2,1};
		array = new MergeSort().mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d, ", array[i]);
		}
	}
}

//time complexity: O(log(n))
//space complexity: O(n)

