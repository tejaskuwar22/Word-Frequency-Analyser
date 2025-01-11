package tech.codingclub.utility;
import java.security.Key;
import java.util.*;

public class TopKeywordAnalyser implements Runnable{
    private final String filePath;

    public TopKeywordAnalyser(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        ArrayList<String> keywordsFileData = FileUtility.readFileAsList(filePath);
        HashMap<String,Integer> keywordCounter = new HashMap<String,Integer>();

        for(String row : keywordsFileData) {
            String[] keywords = row.split(" ");
            for(String keyword : keywords) {
                String str = keyword.toLowerCase();
                if(!keywordCounter.containsKey(str)) {
                    keywordCounter.put(str,1);
                } else {
                    Integer value = keywordCounter.get(str);
                    keywordCounter.put(str,value+1);
                }
            }
        }
        ArrayList<KeywordCount> keywordCountArrayList = new ArrayList<KeywordCount>();
        for(String keyword : keywordCounter.keySet()) {
            KeywordCount keywordCount = new KeywordCount(keyword,keywordCounter.get(keyword));
            keywordCountArrayList.add(keywordCount);
        }

        Collections.sort(keywordCountArrayList, new Comparator<KeywordCount>() {
            public int compare(KeywordCount o1, KeywordCount o2) {
                if(o2.count == o1.count) {
                     return o1.keyword.compareTo(o2.keyword);
                }
                return o2.count - o1.count;
            }
        });

        for(KeywordCount keywordCount : keywordCountArrayList) {
            System.out.println(keywordCount.keyword + " " + keywordCount.count);
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(1);
        taskManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyser("data/practice/file/IndianNationalAnthem.txt"));
    }
}
