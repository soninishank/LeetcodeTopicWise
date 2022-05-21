/*
package Coding.PriorityQueue.Design;

import java.util.*;

public class Twitter {
    HashMap<Integer, List<Integer>> userTweetMapping = new HashMap<>(); // 1 user can have multiple tweets
    HashMap<Integer, Set<Integer>> userFollowerMapping = new HashMap<>(); // 1 user can be followed by multiple users

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        userTweetMapping.putIfAbsent(userId, new LinkedList<>());
        userTweetMapping.get(userId).add(0, tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> resultTweets = new ArrayList<>();
        if (!userFollowerMapping.containsKey(userId) || userFollowerMapping.get(userId).size() <= 0) {
            return Collections.emptyList();
        }
        return null;
    }

    public void follow(int followerId, int followeeId) {
        userFollowerMapping.putIfAbsent(followeeId, new ArrayList<>());
        userFollowerMapping.get(followeeId).add(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        userFollowerMapping.putIfAbsent(followeeId, new ArrayList<>());
        userFollowerMapping.get(followeeId).remove(followerId);
    }
}
*/
