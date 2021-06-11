package com.winner;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class FindUniqChar {
    public static int firstUniqChar(String s) {
        if (s == null || s == "") {
            return -1;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        Character character = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                character = entry.getKey();
                break;
            }
        }
        if (character != null) {
            int i = 0;
            for (char c : chars) {
                if (c == character) {
                    return i;
                }
                i++;
            }
        }

        return -1;
    }

    public static int firstUniqChar2(String s) {
        if (s == null || s == "") {
            return -1;
        }
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            arr[c - 'a']++;
        }
        int i = 0;
        for (char c : chars) {
            if (arr[c - 'a'] == 1) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar2("leetcode"));
        System.out.println(firstUniqChar2("loveleetcode"));

    }
}
