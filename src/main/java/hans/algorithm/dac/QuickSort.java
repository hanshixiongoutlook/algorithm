package hans.algorithm.dac;

import hans.algorithm.utils.Logger;
import hans.algorithm.utils.SortUtils;
import org.junit.Test;

public class QuickSort {


	@Test
	public void test() {
		Logger.log2Json("orginal={}", SortUtils.ARRAY);
		quickSort(SortUtils.ARRAY, 0, SortUtils.ARRAY.length-1);
		Logger.log2Json("sorted={}", SortUtils.ARRAY);

	}


	public void quickSort(int[] arr, int low, int high) {
		if (low>high) {
			return;
		}
		int pivot = merge(arr, low, high);
		Logger.log2Json("process={}", SortUtils.ARRAY);

		quickSort(arr, low, pivot-1);
		quickSort(arr, pivot+1, high);
	}

	public int merge(int[] arr, int low, int high) {
		int pivot = arr[low];
		int left = low;
		int right = high;

		// 6,3,1,9,4,5,7
		/*
		6,3,1,9,4,5,7
		6,3,1,5,4,9,7
		 */
		while (left<right) {
			while (arr[left]<=pivot && left<high) left++;
			while (arr[right]>pivot && low<right) right--;
			if (left<right)
				SortUtils.swap(arr, left, right);
		}
		arr[low] = arr[right];
		arr[right] = pivot;
		return right;
	}


}
