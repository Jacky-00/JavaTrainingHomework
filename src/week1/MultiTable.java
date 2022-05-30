package week1;

public class MultiTable {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            String line = "";
            for (int j = 1; j <= i; j++) {
                line += String.format("\t%d * %d = %d", i, j, i * j);
            }
            System.out.println(line);
        }
    }
}
