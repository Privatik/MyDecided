

public class TestJavaClass {
    public static void main(String[] args) {
//        OutSide o = new OutSide();
//        o.doTest();

        String str = "Hello";
        String str2 = new String("Hello");

        System.out.println(str == str2);
        System.out.println(str.equals(str2));

        System.out.println("After intern");

        str2.intern();
        System.out.println(str == str2);
        System.out.println(str.equals(str2));
    }
}