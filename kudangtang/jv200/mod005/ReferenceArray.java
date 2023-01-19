package com.kudangtang.jv200.mod005;

public class ReferenceArray {
	public static void main(String[] args) {
		Point[] points;
		points = new Point[3];
		points[0] = new Point(0, 1);
		points[1] = new Point(3, 5);
		points[2] = new Point(7, 10);
		
		Point[] points2 = new Point[] {new Point(0, 1), new Point(3, 5), new Point(7, 10)};
		for(int i = 0; i < points.length; i++) {
			System.out.println("[" + i + "] = " + (points[i] == points2[i]));
		}
	}
}
