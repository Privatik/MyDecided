import java.io.IOException;

class OutSide{

    void doTest(){
    }

    static class Inside {
        private static int count = 0;

        void inc(){
            count++;
        }

        int get(){
            return count;
        }
    }

    void testing() throws Simple1 {
        System.out.println("Hello world");
    }

    void testing1() throws Simple {
        System.out.println("Hello world");
    }

    void testing2() throws Simple2 {
        System.out.println("Hello world");
    }

    class Simple2 extends Throwable{
        public Simple2(String message) {
            super(message);
        }
    }

    class Simple1 extends RuntimeException{
        public Simple1(String message) {
            super(message);
        }
    }

    class Simple extends IOException{
        public Simple(String message) {
            super(message);
        }
    }
}