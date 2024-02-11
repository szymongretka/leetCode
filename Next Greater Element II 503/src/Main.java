import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{4,1,2};
//        int[] nums2 = new int[]{1,3,4,2};
//        int[] result = nextGreaterElement(nums1, nums2);
//        System.out.println("Result: " + Arrays.toString(result));

        int[] nums = new int[]{1, 2, 1};
        int[] result = nextGreaterElements(nums);
        System.out.println("Result: " + Arrays.toString(result));
    }

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Map<Integer, Integer> nextGreaterElementMap = new HashMap<>();
        Deque<Integer> monotonicStack = new ArrayDeque<>(nums2.length); //stack with indexes

        for (int i = nums2.length - 1; i >= 0; i--) { //we don't have to initialize stack - last element is always -1 (nothing is next)
            while (!monotonicStack.isEmpty() && nums2[i] > nums2[monotonicStack.peek()]) {
                monotonicStack.pop();
            }

            if (monotonicStack.isEmpty()) {
                nextGreaterElementMap.put(nums2[i], -1);
            } else {
                nextGreaterElementMap.put(nums2[i], nums2[monotonicStack.peek()]);
            }

            monotonicStack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterElementMap.get(nums1[i]);
        }

        return result;
    }

    static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Deque<Integer> monotonicStack = new ArrayDeque<>(n); //stack with indexes

        for (int i = 0; i < nums.length; i++) {
            
            while (!monotonicStack.isEmpty() && nums[i] > nums[monotonicStack.peek()]) {

            }

        }

        return result;
    }

}