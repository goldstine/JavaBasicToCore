package org.goldstine.factoryPattern.decorationPattern;

public class FileInputStream extends InputStream{

    @Override
    public void read() {
        System.out.println("装饰模式读数据");
    }

    @Override
    public void close() {
        System.out.println("装饰模式关闭流");
    }
}
