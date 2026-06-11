class Twitter {
    Map<Integer, User> userMap;
    static int timeStamp = 0;

    class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
            tweetHead = null;
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = this.tweetHead;
            this.tweetHead = t;
        }

        public void follow(int id) {
            this.followed.add(id);
        }

        public void unfollow(int followeeId) {
            if (id != followeeId) {
              this.followed.remove(followeeId);
            }
        }
    }

    public Twitter() {
        userMap = new HashMap();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }
        Set<Integer> followees = userMap.get(userId).followed;
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        for (int followee : followees) {
            Tweet tweet = userMap.get(followee).tweetHead;
            if (tweet != null) {
               queue.offer(tweet);
            }
        }
        while (!queue.isEmpty() && result.size() < 10) {
            Tweet tweet = queue.poll();
            result.add(tweet.id);
            if (tweet.next != null) {
                queue.offer(tweet.next);
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId); 
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return ;
        }
        User user = userMap.get(followerId);
        user.unfollow(followeeId);
    }
}
