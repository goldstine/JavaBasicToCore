package org.goldstine.factoryPattern.decorationPattern;

/**
 * 装饰模式可以看成是一种静态代理，其功能比动态代理弱一点
 */
public class TestPattern {
    public static void main(String[] args) {
//        InputStream is = new FileInputStream();
        InputStream is = new BufferedInputStream(new FileInputStream());
        is.read();

        is.close();

    }
}
