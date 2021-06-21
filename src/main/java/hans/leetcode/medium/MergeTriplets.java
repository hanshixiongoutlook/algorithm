package hans.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeTriplets {


	@Test
	public void test() {
		int[][] triplets = new int[][]{{2,5,3},{2,3,4},{1,6,5},{5,2,3}};
		int[] target = new int[]{5,5,5};

		Assert.assertTrue("错误", this.mergeTriplets(triplets, target));


	}

	/**
	 * https://leetcode-cn.com/problems/merge-triplets-to-form-target-triplet/submissions/
	 * @param triplets
	 * @param target
	 * @return
	 */
	public boolean mergeTriplets(int[][] triplets, int[] target) {
		List<int[]> first = new ArrayList<>();
		List<int[]> second = new ArrayList<>();
		List<int[]> third = new ArrayList<>();
		for (int i=0; i<triplets.length; i++) {
			int[] tripelt = triplets[i];
			if (tripelt[0]==target[0]&&tripelt[1]<=target[1]&&tripelt[2]<=target[2]) {
				first.add(tripelt);
			}
			if (tripelt[1]==target[1]&&tripelt[0]<=target[0]&&tripelt[2]<=target[2]) {
				second.add(tripelt);
			}
			if (tripelt[2]==target[2]&&tripelt[0]<=target[0]&&tripelt[1]<=target[1]) {
				third.add(tripelt);
			}
		}
		return first.size()>0&&second.size()>0&&third.size()>0;
	}
}
