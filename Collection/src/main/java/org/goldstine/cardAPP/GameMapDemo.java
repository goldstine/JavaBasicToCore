package org.goldstine.cardAPP;

import java.util.*;

/**
 * 通过Map实现
 * 通过牌对象作为键，大小作为值  {card1=0,card2=1,...}
 */
public class GameMapDemo {

    //首先定义一副牌
    public static final Map<CardMap,Integer> ALL_CARD_SIZE=new HashMap<>();
    //定义一个List集合。负责洗牌
    public static final List<CardMap> ALL_CARD=new ArrayList<>();

    //初始化一副牌
    static{
        //定义所有的点数
        //定义一个数组存储牌的点数，类型确定，个数确定，通过数组存储
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //定义一个数组存储牌的花色
        String[] colors={"♠","♥","♣","♦"};

        //遍历初始化这副牌
        int index=0;
        for (String number : numbers) {
            for (String color : colors) {
                CardMap c = new CardMap(number, color);
                ALL_CARD.add(c);
                ALL_CARD_SIZE.put(c,index++);
            }
        }
        //单独添加大小王
        CardMap X = new CardMap("X", "");
        CardMap x = new CardMap("x", "");
        ALL_CARD_SIZE.put(x,index++);
        ALL_CARD_SIZE.put(X,index++);

        ALL_CARD.add(x);
        ALL_CARD.add(X);

        //输出这副牌
//        Set<CardMap> cardMaps = ALL_CARD_SIZE.keySet();
//        System.out.println("输出新牌："+cardMaps);

        System.out.println("输出新牌:"+ALL_CARD);
    }

    public static void main(String[] args) {
        //洗牌
        //如果使用的是LinkedHashMap，会记录对应的添加顺序
        //由于使用的是HashMap是无序的，不重复的，无索引的，类似于Set集合
/**
 * 洗牌（把新牌的顺序进行打乱）
 */
        Collections.shuffle(ALL_CARD);
        System.out.println("洗牌后："+ALL_CARD);

        /**
         * 定义3个玩家，每一个玩家都有一堆牌
         */
        List<CardMap> linghuchong=new ArrayList<>();
        List<CardMap> jiumozhi=new ArrayList<>();
        List<CardMap> dongfang=new ArrayList<>();

        /**
         * 发牌：先发54-3（底牌）
         */
        for (int i = 0; i < ALL_CARD.size()-3; i++) {
            if(i%3==0){
                linghuchong.add(ALL_CARD.get(i));
            }else if(i%3==1){
                jiumozhi.add(ALL_CARD.get(i));
            }else if(i%3==2){
                dongfang.add(ALL_CARD.get(i));
            }
        }

        /**
         * 发完了牌应该对牌进行排序
         */
        sortCard(linghuchong);
        sortCard(jiumozhi);
        sortCard(dongfang);

        /**
         * 看牌
         */
        System.out.println("令狐冲"+linghuchong);
        System.out.println("鸠摩智"+jiumozhi);
        System.out.println("东方:"+dongfang);
//        System.out.println("底牌："+ALL_CARDS.get(53)+"-"+ALL_CARDS.get(52)+"-"+ALL_CARDS.get(51));
        //拓展：截取集合的最后三张牌到一个新的List集合中去
        List<CardMap> lastThreeCards=ALL_CARD.subList(ALL_CARD.size()-3,ALL_CARD.size());
        lastThreeCards.forEach(System.out::print);
    }

    /**
     * 对牌的List集合进行排序（降序排序）
     * @param card
     */
    private static void sortCard(List<CardMap> card) {
        Collections.sort(card, new Comparator<CardMap>() {
            @Override
            public int compare(CardMap o1, CardMap o2) {
                /**
                 * 牌的大小就是当前牌在Map集合中的值存储的大小
                 */
                return ALL_CARD_SIZE.get(o2)-ALL_CARD_SIZE.get(o1);
            }
        });
    }

}
