public class Timer {

    public int second = 0;
    public static final int M = 60, S = 1;

    public Timer(int m, int s) {
        set(m, s);
    }

    public void set(int m, int s) {
        second = m*M + s*S;
    }

    public void tick() {
        tick(1);
    }

    public void tick(int t) {
        // 加算
        second += t;

        // 繰り上げ処理
        if(second >= 60*100)
            second %= 60*100;
        if(second < 0)
            second = (60*100)-Math.abs(second)%(60*100);
    }

    public String toString() {
        return String.format("%02d:%02d", second/M, second%M);
    }
}
