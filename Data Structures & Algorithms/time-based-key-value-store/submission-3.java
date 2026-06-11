class TimeMap {
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x->new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> timeStamps = map.get(key);
        Map.Entry<Integer, String> entry = timeStamps.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}