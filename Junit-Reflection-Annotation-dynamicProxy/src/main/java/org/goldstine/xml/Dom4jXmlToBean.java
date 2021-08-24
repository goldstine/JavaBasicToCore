package org.goldstine.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * 将xml数据解析成对应的java对象：将Contacts.xml成为一个java对象；集合对象
 * Contacts.xml解析成List<Contact>
 *
 * </Contact>
 *
 */
public class Dom4jXmlToBean {
    public static void main(String[] args) throws DocumentException {
        //首先获取对应的解析器对象
        SAXReader saxReader = new SAXReader();
        //通过解析器对象获取对应的文档对象
        Document document = saxReader.read("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\Junit-Reflection-Annotation-dynamicProxy\\src\\main\\xml\\Contacts.xml");
        //通过文档对象获取对应的根元素
        Element root = document.getRootElement();
        //通过根元素获取所有的以及元素element
        List<Element> elements = root.elements();

        //定义一个集合存储所有的bean对象
        List<Contact> con=new ArrayList<>();

        //为了安全，首先需要做安全校验
        if(elements!=null&&elements.size()>0) {
            //遍历每一个以及元素，每一个元素都是一个bean对象
            for (Element element : elements) {

                //当前每一次循环遍历都对应的一个对象，所以创建对应的对象
                Contact contact = new Contact();

                //这里虽好的方式，是通过父元素element根据属性名获得对应的属性值
                contact.setId(Integer.valueOf(element.attributeValue("id")));//在进行bean的封装的时候，进场使用包装类的valueof将字符串转为基本数据类型
                contact.setVip(Boolean.valueOf(element.attributeValue("vip")));
//                contact.setName(element.element("name").getTextTrim());
                //可以直接通过父元素获得对应的子元素的文本内容
                contact.setName(element.elementText("name"));
                contact.setSex(element.element("gender").getTextTrim().charAt(0));
                //这里特例在于将字符串转为字符，不能够直接通过包装类，包装类只能将字符转为对应的包装类型字符
                //将字符串转为对应的字符，字符串提供相应的方法charAt(0)
                contact.setEmail(element.elementText("email"));

                //将对应的bean对象存入集合
                con.add(contact);


//                //首先对于每一个element,先后获取对应的属性值，
//                List<Attribute> attributes = element.attributes();
//                //对于每一个属性名称和属性值，作为javabean的一个字段保存起来
//                for (Attribute attribute : attributes) {
//                    System.out.println(attribute.getName() + "===>" + attribute.getValue());
//                }
//
//                //获取所有的子element对应的标签名称，以及对应的文本信息
//                List<Element> elements1 = element.elements();
//                for (Element element1 : elements1) {
//                    System.out.println(element1.getName() + "===>" + element1.getTextTrim());
//                }
            }
        }

        //输出对应的bean集合，进行查看
        System.out.println(con);

    }
}
