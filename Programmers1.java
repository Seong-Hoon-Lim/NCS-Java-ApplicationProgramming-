package project;

//정수 2개 가 매개변수로 주어질 때, numa를 numb로 연산 한 값을 return 한다.


import java.util.Scanner;

public class Programmers1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int result1 = (num1 / num2);
        System.out.println(num1 + "/" + num2 + "=" + result1);

        int num3 = input.nextInt();
        int num4 = input.nextInt();
        int result2 = (num3 * num4);
        System.out.println(num3 + "*" + num4 + "=" + result2);

        int num5 = input.nextInt();
        int num6 = input.nextInt();
        int result3 = (num5 - num6);
        System.out.println(num5 + "-" + num6 + "=" + result3);

        int num7 = input.nextInt();
        int num8 = input.nextInt();
        int result4 = (num5 % num6);
        System.out.println(num7 + "%" + num8 + "=" + result4);

        int num9 = input.nextInt();
        int num10 = input.nextInt();
        boolean result5 = num9 == num10;
        System.out.println(num9 + "==" + num10 + "=" + result5);


    }
}
