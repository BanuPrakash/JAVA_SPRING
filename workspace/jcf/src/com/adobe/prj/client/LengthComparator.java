package com.adobe.prj.client;

import java.util.Comparator;
// avoid these type of classes which doesn't contain any state or any other methods other than
// one in interface
public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
