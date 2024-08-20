package com.Leetcode150Problems;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        //length of nums1 = m+n
        //muns2 length = n
        //creating a third array
//incrementing pointers and using the 3rd array for storing elements and copying back to nums1
        int[] nums1Copy = new int[m];
        for(int i = 0; i < m; i++){
            nums1Copy[i]=nums1[i];
        }
        int p1 = 0;
        int p2 = 0;

        for(int p = 0; p < m+n; p++){
            if(p2>=n || (p1 < m && nums1Copy[p1] < nums2[p2])){
                nums1[p] = nums1Copy[p1++];
            }
            else{
                nums1[p] = nums2[p2++];
            }
        }
    }
	//
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		 int p1 = m-1;
	     int p2 = n-1;
        for(int p = m+n -1; p >= 0; p--){
            if(p2 < 0){
                break;
            }
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1--];
            }
            else{
                nums1[p] = nums2[p2--];
               
            }
        }
	}
}
