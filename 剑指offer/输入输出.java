import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    // 多行输入，一行输出，两次回车
    public void method1() {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        ArrayList<String> res = new ArrayList<>();
        while (nextLine != null && !"".equals(nextLine)) {
            res.add(nextLine);
            nextLine = sc.nextLine();
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }

    // 每行输入，每行输出
    public void method2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] strings = s.split(" ");
            int res = 0;
            for (int i = 1; i < strings.length; i++) {
                res += Integer.valueOf(strings[i]);
            }
            System.out.println(res);
        }

    }

    // 一行输入，一行输出
    public void method3() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n1 = Integer.parseInt(sc.nextLine());
            String[] str = sc.nextLine().split(" ");
            Arrays.sort(str);
            for (int i = 0; i < n1 - 1; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println(str[n1 - 1]);
        }
    }

}