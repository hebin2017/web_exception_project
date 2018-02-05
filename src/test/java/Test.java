import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/7/28.
 */
public class Test {
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
    public static void main(String[] args) {
        String json="[{\"taskID\":\"xi15p0j7\",\"mobile\":\"13720169804\",\"status\":\"4\",\"reportTime\":\"Fri Jul 28 13:39:28 CST 2017\",\"reportCode\":\"≥‰÷µ≥…π¶\",\"outTradeNo\":null}]";
        System.out.println(new BigDecimal(sub(111111111111111111111111111111111.00,111111111111152412.00)));
    }
}
