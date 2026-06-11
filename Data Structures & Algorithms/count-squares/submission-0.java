class CountSquares {
    private Map<List<Integer>, Integer> count;
    private List<List<Integer>> points;

    public CountSquares() {
        count = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int px = point[0], py = point[1];
        List<Integer> pt = List.of(px, py);

        count.put(pt, count.getOrDefault(pt,0)+1);
        points.add(pt);
    }
    
    public int count(int[] point) {
        int result = 0;
        int px = point[0], py = point[1];
        for (List<Integer> pt : points) {
            int x = pt.get(0), y = pt.get(1);

            if (Math.abs(px - x) != Math.abs(py-y) || x==px || y==py) {
                continue;
            }
            result += count.getOrDefault(List.of(x, py), 0) * 
                      count.getOrDefault(List.of(px, y), 0);
        }
        return result;
    }
}
