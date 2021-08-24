package org.goldstine.CommonsIO;

import java.util.Base64;
import java.util.UUID;

/**
 * Base64是网络上最常见的用于传输8bit字节码的编码方式之一
 * java8内置了base64编码的编码器和解码器
 * Base64提供了一套静态方法获取下面三种BASE64编解码器
 * （1）基本：输出被映射到一组字符A-Za-z0-9+/,编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/
 * (2)URL:输出银蛇到一组字符上A-Za-z0-9+/，输出是URl和文件
 * （3）MIME:输出隐射到MIME友好格式输出每行不超过76字符，并且使用\r并跟随\n作为分割，编码输出最后没有行分割
 *
 * 小结：
 *      普通编码：适合编码小数据量  文本信息
 *      URL:适合编码地址信息
 *      MIME:适合编码大文本信息 数据量较大的文本编码
 */
public class Base64Demo {
    public static void main(String[] args) {
        //基本编码后结果，普通文本的编码
        String s = Base64.getEncoder().encodeToString("我是中国国人".getBytes());
        System.out.println(s);//5oiR5piv5Lit5Zu95Zu95Lq6

        //基本解码之后结果
        String s1 = new String(Base64.getDecoder().decode(s));
        System.out.println(s1);


        //URL编码
        String s2 = Base64.getUrlEncoder().encodeToString("江西省吉安市青原区".getBytes());
        System.out.println(s2);
        //URL解码
        byte[] buffer = Base64.getUrlDecoder().decode(s2);
        String s3 = new String(buffer);
        System.out.println(s3);


        //MIME编码
        String s4 = Base64.getMimeEncoder().encodeToString("宇宙银河系太阳系地球".getBytes());
        System.out.println(s4);

        //MIME解码
        byte[] buffer1 = Base64.getMimeDecoder().decode(s4);
        System.out.println(new String(buffer1));

        //通过MIME对大段内容进行编码
        System.out.println(UUID.randomUUID());//单个UUID的长度为：f35d7092-0a4f-4fef-9c6a-7e48ff3e977e
        System.out.println(UUID.randomUUID().toString());//上面默认的调用的就是toString()

        //循环产生多个内容
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(UUID.randomUUID().toString());
        }
        //通过MIME进行编码
        String s5 = Base64.getMimeEncoder().encodeToString(sb.toString().getBytes());
        System.out.println(s5);

        //通过MIME进行解码
        byte[] buffer2 = Base64.getMimeDecoder().decode(s5);
        System.out.println(new String(buffer2));

    }
}
