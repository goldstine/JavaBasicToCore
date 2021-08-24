package org.goldstine.factoryPattern.decorationPattern;

/**
 * 通过BufferedInputStream类对FileInputStream的功能加强
 *
 */
public class BufferedInputStream extends InputStream{

    private InputStream is;
    //通过构造发方法接收对应的对象
    public BufferedInputStream(InputStream is){
        this.is=is;
    }

    @Override
    public void read() {
        System.out.println("开启缓冲流读取====");
        is.read();
    }

    @Override
    public void close() {
        System.out.println("装饰模式进行关闭=====");
    }
}
