package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RecentlyPlayedStore1 {
    private int capacity;
    private Map<Integer, LinkedList<String>> store;

    public RecentlyPlayedStore1(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
    }

    public void playSong(int userId, String songId) {
        LinkedList<String> queue = store.computeIfAbsent(userId, k -> new LinkedList<>());
        queue.remove(songId);
        queue.addFirst(songId);
        if (queue.size() > capacity) {
            queue.removeLast();
        }
    }

    public LinkedList<String> getRecentlyPlayed(int userId) {
        return store.getOrDefault(userId, new LinkedList<>());
    }

    public static void main(String[] args) {
		RecentlyPlayedStore1 store = new RecentlyPlayedStore1(3);
		store.playSong(1, "S1");
		store.playSong(1,"S2");
		store.playSong(1, "S3");
		System.out.println(store.getRecentlyPlayed(1));
		store.playSong(1, "S4");
		System.out.println(store.getRecentlyPlayed(1));
		store.playSong(1, "S2");
		System.out.println(store.getRecentlyPlayed(1));
		store.playSong(1, "S1");
		System.out.println(store.getRecentlyPlayed(1));
		
		
	}
}




