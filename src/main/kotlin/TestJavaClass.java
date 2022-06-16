

public class TestJavaClass {
    public static void main(String[] args) {
        OutSide.Inside first = new OutSide.Inside();

        first.inc();
        first.inc();

        System.out.println("body " + first.get());

        OutSide.Inside second = new OutSide.Inside();

        second.inc();
        second.inc();

        System.out.println("body 2 " + second.get());
    }
}