package com.chelp.oop.utils.enmu;

/**

告警来源类 ： 告警目前来源于三张表

 * @author: zhonghui.geng

 * @date: 2016年11月10日 下午2:13:29
 */
public enum AlarmSourceTable {
	/*
	状态告警来源
	 */
	PILE_STATUS_EX(1),
	/**
	 * 卡单 充电失败
	 */
	ALARM_ELEC(2),
	/**
	 * 各种其他告警来源
	 */
	ALARM_EX_LOG(3),
	/**
	 * 这个值用来表示充电告警，充电告警由 BMS+充电失败组成
	 */
	ALARM_CHARGING(4);

	private int value;

	private AlarmSourceTable(int value) {
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
	
	public static AlarmSourceTable getByValue(int value){
		switch (value) {
		case 1:
			return AlarmSourceTable.PILE_STATUS_EX;
		case 2:
			return AlarmSourceTable.ALARM_ELEC;
		default:
			return AlarmSourceTable.ALARM_EX_LOG;
		}
	}
}

