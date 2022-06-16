class OutSide{

    static class Inside {
        private static int count = 0;

        void inc(){
            count++;
        }

        int get(){
            return count;
        }
    }
}