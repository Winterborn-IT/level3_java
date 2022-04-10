package lesson7;

public class MyTest {

    @BeforeSuite
    public static void test1() {
        System.out.println("@BeforeSuite");
    }

    @Test
    public static void test2() {
        System.out.println("Test2");
    }

    @Test
    public static void test3() {
        System.out.println("Test3");
    }

    @Test(priority = 9)
    public static void test4() {
        System.out.println("Test4: priority = 9");
    }

    @Test(priority = 4)
    public static void test5() {
        System.out.println("Test5: priority = 4");
    }

    @Test(priority = 6)
    public static void test6() {
        System.out.println("Test6: priority = 6");
    }

    @AfterSuite
    public static void test7() {
        System.out.println("@AfterSuite");
    }

}
