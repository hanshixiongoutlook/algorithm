package hans.algorithm.dac;

import hans.algorithm.utils.Logger;
import org.junit.Test;

public class MergeSort {



	public void prime(int num) {

	}
	@Test
	public void test() {
		int[] arr = new int[]{1 ,9 ,8, 3, 4, 5, 6, 4};
		divide(arr, 0, arr.length-1);
		Logger.log2Json("result={}", arr);
	}



	// 1 9 8 3 2 5 6 4
	// 1 9 3 8 2 5 4 6

	public void divide(int[] arr, int low, int high) {
		if (high<=low) {
			return;
		}
		int middle = (high+low)/2;
		divide(arr, low, middle);
		divide(arr, middle+1, high);
		merge(arr, low, high);
	}

	public void merge(int[] arr, int low, int high) {
		int mid = (low+high)/2;
		int left = low;
		int right = mid+1;

		int[] tmp = new int[high-low+1];
		int index = 0;
		while (left<=mid && right<=high) {
			if (arr[left]<arr[right]) {
				tmp[index] = arr[left];
				left++;
			} else {
				tmp[index] = arr[right];
				right++;
			}
			index++;
		}
		while (left<=mid) {
			tmp[index] = arr[left];
			left++;
			index++;
		}
		while (right<=high) {
			tmp[index] = arr[right];
			right++;
			index++;
		}
		index=0;
		for (int i=low; i<=high; i++,index++) {
			arr[i] = tmp[index];
		}
		Logger.log2Json("tmp={}, low={}, high={}", arr, low, high);
	}
}
