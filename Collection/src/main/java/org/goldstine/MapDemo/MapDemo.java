package org.goldstine.MapDemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的体系：
 *      Map<K,V>接口，Map集合的祖宗类
 *    TreeMap<K,V>    HashMap<K,V>
 *                      LinkedHashMap<K,V>
 *
 *   Mao集合的特点：
 *   （1）Map集合的特点都是有键决定的
 *   （2）Map集合的键是无序的，不重复的，无索引的
 *          Map集合后面重复的键对应的元素会覆盖前面的整个元素
 *    （3）Mao集合的值无要求
 *    （4）Map集合的键值对都可以为null
 *    HashMap：元素按照键是无序的，不重复的，无索引的，值不做要求
 *    LinkedHashMap:元素按照键是有序的，不重复，无索引，值不做要求
 *
 */
public class MapDemo {

    public static void main(String[] args) {
        //（1）添加一个元素put
        Map<String,Integer> maps=new HashMap<>();
        maps.put("娃娃",1);
        maps.put("huawei",10);
        maps.put("iPhonex",2);
        maps.put("娃娃",30);
        maps.put(null,null);
        System.out.println(maps);

        //(2)清空map集合
//        maps.clear();
//        System.out.println(maps);

        //(3)判断集合是否为空
        System.out.println(maps.isEmpty());

        //(4)根据键获取对应的值
        System.out.println(maps.get("huawei"));

        //(5)根据键删除某一个元素，根据键删除remove(Key String)返回对应的value
        Integer iPhonex = maps.remove("iPhonex");
        System.out.println(iPhonex);

        System.out.println(maps);

        //(6)判断是否包含某个键，包含返回true,反之
        System.out.println(maps.containsKey("huawei"));
        System.out.println(maps.containsKey(null));//null不是一个字符串

        //(7)判断是否包含某个值
        System.out.println(maps.containsValue(30));

        //(8)获取全部键的集合：public Set<K> keySet()
        //由于map集合的元素是根据key无序不重复无索引的所以返回的所有键的集合是一个Set集合
        Set<String> strings = maps.keySet();
        System.out.println(strings);
        strings.forEach(System.out::println);

        //由于map的value是可以重复的，所以返回的是一个Collection集合对象
        //(9)获取全部值的集合  Collection<V> values()
        Collection<Integer> values = maps.values();
        values.forEach(System.out::println);

        //(10)集合大小
        System.out.println(maps.size());

        //(11)合并其他的集合
        Map<String,Integer> maps2=new HashMap<>();
        maps2.put("锤子",2);
        maps2.put("手表",10000);
        maps2.put("xiaomi",12);
        maps.putAll(maps2);//将map集合maps2的数据全部倒入maps集合中
        System.out.println(maps);

    }
}
