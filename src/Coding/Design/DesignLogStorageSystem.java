package Coding.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class DesignLogStorageSystem {
    class Log {
        int year;
        int month;
        int day;
        int hour;
        int minute;
        int second;

        public Log(String year, String month, String day, String hour, String minute, String seconds) {
            this.year = Integer.valueOf(year);
            this.month = Integer.valueOf(month);
            this.day = Integer.valueOf(day);
            this.hour = Integer.valueOf(hour);
            this.minute = Integer.valueOf(minute);
            this.second = Integer.valueOf(seconds);
        }
    }

    TreeMap<Integer, Log> treeMap = new TreeMap<>();

    public DesignLogStorageSystem() {

    }

    public void put(int id, String timestamp) {
        String[] split = timestamp.split(":");
        Log log = new Log(split[0], split[1], split[2], split[3], split[4], split[5]);
        treeMap.put(id, log);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> list = new ArrayList<>();
        int granularityIndex = getGranularityIndex(granularity);
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");

        for (int key : treeMap.keySet()) {
            Log log = treeMap.get(key);
            if (isWithinRange(log, startTime, endTime, granularityIndex)) {
                list.add(key);
            }
        }
        return list;
    }

    private boolean isWithinRange(Log log, String[] startTime, String[] endTime, int granularityIndex) {
        int[] logTime = {log.year, log.month, log.day, log.hour, log.minute, log.second};
        int[] start = new int[logTime.length];
        int[] end = new int[logTime.length];

        for (int i = 0; i < logTime.length; i++) {
            start[i] = Integer.parseInt(startTime[i]);
            end[i] = Integer.parseInt(endTime[i]);
        }

        for (int i = 0; i <= granularityIndex; i++) {
            // Check if the current component is less than the start time
            if (logTime[i] < start[i]) return false;

            // If the current component is greater than the start, no need to check further; it's in range
            if (logTime[i] > start[i]) break;
        }

        // Now, compare with the end time
        for (int i = 0; i <= granularityIndex; i++) {
            // Check if the current component is greater than the end time
            if (logTime[i] > end[i]) return false;

            // If the current component is less than the end, no need to check further; it's in range
            if (logTime[i] < end[i]) break;
        }

        return true;
    }

    private int getGranularityIndex(String granularity) {
        switch (granularity) {
            case "Year":
                return 0;
            case "Month":
                return 1;
            case "Day":
                return 2;
            case "Hour":
                return 3;
            case "Minute":
                return 4;
            case "Second":
                return 5;
            default:
                return 5;  // Default to the most specific granularity (Second)
        }
    }

    public static void main(String[] args) {
        DesignLogStorageSystem logSystem = new DesignLogStorageSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:02:23:59:59");
        List<Integer> year = logSystem.retrieve("2017:01:01:23:59:58", "2017:01:02:23:59:58", "Second");
        System.out.println(year);

    }
}


//["LogSystem","put","put","retrieve"]
//   [[],[1,"2017:01:01:23:59:59"],[2,"2017:01:02:23:59:59"],["2017:01:01:23:59:58","2017:01:02:23:59:58","Second"]]