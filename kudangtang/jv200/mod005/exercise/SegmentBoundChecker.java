package com.kudangtang.jv200.mod005.exercise;

public class SegmentBoundChecker {
	
	/**
	 *  target이 base의 범위 내에 존재하는 지 리턴
	 *  base) 	|------------------|
	 * 	target)		|-------------|
	 * 
	 * @param target
	 * @param base
	 * @return
	 */
	public boolean inBound(int[] target, int[] base) {
		if(target[0] >= base[0] && target[1] <= base[1]) {
			return true;
		}
		return false;
	}
	
	/**
	 * target의 일부가 base에 포함되면서 동시에 일부가 base의 범위를 초과하는지 리턴
	 * 
	 * 	base) 	|------------------|
	 * 	target)			|----------------|
	 * 
	 * @param target
	 * @param base
	 * @return
	 */
	public boolean overBound(int[] target, int[] base) {
		return false;
	}
	
	/**
	 * target의 일부가 base에 포함되면 동시에 일부가 base의 범위보다 작은지 여부를 리턴
	 * 	base) 		|------------------|
	 * 	target)	|----------------|
	 * 
	 * @param target
	 * @param base
	 * @return
	 */
	public boolean underBound(int[] target, int[] base) {
		return false;
	}
	
	/**
	 * target이 base의 범위 밖에 있는지 여부를 리턴
	 * 	base) 			|---------------|
	 * 	target)	|-----|					  |-----|
	 * 
	 * @param target
	 * @param base
	 * @return
	 */
	public boolean outBound(int[] target, int[] base) {
		return false;
	}
}
