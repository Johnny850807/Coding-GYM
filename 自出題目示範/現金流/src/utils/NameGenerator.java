package utils;

import java.util.Collections;
import java.util.Stack;

public class NameGenerator {
    private static NameGenerator instance;  //singleton
    private static final String[] names = {"昇昇", "羅宇智", "你家大云", "光澤", "旭哥", "水球", "方Enjoy"};
    protected static Stack<String> participantNames;

    private NameGenerator() {
        prepareAllDefaultNames();
    }

    public static NameGenerator getInstance() {
        if (instance == null) {
            instance = new NameGenerator();
        }
        return instance;
    }

    public String nextName() {
        return participantNames.pop();
    }

    private void prepareAllDefaultNames() {
        participantNames = new Stack<>();
        for (String s : names)
            participantNames.push(s);
        Collections.shuffle(participantNames);
    }

}

