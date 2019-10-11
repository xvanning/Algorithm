public class IpUtil {
    //先将字符串分割，转为整型数组。
    //分别分别对ip地址左移动24 16 8 0 位，进行或运算。
    public static int ipToInt(String ip) {
        int[] ipArray = new int[4];
        int i = 0;
        int num = 0;
        for (char c : ip.toCharArray()) {
            if (c != '.') {
                num *= 10;
                num += c - '0';
            } else {
                ipArray[i++] = num;
                num = 0;
            }
        }
        ipArray[i++] = num;

        int res = 0;
        for (int j = 0; j < 4; j++) {
            res |= ipArray[j] << ((3 - j) * 8);
        }
        return res;
    }

    //同上面相反，直接进行右移并且将后八位与1111 1111进行与运算。
    public static String ipToStr(int ip) {
        return ((ip >> 24) & 0xFF) + "."
                + ((ip >> 16) & 0xFF) + "."
                + ((ip >> 8) & 0xFF) + "."
                + (ip & 0xFF);
    }

    public static void main(String[] args) throws Exception {
        int ip = ipToInt("192.168.1.104");
        System.out.println(ip);
        String ipString = ipToStr(ip);
        System.out.println(ipString);
    }
}


