class Solution {
    private void findCombinations(List<List<Integer>> result, List<Integer> ds, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            ds.add(candidates[i]);
            findCombinations(result, ds, candidates, target-candidates[i], i+1);
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        findCombinations(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
}
