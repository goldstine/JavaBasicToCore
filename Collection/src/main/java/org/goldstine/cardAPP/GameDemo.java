package org.goldstine.cardAPP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameDemo {
    //定义一个静态集合，存储54张牌对象，集合只需要一个
    public static final List<Card> ALL_CARDS=new ArrayList<>();

    //初始化所有的牌
    static{
        //定义一个数组存储牌的点数，类型确定，个数确定，通过数组存储
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //定义一个数组存储牌的花色
        String[] colors={"♠","♥","♣","♦"};
        //先遍历点数与四种花色组装成牌对象存入到集合中去
        int index=0;
        for (String number : numbers) {
            for (String color : colors) {
                Card card = new Card(number, color,index++);
                ALL_CARDS.add(card);
            }
        }
        //单独加入大王小王
        Collections.addAll(ALL_CARDS,new Card("","x",index++),new Card("","X",index++));
        System.out.println("输出新牌"+ALL_CARDS);
    }

    public static void main(String[] args) {
        /**
         * 洗牌（把新牌的顺序进行打乱）
         */
        Collections.shuffle(ALL_CARDS);
        System.out.println("洗牌后："+ALL_CARDS);

        /**
         * 定义3个玩家，每一个玩家都有一堆牌
         */
        List<Card> linghuchong=new ArrayList<>();
        List<Card> jiumozhi=new ArrayList<>();
        List<Card> dongfang=new ArrayList<>();

        /**
         * 发牌：先发54-3（底牌）
         */
        for (int i = 0; i < ALL_CARDS.size()-3; i++) {
            if(i%3==0){
                linghuchong.add(ALL_CARDS.get(i));
            }else if(i%3==1){
                jiumozhi.add(ALL_CARDS.get(i));
            }else if(i%3==2){
                dongfang.add(ALL_CARDS.get(i));
            }
        }

        /**
         * 发完了牌应该对牌进行排序
         */
        sortCards(linghuchong);
        sortCards(jiumozhi);
        sortCards(dongfang);

        /**
         * 看牌
         */
        System.out.println("令狐冲"+linghuchong);
        System.out.println("鸠摩智"+jiumozhi);
        System.out.println("东方:"+dongfang);
//        System.out.println("底牌："+ALL_CARDS.get(53)+"-"+ALL_CARDS.get(52)+"-"+ALL_CARDS.get(51));
        //拓展：截取集合的最后三张牌到一个新的List集合中去
        List<Card> lastThreeCards=ALL_CARDS.subList(ALL_CARDS.size()-3,ALL_CARDS.size());
        lastThreeCards.forEach(System.out::print);
    }

    /**
     * 对牌的List集合进行排序（降序排序）
     * @param cards
     */
    private static void sortCards(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                //牌的大小就是当前牌中存储的索引值
                return o2.getIndex()-o1.getIndex();//从小到大进行排序
            }
        });
    }
}
