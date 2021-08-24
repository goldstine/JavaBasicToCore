package org.goldstine.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * 获取对应的属性
 * Element元素的Api:
 *  List<Attribute> attributes():获取元素的全部属性对象</Attribute>
 *  Attribute attribute(String name):根据名称获取某个元素的属性对象
 *  String attributeValue(String val1);直接获取某个元素的某个属性名称的值
 *
 *  Attribute对象的api:
 *      String getName();获取属性名称
 *      String getValue();获取属性值
 */
public class Dom4jDemo02 {
    public static void main(String[] args) throws DocumentException {
        //获取对应的解析器
        SAXReader saxReader=new SAXReader();
        //通过解析器获得对应的Element文档对象
        Document document = saxReader.read(new File("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\Junit-Reflection-Annotation-dynamicProxy\\src\\main\\xml\\books.xml"));

        //通过文档对象获得根元素
        Element root = document.getRootElement();

        //通过根元素获得所有的element
        List<Element> elements = root.elements();
        System.out.println(elements.size());
        //遍历每一个element
        for (Element element : elements) {
            //对于每一个element获取对应的属性
            List<Attribute> attributes = element.attributes();
            //遍历输出每一个元素的element对应的属性对象
//            attributes.forEach(System.out::println);
            for (Attribute attribute : attributes) {
                //根据每个元素的属性名称获取对应的值
//                System.out.println(attribute.getName()+element.attributeValue(attribute.getName()));
                System.out.println(attribute.getName()+attribute.getValue());
            }

            System.out.println("=========");
            //获得元素指定的名称的属性对象

            System.out.println();

        }


        //首先获得对应的element
        Element book = root.element("book");
        //获取对应的element指定的属性名称属性对象
        Attribute desc = book.attribute("desc");
        //输出对应的属性的属性名和属性值
        System.out.println(desc.getName()+"===>"+desc.getValue());

    }
}
