package org.goldstine.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * xml文件的解析：
 * xml由七种组成元素构成：
 *  （1）声明（抬头）
 *  （2）元素（标签）
 *  （3）属性
 *  （4）注释
 *  （5）实体字符
 *  （6）CDATA字符数据区
 *  （7）处理指令   界面效果
 *
 * xml约束：DTD约束：因为xml文件的标签和属性可以随意扩展，有时我们必须限制每个文档的元素，每个元素有哪些子元素
 * 每个元素有哪些属性，属性的值是什么类型等等，从而保证xml文档格式和数据的正确性和规范性
 * 两种约束：DTD约束  （Document Type Definiation）
 * Schema约束
 * 【以后约束文件都是框架写好的】
 *
 * 在企业实际开发中，不会字节编写DTD约束文档，我们后期只需要通过框架提供的DTD约束文档编写出相应的XML配置文档，只要会导入别人的
 * DTD约束自己即可
 *
 *由于dtd文档只能够约束标签，不能够约束类型，所以基本上不使用，而是使用功能强大的schema约束
 *dtd约束不能够验证数据类型，因为dtd是一个文本文件，本省不能验证是否正确
 *
 *schema特点：
 *  （1）约束文件本身也是一个xml文件，它本身也会被其它xsd文档约束
 *  内置多种数据类型，可以检查数据类型是否正确
 *  支持命名空间，一个xml文件可以同时引入多个xsd越俗文件，让约束规则重用
 *  扩展名 xsd[xml schema definition]
 * 本身也是一个xml文件，对应的根元素名字叫做schema
 *
 *
 * xml文档的两种解析方式：
 *  （1）Dom解析：文档对象模型  面向对象的解析方式
 *  优点：将整个xml文件加载到内存中，生成一棵dom树，随意访问树上的任何一个节点，可以修改和删除节点，程序开发比较方便，纯面向对象
 *  缺点：占内存，如果xml文件很大，可能出现内存溢出
 *  java中dom解析并发发包
 *  JAXP
 *  JDOM
 *  DOM4j
 *  Jsoup
 *
 *
 *  （2）SAX解析
 *  优点：事件驱动型解析方式，读取一行就解析一行，释放内存，理论上可以解析任意大小的xml文件
 *  缺点：使用过的元素不能再访问了，不能修改元素，只能查找
 *
 *
 * xml dom和html dom一样，xml dom将整个xml文档加载到内存，生成一个dom树，并获得一个Document对象，通过Document对象就可以对dom进行操作
 *
 * Dom4j中DOM树的api
 * Document:当前解析的xml文档对象
 * Node:xml终结点，它是所有其他节点对象的父接口
 * Element:代表一个元素
 * Attribute:代表一个属性
 * Text:代表标签中文本
 *
 *java提供Class下的一个方法：
 *      public InputStream getResourceAsStream(String path);用于加载文件作为一个字节输入流
 *
 *      Document文档
 *      Element getRootElement();获取根元素
 */
public class xmlEx {
    public static void main(String[] args) throws Exception {
        //解析books.xml文件成为一个Document文档对象，得到根元素对象
        //1、创建一个dom4j的解析器对象，代表整个dom4j框架
        SAXReader saxReader=new SAXReader();//解析器对象，专门负责解析
        //通过解析器对象获得一个dom4j对应的文档对象Document
//        Document document = saxReader.read("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\Junit-Reflection-Annotation-dynamicProxy\\src\\main\\xml\\books.xml");

        //第二种方式获得对应的document对象
        //先将xml文件读成一个字节输入流   通过字节码文件对象获得对应的输入流
        InputStream is = xmlEx.class.getResourceAsStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\Junit-Reflection-Annotation-dynamicProxy\\src\\main\\xml\\books.xml");
        Document document = saxReader.read(is);

        System.out.println(document);

        //从document文档书对象中提取跟元素对象
        Element root = document.getRootElement();

        System.out.println(root.getName());

    }
}
