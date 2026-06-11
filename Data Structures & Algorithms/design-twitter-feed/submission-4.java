class Twitter {

    private static int timeStamp = 0;
    private Map<Integer, User> userMap;

    private class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id=id;
            time = timeStamp++;
            next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }

        public void follow(int followeeId) {
            this.followed.add(followeeId);
        }

        public void unfollow(int followeeId) {
            if (id != followeeId) {
                this.followed.remove(followeeId);
            }
        }

    }

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new LinkedList<>();

        if (!userMap.containsKey(userId)) {
            return newsFeed;
        }
        Set<Integer> followed = userMap.get(userId).followed;
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>((a,b) -> (b.time-a.time));

        for (int follower : followed) {
            Tweet tweet = userMap.get(follower).tweet_head;
            if (tweet != null) {
                queue.add(tweet);
            }
        }
        int count = 0;
        while (!queue.isEmpty() && count < 10) {
            Tweet tweet = queue.poll();
            newsFeed.add(tweet.id);
            count++;
            if (tweet.next != null) {
                queue.add(tweet.next);
            }
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
              User user = new User(followerId);
              userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
              User user = new User(followeeId);
              userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}
