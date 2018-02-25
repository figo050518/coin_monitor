package com.chelp.oop.utils.enmu;

/**

 * @ClassName: AlarmElecType

 * @Description: alarmElecType

 * @author: zhonghui.geng

 * @date: 2016年11月10日 下午2:13:29
 */
public enum AlarmElecType {
	/**
	 * 充电失败
	 */
	CHARGE_FAILED(1),
	/**
	 * 卡单
	 */
	RECORD_FAILED(2);

	private int value;

	private AlarmElecType(int value) {
	        this.value = value;
	    }
	
	public int getValue() {
	        return value;
	}
	
	public  static boolean isValid(int value){
		if(value<1 || value>5){
			return false;
		}
		return true;
	}
	
	public static AlarmElecType getByValue(int value){
		switch (value) {
		case 1:
			return AlarmElecType.CHARGE_FAILED;
		case 2:
			return AlarmElecType.RECORD_FAILED;
		default:
			return AlarmElecType.CHARGE_FAILED;
		}
	}
}

