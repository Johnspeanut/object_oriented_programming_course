package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javax.swing.tree.TreeNode;

public class main {

  public static void main(String[] args) {

    class Solution {
      public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        outer:for(int i = 0; i < nums.length; i++){
          if(i >= 1 && nums[i] == nums[i-1]){
            continue outer;
          }
          for(int j = i + 1; j < nums.length; j++)
            if(nums[j] - nums[i] == k){
              res++;
            }
        }
        return res;
      }
    }

String test = "aab";
    int[] nums1 = {1,2,4,4,3,3,0,9,2,3};
    int[] nums2 = {2,5,6};
    Solution solution = new Solution();
    int res = solution.findPairs(nums1,3);
//    for (int i = 0; i < nums1.length; i++) {
//      System.out.println(nums1[i]);
//
//    }
    System.out.println("result = "+ res);
  }

}



