package com.chelp.oop.utils.enmu;

/**

告警通知类型

 * @author: zhonghui.geng

 * @date: 2016年11月10日 下午2:13:29
 */
public enum AlarmNoticeType {

	/**
	 * 电池温度告警
	 */
	ALARM_BMS_TEMP(1),
	/**
	 * 单价异常
	 */
	ALARM_UNIT_PRICE(2),
	/**
	 * 电桩状态告警
	 */
	ALARM_PILE_STATUS(3),
	/**
	 *  电压电流告警
	 */
	ALARM_VOLTAGE_ELEC(4),
	/**
	 * 电桩输出告警
	 */
	ALARM_PILE_OUTPUT(5),

	/*
	充电告警
	 */
	ALARM_CHARGING(6),
	/**
	 * 卡单异常告警
	 */
	ALARM_RECORD_FAIL(7);

	private int value;

	private AlarmNoticeType(int value) {
	        this.value = value;
	    }
	
	public int getValue() {
	        return value;
	}


	public static AlarmNoticeType getByValue(int value){
		switch (value){
			case 1:
				return AlarmNoticeType.ALARM_CHARGING;
			case 2:
				return AlarmNoticeType.ALARM_BMS_TEMP;
			case 3:
				return AlarmNoticeType.ALARM_PILE_STATUS;
			case 4:
				return AlarmNoticeType.ALARM_VOLTAGE_ELEC;
			case 5:
				return AlarmNoticeType.ALARM_PILE_OUTPUT;
			case 6:
				return AlarmNoticeType.ALARM_UNIT_PRICE;
			case 7:
				return AlarmNoticeType.ALARM_RECORD_FAIL;
		}
		return null;

	}
	
	public static AlarmNoticeType getByValue(int value,AlarmSourceTable table){
		switch (table.getValue()) {
		case 1:
			//状态异常
			return AlarmNoticeType.ALARM_PILE_STATUS;
		case 2:
			//卡单异常
			if(value==AlarmElecType.RECORD_FAILED.getValue()){
				return AlarmNoticeType.ALARM_RECORD_FAIL;
			}
		case 3:
			//单价异常
			if(value==AlarmExLogType.PRICE_EX.getValue()){
				return AlarmNoticeType.ALARM_UNIT_PRICE;
			}
			//电桩输出
			if(value==AlarmExLogType.PILE_OUTPU_EX.getValue()){
				return AlarmNoticeType.ALARM_PILE_OUTPUT;
			}
			//电压电流
			if(value==AlarmExLogType.PILEAV_EX.getValue()){
				return AlarmNoticeType.ALARM_VOLTAGE_ELEC;
			}
			//电池温度
			if(value==AlarmExLogType.TEMP_EX.getValue()){
				return AlarmNoticeType.ALARM_BMS_TEMP;
			}
		case 4:
			return AlarmNoticeType.ALARM_CHARGING;
		default:
			return null;
		}
	}
}

