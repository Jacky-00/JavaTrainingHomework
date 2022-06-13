package week2.a2;

import com.supermarket.LittleSupermarket;
import com.supermarket.Merchandise;

public class StaticVariableAndMethod {

    public static double BASE_DISCOUNT = 0.99;
    public static double VIP_DISCOUNT = 0.85;
    public static double SVIP_DISCOUNT = 0.75;

    public static void main(String[] args) {
        System.out.print("调用getDiscount(); ");
        System.out.println("返回值：" + getDiscount());

        System.out.print("调用getDiscount(isVIP: true); ");
        System.out.println("返回值：" + getDiscount(true));

        System.out.print("调用getDiscount(svipLevel: 1); ");
        System.out.println("返回值：" + getDiscount(1));

        System.out.print("调用getDiscount(s: \"test\"); ");
        getDiscount("test");

        LittleSupermarket littleSupermarket = new LittleSupermarket(0.99);
        System.out.println("\n静态方法中调用其他类中静态变量的测试：");
        System.out.println("VIP的折上折折扣最终为：" + Merchandise.getDiscountOnDiscount(littleSupermarket));

    }

    public static double getDiscount() {
        return BASE_DISCOUNT;
    }

    public static double getDiscount(boolean isVIP) {
        double svipDiscount = (isVIP ? VIP_DISCOUNT : 1);
        return getDiscount() * svipDiscount;
    }

    public static double getDiscount(int svipLevel) {
        double ret = getDiscount() * VIP_DISCOUNT;
        for (int i = 0; i < svipLevel; i++) {
            ret *= SVIP_DISCOUNT;
        }
        return ret;
    }

    public static void getDiscount(String s) {
        System.out.println(s);
    }

    public static int getDiscount(int a, int b) {
        return a > b ? a : b;
    }

    public static boolean getDiscount(int a, int b, int c) {
        return a > b && b > c;
    }

    public static String getDiscount(long abc) {
        return "" + abc;
    }


}
