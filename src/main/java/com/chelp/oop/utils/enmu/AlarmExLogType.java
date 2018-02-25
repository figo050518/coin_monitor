package com.chelp.oop.utils.enmu;

/**

 * @ClassName: AlarmExLogType

 * @Description: AlarmExLogType

 * @author: zhonghui.geng

 * @date: 2016年11月10日 下午2:13:29
 */
public enum AlarmExLogType {
	/**
	 * BMS 异常
	 */
	BMS_EX(1),
	/**
	 * 单价异常
	 */
	PRICE_EX(2),
	/**
	 * 电桩输出
	 */
	PILE_OUTPU_EX(3),
	/**
	 * 电压电流
	 */
	PILEAV_EX(4),
	/**
	 * 温度告警
	 */
	TEMP_EX(5);

	private int value;

	private AlarmExLogType(int value) {
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
	
	public static AlarmExLogType getByValue(int value){
		switch (value) {
		case 1:
			return AlarmExLogType.BMS_EX;
		case 2:
			return AlarmExLogType.PRICE_EX;
		case 3:
			return AlarmExLogType.PILE_OUTPU_EX;
		case 4:
			return AlarmExLogType.PILEAV_EX;
		case 5:
			return AlarmExLogType.TEMP_EX;
		default:
			return AlarmExLogType.BMS_EX;
		}
	}
}

