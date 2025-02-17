class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int p1=0;
        int p2=0;
        while(p1<m && p2<n) {
            if (nums1[p1] == nums2[p2]) {
                result.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] > nums2[p2]){
                p2++;
            } else {
                p1++;
            }
        }
        int[] answer = new int[result.size()];
        for (int i=0;i<result.size();i++) {
            answer[i] = result.get(i);    
        }
        return answer;
    }
}


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int low=0;
        int high=n-1;
        int bindex=-1;
        for (int i=0;i<m;i++) {
            bindex = binarysearch(nums2, low, high, nums1[i]);
            if (bindex != -1) {
                result.add(nums1[i]);
                low = bindex+1;
            }
        }
        int[] answer = new int[result.size()];
        for (int i=0;i<result.size();i++) {
            answer[i] = result.get(i);    
        }
        return answer;
    }
    private int binarysearch(int[] nums, int low, int high, int target) {
        while (low <=high) {
            int mid= low + (high-low)/2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid-1] != target) {
                    return mid;
                }
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
