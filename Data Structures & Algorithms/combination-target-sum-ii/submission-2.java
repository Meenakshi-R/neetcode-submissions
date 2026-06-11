class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> ds) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            if (i>index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            ds.add(candidates[i]);
            dfs(candidates, target-candidates[i], i+1, ds);
            ds.remove(ds.size()-1);
        }
    }
}
