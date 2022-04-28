public class Exercise1 {
    public static void main(String[] args) {
        Monkey[] mArray = new Monkey[6];
        for(int i = 0;i < 6;i++){
            if(i % 2 == 0)
                mArray[i] = new Human();
            else
                mArray[i] = new Monkey();
        }
        for(Monkey m:mArray){
            m.speak();
        }
    }
}
