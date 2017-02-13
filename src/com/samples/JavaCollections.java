package com.samples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class JavaCollections {

	public static void main(String[] args) {

/*
        //Cannot put the same element into the Set.
		Set<String> set = new HashSet<>();

        set.add("11111");
        set.add("22222");
        set.add("33333");
        set.add("44444");
        set.add("22222");

        System.out.println(set.size());

        for (String e : set) {
            System.out.println(e);
        }
*/
		/*
		//TreeSet is a sorted Set.
        TreeSet<Integer> set = new TreeSet<>();

        set.add(5555);
        set.add(1111);
        set.add(3333);
        set.add(4444);
        set.add(2222);
        
        System.out.println(set.first()); // 输出第一个元素
        System.out.println(set.lower(3333)); //小于3333的最大元素
        System.out.println(set.higher(2222)); //大于2222的最大元素
        System.out.println(set.floor(3333)); //不大于3333的最大元素
        System.out.println(set.ceiling(3333)); //不小于3333的最大元素

        System.out.println(set.pollFirst()); //删除第一个元素
        System.out.println(set.pollLast()); //删除最后一个元素
        System.out.println(set);
        */
		
		//Queue: first come first out.
        Queue<String> queue = new LinkedList<>();

        queue.offer("dddd");
        queue.offer("aaaa");
        queue.offer("bbbb");
        queue.offer("cccc");

        System.out.println(queue);
        
        while (queue.size() > 0) {
            System.out.println(queue.remove() + "");
        }

	}

}
