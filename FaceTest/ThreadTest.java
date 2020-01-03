package cfca.xfraud.api.test;

public class ThreadTest {
    public static void main(String[] args) {
        int count = 0;
        long startTime = System.currentTimeMillis();
        for(int i = 1;i<=1000000;i++) {
            if(currentIsPrimeNum(i)) {
                count++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(count);
        System.out.println("耗时："+(endTime-startTime)+"ms");
    }
    private static boolean currentIsPrimeNum (int number) {
        boolean flag = true;
        for(int i=2;i<number;i++) {
            if(number%i==0) {
                flag=false;
                break;
            }
        }
        return flag;
    }
}
