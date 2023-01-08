package demo.com.practice;

import java.util.Scanner;

public class Programmers14 {
    /**
     * 정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때,
     * array에 n이 몇 개 있는 지를 return 하도록
     * solution 함수를 완성해보세요
     *
     * 1 ≤ array의 길이 ≤ 100
     * 0 ≤ array의 원소 ≤ 1,000
     * 0 ≤ n ≤ 1,000
     */

    int parNum = 0; //매개변수
    int arr_len = 0;    //배열길이
    int[] arr;  //배열선언
    public void Solution(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("매개변수를 입력하세요: ");
        parNum = scanner.nextInt();
        System.out.println("배열의 길이를 입력해주세요");
        arr_len = scanner.nextInt();
            int count = 0;  //매개변수 중복 카운트
            for(int i=0;i<arr_len;i++){
                if(arr[i]==parNum)
                    count++;
        }
    }

}
