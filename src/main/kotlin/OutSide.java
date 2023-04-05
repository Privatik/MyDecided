import java.io.IOException;

interface TestSide {
    void doTest();
}


class OutSide implements TestSide{
    private Integer oi = 10;

    static class Inside{
        Integer ii = 10;

        void simpleIn(){
            System.out.println(ii);
        }

        void person(OutSide outSide){
            System.out.println(outSide.oi);
        }
    }

    public void doTest(){
        System.out.println("OutSide");
    }
}