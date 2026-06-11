class TimeMap {

    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, x->new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> entries = timeMap.get(key);
        Map.Entry<Integer, String> entry = entries.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}