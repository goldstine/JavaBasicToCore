package org.goldstine.MapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 目标：输出一个字符串中每一个字符出现的次数
 *
 */
public class MapTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //定义一个Map集合，键是每一个字符，值是其出现的次数
        Map<Character,Integer> maps=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(maps.containsKey(c)){
                maps.put(c,maps.get(c)+1);
            }else{
                maps.put(c,1);
            }
        }
        maps.forEach((k,v)->{
            System.out.println(k+"===>"+v);
        });
    }
}
