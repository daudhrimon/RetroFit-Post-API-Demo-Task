package com.daud.retrofixdemo;

import java.util.List;

public class ResponseMc {
    private int count;
    private List<Entry> entries ;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}


