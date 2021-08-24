package org.goldstine.LibraryManagementSystem;

import java.util.*;

/**
 * 定义一个集合表示图书馆用于存储书本信息数据：Map<String,List<Book>>
 */
public class BookSystem {
    //定义图书管理系统，键是对应的橱柜信息，值通过List存储一本一本的书
    //由于图书馆只有一个，所以直接定义为一个常量
    public static final Map<String, List<Book>> BOOK_STORE=new HashMap<>();
    public static final Scanner SYS_SCANNER=new Scanner(System.in);

    public static void main(String[] args) {
        showCommane();
    }

    /**
     * 显示操作界面
     */
    public static void showCommane(){
        System.out.println("=====================欢迎您进入系统================");
        System.out.println("(1)查看全部书籍.query");
        System.out.println("(2)添加书本信息.add");
        System.out.println("(3)删除书本信息.delete");
        System.out.println("(4)修改书本信息.update");
        System.out.println("(5)退出系统.exit");
        System.out.print("请您输入您的操作命令:");
        String s = SYS_SCANNER.nextLine();
        //判断用户的命令是想干啥
        switch (s){
            case "query":
                //查看全部书籍
                query();
                break;
            case "add":
                //添加书本信息
                add();
                break;
            case "delete":
                //删除书本信息
                delete();
                break;
            case "update":
                //修改书本信息
                update();
                break;
            case "exit":
                //退出系统
                System.out.println("退出成功，期待您下次光临");
                System.exit(0);
                break;
            default:
                System.err.println("输入操作命令错误");
        }
        showCommane();
    }

    private static void update() {
        if(BOOK_STORE.size()==0){
            //没有对应的栏目橱柜
            System.out.println("还没有栏目");
        }else {
            query();
            System.out.println("================欢迎您进入修改书本业务===============");
            while (true) {
                System.out.println("请您输入修改的书本栏目：");
                String type = SYS_SCANNER.nextLine();
                //判断是否存在该栏目
                if (BOOK_STORE.containsKey(type)) {
                    //存在该栏目
                    while (true) {
                        //输入要修改的书名：
                        System.out.println("请输入要修改的书名：");
                        String name = SYS_SCANNER.nextLine();
                        //判断橱柜下是否有该书
                        Book bookByTypeAndName = getBookByTypeAndName(type, name);
                        if (bookByTypeAndName == null) {
                            System.err.println("您输入的书名不存在，请重新输入！");
                        } else {
                            System.out.println("请您输入修改新书本的名称：");
                            String newName = SYS_SCANNER.nextLine();
                            System.out.println("请您输入修改新书本的价格：");
                            String newPrice = SYS_SCANNER.nextLine();//先通过字符串接受double类型的数据，后面转为对应的double
                            //对应的包装类提供字符串转基本数据类型的方式 Xxx.valueof()   Xxx.parseXxx()
                            System.out.println("请您输入修改新书本的作者：");
                            String newAuthor = SYS_SCANNER.nextLine();

                            //直接通过对象的引用修改内存中的数据
                            bookByTypeAndName.setName(newName);
                            bookByTypeAndName.setPrice(Double.valueOf(newPrice));
                            bookByTypeAndName.setAuthorName(newAuthor);

                            query();
                            System.out.println("您修改的书本成功，请看如上信息确认！");
                            return;//结束修改方法

                        }
                    }
                } else {
                    //不存在该栏目
                    System.out.println("您输入的栏目不存在，请重新输入：");
                }
            }
        }
    }

    private static Book getBookByTypeAndName(String type, String name) {
        //先获得这个栏目的橱柜，根据栏目提取它的值
        List<Book> books = BOOK_STORE.get(type);
        for (Book book : books) {
            if(book.getName().equals(name)){
                return book;
            }
        }
        return null;
    }

    private static void delete() {
        query();
        System.out.println("==================欢迎进入删除书本业务=================");
        while(true){
            System.out.println("请输入您要删除书本的业务：");
            String type = SYS_SCANNER.nextLine();
            if(BOOK_STORE.containsKey(type)){
                //存在该栏目
                while(true){
                    System.out.println("请问您要删除的书本名称是：");
                    String name = SYS_SCANNER.nextLine();
                    //根据栏目和书名去找这个栏目中的书对象
                    Book bookByTypeAndName = getBookByTypeAndName(type, name);
                    if(bookByTypeAndName==null){
                        System.err.println("这本书不存在");

                    }else{
                        //这本书存在，应该取出这个栏目的橱柜集合
                        List<Book> books = BOOK_STORE.get(type);
                        books.remove(bookByTypeAndName);
                        System.out.println("删除成功");
                        query();
                        return ;
                    }
                }

            }else{
                //不存在该栏目
                System.err.println("您输入的栏目有无，请确认");
            }
        }
    }

    /**
     * 查询所有的书本信息
     */
    private static void query() {
        if(BOOK_STORE.size()==0){
            System.out.println("您的图书馆一本书都没有，请赶紧买书去！！！");
        }else {
            System.out.println("=====================欢迎您进入查询书本系统======================");
            System.out.println("类型\t\t\t\t书名\t\t\t\t\t价格\t\t\t作者");
            //遍历
            BOOK_STORE.forEach((type, books) -> {
                //遍历所有的书
                System.out.println(type);
                for (Book book : books) {
                    System.out.println("\t\t\t\t" + book.getName() + "\t\t\t\t" + book.getPrice() + "\t\t\t" + book.getAuthorName());
                }
            });
        }
    }

    /**
     * 添加书本信息
     */
    private static void add() {
        System.out.println("===================欢迎您进入添加书本业务=================");
        System.out.println("请输入添加书目的栏目");
        String type = SYS_SCANNER.nextLine();
        //判断是否存在该栏目

        List<Book> books=null;
        if(BOOK_STORE.containsKey(type)){
            //直接得到该栏目存在的橱柜对象
            books = BOOK_STORE.get(type);
        }else{
            //该栏目是第一次添加书
            //为该栏目创建一个橱柜对象List<Book>
            books=new ArrayList<>();
            BOOK_STORE.put(type,books);
        }
        System.out.println("请您输入添加书本的名称：");
        String name=SYS_SCANNER.nextLine();
        System.out.println("请您输入添加书本的价格：");
        String price=SYS_SCANNER.nextLine();//先通过字符串接受double类型的数据，后面转为对应的double
        //对应的包装类提供字符串转基本数据类型的方式 Xxx.valueof()   Xxx.parseXxx()
        System.out.println("请您输入添加书本的作者：");
        String author=SYS_SCANNER.nextLine();

        //将输入信息进行封装
        Book book = new Book(name, Double.valueOf(price), author);
        books.add(book);//讲书放入橱柜

//        BOOK_STORE.put(type,books);
        System.out.println("您添加在"+type+"下的书本"+book.getName()+"成功！");
    }

}
