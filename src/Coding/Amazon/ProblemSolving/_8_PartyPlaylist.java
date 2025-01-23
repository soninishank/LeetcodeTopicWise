package Coding.Amazon.ProblemSolving;

import java.util.*;

public class _8_PartyPlaylist {

    // Song -> Count of likes
    private final Map<String, Integer> songLikes = new HashMap<>();
    // User -> Songs they like
    private final Map<String, Set<String>> userSongs = new HashMap<>();
    // Max-heap for most liked songs
    private final PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    private final Set<String> playedSongs = new HashSet<>();


    // Add user's liked songs
    public void addUser(String userId, List<String> songs) {
        userSongs.putIfAbsent(userId, new HashSet<>());
        Set<String> userSongSet = userSongs.get(userId);
        for (String song : songs) {
            if (!userSongSet.contains(song)) {  // Only count if it's a new song for this user
                songLikes.put(song, songLikes.getOrDefault(song, 0) + 1);
                userSongSet.add(song);
            }
        }
        rebuildHeap();
    }

    // Remove user's liked songs
    public void removeUser(String userId) {
        if (!userSongs.containsKey(userId)) return;

        for (String song : userSongs.get(userId)) {
            songLikes.put(song, songLikes.get(song) - 1);
            if (songLikes.get(song) == 0) {
                songLikes.remove(song);
            }
        }
        userSongs.remove(userId);
        rebuildHeap();
    }

    // Play the next most liked song
    public String getNextSong() {
        if (maxHeap.isEmpty()) {
            return "No songs left to play";
        }
        return maxHeap.poll().getKey(); // Return the next most liked song
    }

    private void rebuildHeap() {
        maxHeap.clear();
        maxHeap.addAll(songLikes.entrySet());
    }
}
