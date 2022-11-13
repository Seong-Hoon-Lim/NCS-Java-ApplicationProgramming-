package project;

//머쓱이는 40살인 선생님이 몇 년도에 태어났는지 궁금해졌습니다. 나이 age가 주어질 때,
//    2022년을 기준 출생 연도를 return 하도록 한다.

import java.util.Scanner;

public class Programmers2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();
        int year = (2022 - age) + 1;
        System.out.println(age + "살 은 " + year + "년생 입니다.");


    }
}
