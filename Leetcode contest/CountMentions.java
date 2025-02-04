import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offlineEndTime = new int[numberOfUsers]; // Initially all 0, so online

        List<Event> eventList = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            List<String> e = events.get(i);
            String type = e.get(0);
            int timestamp = Integer.parseInt(e.get(1));
            String data = e.get(2);
            eventList.add(new Event(type, timestamp, data, i));
        }

        // Sort events by timestamp, then OFFLINE before MESSAGE, then original index
        Collections.sort(eventList, (a, b) -> {
            if (a.timestamp != b.timestamp) {
                return Integer.compare(a.timestamp, b.timestamp);
            } else {
                int aType = a.type.equals("OFFLINE") ? 0 : 1;
                int bType = b.type.equals("OFFLINE") ? 0 : 1;
                if (aType != bType) {
                    return Integer.compare(aType, bType);
                } else {
                    return Integer.compare(a.originalIndex, b.originalIndex);
                }
            }
        });

        for (Event event : eventList) {
            if (event.type.equals("OFFLINE")) {
                int userId = Integer.parseInt(event.data);
                offlineEndTime[userId] = event.timestamp + 60;
            } else {
                String mentionsStr = event.data;
                int currentTime = event.timestamp;
                String[] tokens = mentionsStr.split(" ");
                for (String token : tokens) {
                    List<Integer> usersToMention = new ArrayList<>();
                    if (token.startsWith("id")) {
                        String idStr = token.substring(2);
                        int userId = Integer.parseInt(idStr);
                        usersToMention.add(userId);
                    } else if (token.equals("ALL")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            usersToMention.add(i);
                        }
                    } else if (token.equals("HERE")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            if (offlineEndTime[i] <= currentTime) {
                                usersToMention.add(i);
                            }
                        }
                    }
                    for (int user : usersToMention) {
                        mentions[user]++;
                    }
                }
            }
        }

        return mentions;
    }

    private static class Event {
        String type;
        int timestamp;
        String data;
        int originalIndex;

        Event(String type, int timestamp, String data, int originalIndex) {
            this.type = type;
            this.timestamp = timestamp;
            this.data = data;
            this.originalIndex = originalIndex;
        }
    }
}