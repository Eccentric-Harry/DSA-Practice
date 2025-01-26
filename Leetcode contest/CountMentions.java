import java.util.*;

class CountMentions {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        Map<Integer, Integer> offlineUntil = new HashMap<>(); 
        
        for (int userId = 0; userId < numberOfUsers; userId++) {
            offlineUntil.put(userId, 0); 
        }
        
        for (List<String> event : events) {
            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            
            if (type.equals("OFFLINE")) {
                int userId = Integer.parseInt(event.get(2));
                offlineUntil.put(userId, timestamp + 60);
            } else if (type.equals("MESSAGE")) {
                String mentionsString = event.get(2);
                Set<Integer> mentionedUsers = new HashSet<>();
                
                if (mentionsString.equals("ALL")) {
                    for (int userId = 0; userId < numberOfUsers; userId++) {
                        mentionedUsers.add(userId);
                    }
                } else if (mentionsString.equals("HERE")) {
                    
                    for (int userId = 0; userId < numberOfUsers; userId++) {
                        if (timestamp >= offlineUntil.get(userId)) { 
                            mentionedUsers.add(userId);
                        }
                    }
                } else {
                    String[] ids = mentionsString.split(" ");
                    for (String id : ids) {
                        if (id.startsWith("id")) {
                            int userId = Integer.parseInt(id.substring(2));
                            mentionedUsers.add(userId);
                        }
                    }
                }
                for (int userId : mentionedUsers) {
                    mentions[userId]++;
                }
            }
        }
        
        return mentions;
    }
}
©leetcode