import java.util.Random;

public class NetproLadMember {
    public static void main (String[] args) {
        int array[][] = new int[15][3];
        Random rand = new Random();
        double result = 1;
        for (int i = 0; i < 15; i++) {
            array[i][0] = 120 - rand.nextInt(20); //学生総数
            array[i][1] = array[i][0] * (20 + i) / 100; //女子学生
            array[i][2] = 13 - rand.nextInt(6); //岩井研の配属人数
            //System.out.println("学生総数" + array[i][0] + ", 女子学生" + array[i][1] + ", 岩井研の配属人数" + array[i][2]);
            
            long allIwaiken = combination(array[i][0], array[i][2]); //全体から岩井研を取り出す

            int men = array[i][0] - array[i][1]; //男子学生
            long menIwaiken = combination(men, array[i][2]); //岩井研が全員男子学生
            //System.out.println(allIwaiken + " " + menIwaiken);

            result *= (double) menIwaiken / allIwaiken; //1年目からi年目まで男子のみ
        }
        System.out.println(result);
    }

    public static final long combination(final int n, int r) {
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - 1 + 1) / i;
        }
        return result;
    }
}
