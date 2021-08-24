package org.example;

import static org.junit.Assert.assertTrue;

import org.goldstine.Junit.demo01.UserService;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testLogin(){
        UserService userService = new UserService();
        String s = userService.login("admin", "123456");
        //为了测试方法写的专业一点，所以建议使用断言机制进行判断,自动化测试需要
        //public static void assertEquals(String message, Object expected, Object actual)
        /**
         * 参数一message:测试失败的提示信息
         * 参数二：expected:期望值
         * 参数三：实际值
         */
        Assert.assertEquals("登陆业务功能方法有错误，请检查","success",s);

    }

    /**junit4
     * 测试类的常用注解：
     * @Before:用来修饰实例方法，该方法会在每一个测试方法执行之前执行一次      可以用于资源的初始化
     * @After:用来修饰实例方法,该方法会在每一个测试方法执行之后执行一次   释放资源
     * @BeforeClass：静态方法，会在所有的测试方法执行之前执行一次         用于初始化静态资源
     * @AfterClass：静态方法，会在所有的测试方法执行之后执行一次           释放资源
     */

    /**
     * junit5:
     * @BeforeEach:用于修饰实例方法，该方法会在每一个测试方法执行之前执行一次
     * @AfterEach:用来修饰实例方法,该方法会在每一个测试方法执行之后执行一次
     * @BeforeAll:静态方法，会在所有的测试方法执行之前执行一次
     * @AfterAll:静态方法，会在所有的测试方法执行之后执行一次
     */

    @Before
    public void before(){
        System.out.println("===============before=================");
    }

    @After
    public void after(){
        System.out.println("=============after=================");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("=============beforeClass=============");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("==============afterClass==============");
    }

}
