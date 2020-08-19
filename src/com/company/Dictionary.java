package com.company;

import java.util.*;

public class Dictionary {

    public static void main(String[] args) {
            HashMap<String, String[]> dictionary = new HashMap<>();
            HashMap<String, String[]> bigDictionary = new HashMap<>();


            dictionary.put("деревня", new String[]{"Село", "айл", "кишлак", "аул"});
            dictionary.put("красивый", new String[]{"приятное", "симпотичное", "обоятельное"});
            dictionary.put("дом", new String[]{"жилище", "квартира", "шалаш", "логово"});
            dictionary.put("программист", new String[]{"хакер", "девелопер", "айтишник", "гик"});


            Set<String> keys = dictionary.keySet();
            Iterator<String> iter = keys.iterator();
            while (iter.hasNext()) {
                String oldKey = iter.next();
                String[] oldValue = dictionary.get(oldKey);
                bigDictionary.put(oldKey, oldValue);
                for (int i = 0; i < oldValue.length; i++) {
                    String newKey = oldValue[i];
                    List<String> valueList = new ArrayList<>(oldValue.length);
                    valueList.addAll(Arrays.asList(oldValue));
                    valueList.set(i, oldKey);
                    String[] newValue = new String[valueList.size()];
                    valueList.toArray(newValue);
                    bigDictionary.put(newKey, newValue);
                }
            }
                for (Map.Entry<String, String[]> item : bigDictionary.entrySet()) {
                    System.out.println(item.getKey() + " - " + Arrays.toString(item.getValue()));

                }
                System.out.println();
                // bigDictionary.putAll(dictionary);
                while (true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Введите слово из словаря");
                    String word = sc.next();
                    String[] synonym = bigDictionary.get(word);
                    Random r = new Random();
                    if (synonym != null) {
                        int x = r.nextInt(synonym.length);
                        System.out.println(synonym[x]);
                    } else
                        System.out.println("Такого слова в словаре нет");
                }
            }
        }
    


