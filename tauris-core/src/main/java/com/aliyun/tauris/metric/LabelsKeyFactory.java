package com.aliyun.tauris.metric;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ZhangLei on 16/12/2.
 */
public class LabelsKeyFactory {

    private static LabelsKeyFactory                        instance = new LabelsKeyFactory();
    private        ConcurrentHashMap<LabelsKey, LabelsKey> keyMap   = new ConcurrentHashMap<>();

    private LabelsKeyFactory() {

    }

    public static LabelsKeyFactory getInstance() {
        return instance;
    }

    public LabelsKey makeKey(String... keys) {
        LabelsKey key    = new LabelsKey(keys);
        LabelsKey exists = keyMap.putIfAbsent(key, key);
        if (exists != null) {
            key = exists;
        }
        return key;
    }
}
