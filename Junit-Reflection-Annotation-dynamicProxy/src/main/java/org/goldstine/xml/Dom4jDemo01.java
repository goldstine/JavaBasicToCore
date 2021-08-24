package org.goldstine.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * 通过Dom4j进行解析
 * Element元素的api：
 *      （1）String getName():获取元素的名称
 *      （2）List<Element> elements():获取当前元素下的全部子元素，一级
 *      （3）List<Element> elements(String name):获取当前元素下的指定名称的全部子元素
 *      （4）Element element(String name):获取当前元素下的指定名称的某个子元素，默认取第一个（一级）
 */
public class Dom4jDemo01 {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\Junit-Reflection-Annotation-dynamicProxy\\src\\main\\xml\\books.xml"));
        //获得当前文档对象的根元素
        Element root = document.getRootElement();
        
        //获取当前元素root下的全部子元素
        List<Element> elements = root.elements();
        for (Element element : elements) {
            System.out.println(element.getName());

        }

        //获得指定名称的全部子元素
        List<Element> book = root.elements("book");
        for (Element element : book) {
            System.out.println(element.getName());
        }

        //获得指定名称的子元素
        Element user = root.element("book");//默认会提取第一个名称一样的子元素对象返回
        System.out.println(user.attributeValue("id"));

    }
}
