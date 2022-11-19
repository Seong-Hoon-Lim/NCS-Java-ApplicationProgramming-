package project;

import java.util.Scanner;

/***
 * 각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류한다.
 * 각 angle이 매개변수로 주어질 때 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 return 하도록 한다.
 */

public class Programmers3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int angle = input.nextInt();
        int result = 0;
        if ( 0 < angle && angle < 90 ) {
            result = 1;
        } else if ( angle == 90 ) {
            result = 2;
        } else if ( 90 < angle && angle < 180 ) {
            result = 3;
        } else if ( angle == 180 ) {
            result = 4;
        }
        System.out.println("각도" + " (" + angle + ")" +" 는" + result + " 이다.");
    }
}
