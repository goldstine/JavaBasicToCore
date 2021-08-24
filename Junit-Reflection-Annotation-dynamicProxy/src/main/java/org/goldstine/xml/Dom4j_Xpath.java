package org.goldstine.xml;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * dom4j中与XPath表达式有关的方法
 * Xpath一种用于快速查找xml元素的路径表达式，适用于方便地检索xml文件中的信息
 * xpath表达式分类：
 *      绝对路径
 *      相对路径
 *      全文搜索
 *      属性查找
 *
 *      dom4j中与xpath相关的方法
 *          使用xpath需要另外导入jaxen-1.1.2.jar包
 *
 *      Xpath常用api
 *          List<Node> selectNodes(String var1):检索出一批节点集合</Node>
 *          Node selectSingleNode(String var1):检索出一个节点返回
 *
 * 小结：通过dom4j解析xml,通过xpath检索xml文件
 *
 */
public class Dom4j_Xpath {
    public static void main(String[] args) throws DocumentException {
        //通过绝对路径进行检索
        //首先获得解析器对象
        SAXReader saxReader = new SAXReader();
        //通过解析器对象获得对应的文档对象
        Document document = saxReader.read("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\Junit-Reflection-Annotation-dynamicProxy\\src\\main\\xml\\Contact.xml");

        //通过流的方式获取对应的文档对象
//        InputStream is = Dom4j_Xpath.class.getResourceAsStream("/xml/Contact.xml");
        //这里需要填一个类路径，如果没有该路径，说明可能是因为没有Build到target文件夹中，因为我创建的是xml  maven构建
//        正常应该是resources资源文件夹，填类路径，即使填绝对路径也会出错
//        Document document = saxReader.read(is);

//        //通过文档对象获得根节点元素
//        Element root = document.getRootElement();

        //通过绝对路径定位全部的name名称，返回的是一个List集合
        List<Node> nameNodes = document.selectNodes("/contactList/contact/name");//第一个/表示文本对象
        for (Node nameNode : nameNodes) {
            System.out.println(nameNode.getText());

        }

        //通过相对路径进行定位
        System.out.println("==========通过相对路径定位===============");
        // .表示当前元素

        //首先得到根元素
        Element root = document.getRootElement();
        //从根元素开始检索
        List<Node> nameNodes1 = root.selectNodes("./contact/gender");
        for (Node node : nameNodes1) {
            System.out.println(node.getText());
        }

        /**
         * 全文检索：
         *      "//元素"    在全文找这个元素
         *      "//元素1/元素2"  在全文找元素1下面的一级元素2
         *      "//元素1//元素2"  在全文找元素1下面的全部元素2
         */
        //name是指在整个xml文件中检索name节点
        System.out.println("===============全文检索================");
        List<Node> nameNodes2 = document.selectNodes("//name");
        for (Node node : nameNodes2) {
            System.out.println(node.getText());
        }

        //检索全部contact下的直接一级name   //contact/name
        System.out.println("===========全文检索========");
        List<Node> nameNode3 = document.selectNodes("//contact/name");
        for (Node node : nameNode3) {
            System.out.println(node.getText());
        }

        //全文检索全部contact下的所有name节点 //contact//name
        System.out.println("=========全文检索===========");
        List<Node> nameNode4 = document.selectNodes("//contact//name");
        for (Node node : nameNode4) {
            System.out.println(node.getText());
        }


        //属性检索   属性查找
        /**
         * //@属性名称   在全文检索属性对象
         * //元素[@属性名称]      在全文检索包含该属性的元素对象
         * //元素[@属性名称=值]    在全文检索包含该属性的元素且属性值为该值的元素对象
         */
        System.out.println("=========属性检索==========");
        List<Node> attributes = document.selectNodes("//@id");
        for (Node attribute : attributes) {
//            System.out.println(attribute.getName()+"===="+attribute.getStringValue());
            //或者将attribute强制转换成对应的Attibute对象
            Attribute attr = (Attribute) attribute;
            System.out.println(attr.getName()+"======>"+attr.getValue());
        }

        //返回的是包含id属性的element标签
        System.out.println("=======属性查找============");
        List<Node> atts = document.selectNodes("//contact[@id]");
        for (Node att : atts) {
            System.out.println(att.getName());
        }


        System.out.println("=======属性查找============");
        Node att = document.selectSingleNode("//contact[@id=2]");
//        System.out.println(att.getName());
        //将该结点强转为元素对象
        Element att1 = (Element) att;
        System.out.println(att1.elementTextTrim("name"));

    }
}
