package org.basicexamplesentence.loop;

// 아날로그 방식 디지털 시계 구현
public class DigitalClock {
	
	public static void main(String[] args) {	
		
		int hour = 0;		
		while (hour <= 23) { // hour 23시까지 반복
			int min = 0;
			while (min <= 59) { // min 59분까지 반복
				int sec = 0;
				while (sec <= 59) { // sec 59초까지 반복
				System.out.println(hour + "시: " + min + "분: " + sec + "초");
				// Thread.sleep 사용을 위한 예외처리
				try {
					Thread.sleep(1000); // 1초에 단위로 실행
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sec++; // sec 1초씩 증가
				}
			min++; // min 1분씩 증가
				}
		hour++; // hour 1시씩 증가
		}
	}
}