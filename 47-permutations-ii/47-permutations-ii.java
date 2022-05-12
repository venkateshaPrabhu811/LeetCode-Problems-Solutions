class Solution {
    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        helper(new ArrayList<>(), nums, new boolean[nums.length]);
        return permutations;
    }
    private void helper(List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length)
            permutations.add(new ArrayList<>(current));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
                current.add(nums[i]);
                used[i] = true;
                helper(current, nums, used);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}