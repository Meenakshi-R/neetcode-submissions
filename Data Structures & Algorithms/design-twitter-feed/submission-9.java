static int timestamp = 0;
Map<Integer, User> usersMap;

class Tweet {
    Integer id;
    int time;
    Tweet next;

    public Tweet(Integer id) {
        this.id = id;
        this.time = timestamp++;
    }
}

class User {
    Integer id;
    Set<Integer> followers;
    Tweet tweet_head;

    public User (Integer id) {
        this.id = id;
        this.followers = new HashSet<>();
        follow(id);
        this.tweet_head = null;
    }    

    public Tweet postTweet(Integer tweetId) {
        Tweet tweet = new Tweet(tweetId);
        tweet.next = this.tweet_head;
        this.tweet_head = tweet;

        return tweet;
    }

    public void follow(Integer followeeId) {
        this.followers.add(followeeId);
    }

    public void unfollow(Integer followeeId) {
        if (followeeId != this.id) {
            this.followers.remove(followeeId);
        }
    }
}

class Twitter {

    public Twitter() {
        usersMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        User user;
        if (usersMap.containsKey(userId)) {
            user = usersMap.get(userId);
        }
        else {
            user = new User(userId);
            usersMap.put(userId, user);
        }
        user.postTweet(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feeds = new ArrayList<>();

        User user = usersMap.get(userId);
        if (user != null) {
            Set<Integer> followers = user.followers;
            PriorityQueue<Tweet> heap = new PriorityQueue<>((a,b) -> Integer.compare(b.time, a.time));

            for (Integer follower : followers) {
                Tweet tweet = usersMap.get(follower).tweet_head;
                if (tweet != null) {
                    heap.offer(tweet);
                }
            }

            while (!heap.isEmpty() && feeds.size() <10) {
                Tweet tweet = heap.poll();
                feeds.add(tweet.id);

                if (tweet.next != null) {
                    heap.offer(tweet.next);
                }
            }
        }
        return feeds;
    }
    
    public void follow(int followerId, int followeeId) {
        usersMap.putIfAbsent(followerId, new User(followerId));
        usersMap.putIfAbsent(followeeId, new User(followeeId));

        usersMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!usersMap.containsKey(followerId) || !usersMap.containsKey(followeeId)) {
            return ;
        }
        usersMap.get(followerId).unfollow(followeeId);
    }
}
