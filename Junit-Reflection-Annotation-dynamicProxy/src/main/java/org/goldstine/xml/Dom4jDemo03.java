package org.goldstine.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 获取文本值
 * Element:
 *      通过父元素element,然后通过子元素的element名称获取对应的文本值
 *      String elementText(String name);可以直接获取当前元素的子元素的文本内容
 *      String elementTextTrim(String name);去前后空格，直接获取当前元素的子元素的文本内容
 *
 *      先通过父元素element获取对应的子元素的element,通过子元素的element直接获取对应的文本文件内容
 *      String getText();直接获取当前元素的文本内容
 *      String getTextTrim();去前后空格，直接获取当前元素的文本内容
 */
public class Dom4jDemo03 {
    public static void main(String[] args) throws DocumentException {
        //首先获取解析器对象
        SAXReader saxReader = new SAXReader();
        //通过解析器对象获得对应的文本document对象
        Document document = saxReader.read("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\Junit-Reflection-Annotation-dynamicProxy\\src\\main\\xml\\books.xml");

        //通过文本对象获得对应的根元素
        Element root = document.getRootElement();

        //通过根元素获得对应的element
        Element book = root.element("book");//按照第一个匹配

        //通过元素获取对应的文本内容跟
        String name = book.elementText("name");//直接通过element对象调用对应的方法获得文本内容
        System.out.println(name);

        System.out.println(book.elementText("author"));
        //去除前后空格
        System.out.println(book.elementTextTrim("author"));

        //直接获取当前元素的文本内容
        //需要继续获取对应的book element对应的下一级element
        Element name1 = book.element("name");
        System.out.println(name1.getText());
        System.out.println(name1.getTextTrim());
    }

}
