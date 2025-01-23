package Coding.Rippling;

import java.util.*;

public class MusicPlayerAnalytics {
    private final Map<String, String> songTitles; // Maps songId to song title
    private final Map<String, Integer> songPlayCounts; // Maps songId to play count
    private final Map<String, Set<String>> userPlayHistory; // Maps userId to set of played songIds
    private final Map<String, Set<String>> userFavorites; // Maps userId to set of starred songIds
    private final Map<String, LinkedList<String>> userRecentlyPlayedFavorites; // Maps userId to list of recently played favorite songIds

    public MusicPlayerAnalytics() {
        this.songTitles = new HashMap<>();
        this.songPlayCounts = new HashMap<>();
        this.userPlayHistory = new HashMap<>();
        this.userFavorites = new HashMap<>();
        this.userRecentlyPlayedFavorites = new HashMap<>();
    }

    // Adds a song to the system
    public void addSong(String songId, String title) {
        if (!songTitles.containsKey(songId)) {
            songTitles.put(songId, title);
            songPlayCounts.put(songId, 0);
        }
    }

    // Registers a song play by a user
    public void playSong(String songId, String userId) {
        if (!songTitles.containsKey(songId)) {
            return;
        }
        // Increment play count
        songPlayCounts.put(songId, songPlayCounts.getOrDefault(songId, 0) + 1);
        // Track user play history
        userPlayHistory.putIfAbsent(userId, new HashSet<>());
        userPlayHistory.get(userId).add(songId);

        // Track recently played favorite songs
        Set<String> favorites = userFavorites.get(userId);
        if (favorites != null && favorites.contains(songId)) {
            // Logic for when the song is a favorite
            userRecentlyPlayedFavorites.putIfAbsent(userId, new LinkedList<>());
            LinkedList<String> recentFavorites = userRecentlyPlayedFavorites.get(userId);

            if (recentFavorites.contains(songId)) {
                recentFavorites.remove(songId);
            }
            recentFavorites.addFirst(songId);

            // Limit to last N songs (e.g., 5)
            if (recentFavorites.size() > 5) { // limiting to 5
                recentFavorites.removeLast();
            }
        }
    }

    // Stars a song for a user
    public void starSong(String songId, String userId) {
        if (!songTitles.containsKey(songId)) {
            return; // "Song ID not found."
        }
        userFavorites.putIfAbsent(userId, new HashSet<>());
        userFavorites.get(userId).add(songId);
    }

    // Unstars a song for a user
    public void unstarSong(String songId, String userId) {
        if (!songTitles.containsKey(songId)) {
            return; // "Song ID not found."
        }
        Set<String> favorites = userFavorites.get(userId);
        if (favorites != null && favorites.remove(songId)) {
            System.out.println("Song unstarred successfully!");
        } else {
            System.out.println("Song was not starred.");
        }
    }

    // Prints the last N favorite songs played by a user
    public void printLastNFavorites(String userId, int n) {
        LinkedList<String> recentFavorites = userRecentlyPlayedFavorites.getOrDefault(userId, new LinkedList<>());

        if (recentFavorites.isEmpty()) {
            System.out.println("No favorite songs played recently for user " + userId + ".");
            return;
        }

        System.out.println("Last " + n + " favorite songs played by " + userId + ":");
        for (int i = 0; i < Math.min(n, recentFavorites.size());
             i++) {
            String songId = recentFavorites.get(i);
            System.out.println(songTitles.get(songId));
        }
    }

    // Prints the analytics of most played songs
    public void printAnalytics() {
        if (songTitles.isEmpty()) {
            System.out.println("No songs in the system.");
            return;
        }

        // Sort songs by play count in descending order
        List<Map.Entry<String, Integer>> sortedSongs = new ArrayList<>(songPlayCounts.entrySet());
        sortedSongs.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        System.out.println("Most Played Songs:");
        for (Map.Entry<String, Integer> entry : sortedSongs) {
            System.out.printf("Title: %s, Play Count: %d%n", songTitles.get(entry.getKey()), entry.getValue());
        }
    }

    public static void main(String[] args) {
        MusicPlayerAnalytics analytics = new MusicPlayerAnalytics();

        // Add some songs
        analytics.addSong("1", "Song A");
        analytics.addSong("2", "Song B");
        analytics.addSong("3", "Song C");

        // Play some songs
        analytics.playSong("1", "User1");
        analytics.playSong("2", "User1");
        analytics.playSong("1", "User2");
        analytics.playSong("1", "User3");
        analytics.playSong("3", "User1");

        // Star songs
        analytics.starSong("1", "User1");
        analytics.starSong("2", "User1");

        // Play starred songs
        analytics.playSong("1", "User1");
        analytics.playSong("2", "User1");
        analytics.playSong("1", "User1");

        // Unstar a song
        analytics.unstarSong("2", "User1");

        // Print analytics
        analytics.printAnalytics();

        // Print last N favorite songs played
        analytics.printLastNFavorites("User1", 3);
    }
}
