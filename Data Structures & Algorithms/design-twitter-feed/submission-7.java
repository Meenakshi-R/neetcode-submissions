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
        }
    }

    class User {
        int id;
        Tweet top_tweet;
        Set<Integer> followed;

        public User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
            this.top_tweet = null;
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = this.top_tweet;
            this.top_tweet = tweet;
        }

        public void follow(int id) {
            this.followed.add(id);
        }

        public void unfollow(int id) {
            if (id != this.id) {
               this.followed.remove(id);
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
        User user = userMap.get(userId);
        user.post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        User user = userMap.get(userId);
        if (user != null) {
            Set<Integer> followed = user.followed;
            PriorityQueue<Tweet> queue = new PriorityQueue<>((a,b) -> Integer.compare(b.time, a.time));

            for (Integer followee : followed) {
                Tweet tweet = userMap.get(followee).top_tweet;
                if (tweet != null) {
                    queue.offer(tweet);
                }
            }
            while (!queue.isEmpty() && feed.size() < 10) {
                Tweet tweet = queue.poll();
                if (tweet.next != null) {
                    queue.offer(tweet.next);
                }
                feed.add(tweet.id);
            }
        }
        return feed;
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
        userMap.get(followerId).unfollow(followeeId);
    }
}
