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
