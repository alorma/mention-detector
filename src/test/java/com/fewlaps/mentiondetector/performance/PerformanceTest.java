package com.fewlaps.mentiondetector.performance;

import com.fewlaps.mentiondetector.MentionDetector;
import org.junit.Test;

public class PerformanceTest {

    public static final int REPETITIONS = 100000;

    public static final String LOREM_IPSUM_WITHOUT_MENTIONS = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    public static final String LOREM_IPSUM_WITH_3_MENTIONS = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, @mention1 sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. @mention2 Excepteur sint occaecat cupidatat non proident, @mention3 sunt in culpa qui officia deserunt mollit anim id est laborum.";
    public static final String LOREM_IPSUM_WITH_1_MENTION_AT_START = "@banana Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    @Test
    public void runGetMentions100000times() throws InterruptedException {
        System.out.println("getMentions() with 0 mentions: " + getTimeToGetMentions(LOREM_IPSUM_WITHOUT_MENTIONS) + "ms");
        System.out.println("getMentions() with 3 mention at the middle: " + getTimeToGetMentions(LOREM_IPSUM_WITH_3_MENTIONS) + "ms");
        System.out.println("getMentions() with 1 mention at the start: " + getTimeToGetMentions(LOREM_IPSUM_WITH_1_MENTION_AT_START) + "ms");
    }

    private long getTimeToGetMentions(String text) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < REPETITIONS; i++) {
            MentionDetector detector = new MentionDetector(text);
            detector.getMentions();
        }
        return System.currentTimeMillis() - startTime;
    }

    @Test
    public void runGetSequences100000times() throws InterruptedException {
        System.out.println("getSequences() with 0 mentions: " + getTimeToGetSequences(LOREM_IPSUM_WITHOUT_MENTIONS) + "ms");
        System.out.println("getSequences() with 3 mention at the middle: " + getTimeToGetSequences(LOREM_IPSUM_WITH_3_MENTIONS) + "ms");
        System.out.println("getSequences() with 1 mention at the start: " + getTimeToGetSequences(LOREM_IPSUM_WITH_1_MENTION_AT_START) + "ms");
    }

    private long getTimeToGetSequences(String text) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < REPETITIONS; i++) {
            MentionDetector detector = new MentionDetector(text);
            detector.getSequences();
        }
        return System.currentTimeMillis() - startTime;
    }
}
