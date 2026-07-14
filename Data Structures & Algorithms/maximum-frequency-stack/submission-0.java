class FreqStack {
    Map<Integer, Integer> count;
    List<Stack<Integer>> stacks;

    public FreqStack() {
        count = new HashMap<>();
        stacks = new ArrayList<>();
        stacks.add(new Stack<>());
    }
    
    public void push(int val) {
        count.merge(val, 1, Integer::sum);
        int freq = count.get(val);

        if (freq == stacks.size()) {
            stacks.add(new Stack<>());
        }
        stacks.get(freq).add(val);
    }
    
    public int pop() {
        Stack<Integer> topStack = stacks.get(stacks.size()-1);
        int result = topStack.pop();
        count.merge(result, -1, Integer::sum);
        if (topStack.isEmpty()) {
            stacks.remove(stacks.size()-1);
        }
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */