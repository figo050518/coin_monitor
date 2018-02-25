/*角色表新增 创建人机构  主题*/
ALTER TABLE oop_role ADD COLUMN create_office_id VARCHAR(64) NULL;
ALTER TABLE oop_role ADD COLUMN subject_id  VARCHAR(64) NULL DEFAULT '1';


/*创建用户数据权限表*/
CREATE TABLE `oop_user_data` (
  `user_id` VARCHAR(64) NOT NULL COMMENT '用户ID',
  `data_id` VARCHAR(64) NOT NULL COMMENT '数据权限ID，机构ID/站点ID',
  `type` CHAR(1) NOT NULL COMMENT '1 机构 2 站点'
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*角色表添加 数据权限范围字段*/
ALTER TABLE oop_role ADD COLUMN data_auth CHAR(1) NOT NULL DEFAULT '0'


ALTER TABLE oop_role ADD COLUMN office_data_auth CHAR(1)  NULL DEFAULT '0';
ALTER TABLE oop_role ADD COLUMN station_data_auth CHAR(1)  NULL DEFAULT '0';


ALTER TABLE oop_menu ADD COLUMN is_button CHAR(1) NOT NULL DEFAULT '0';

ALTER TABLE oop_role ADD COLUMN base_user_id VARCHAR(64) NOT NULL ;

/*初始化thinkgem权限*/
INSERT INTO `oop_role` (`id`, `office_id`, `name`, `create_id`, `create_time`, `update_id`, `update_time`, `remarks`, `del_flag`, `create_office_id`, `subject_id`, `data_auth`, `office_data_auth`, `station_data_auth`, `base_user_id`) VALUES('1','1','超级管理员','1','2017-05-16 17:56:05','1','2017-05-17 09:48:37','备注','0','1','1','0','0','0','');
INSERT INTO oop_role_user(uid,role_id)VALUES(1,1);
INSERT INTO oop_role_menu(role_id,menu_id,TYPE)(SELECT "1",m.id,m.type FROM oop_menu m);
INSERT INTO oop_user_data(user_id,data_id,TYPE)(SELECT "1",s.id,"1" FROM sys_office s );
INSERT INTO oop_user_data(user_id,data_id,TYPE)(SELECT "1",s.id,"2" FROM charging_station s );

ALTER TABLE sys_user ADD COLUMN auth_update_date DATETIME NULL COMMENT '账号权限更新时间';



INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('45','0','安全中心','warn_center','warn_center.html','4','1','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('46','45','我的充电告警','charging_alarm','charging_alarm.html','1','2','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('47','45','我的电站告警','station_alarm','station_alarm.html','2','2','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('48','45','告警配置','alarm_config','alarm_config.html','3','2','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 /*我的充电*/
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('49','46','告警监控','charging_alarm_monitor','charging_alarm_monitor.html','1','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('50','46','充电告警','charging_charging_alarm','charging_charging_alarm.html','2','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('51','46','电池温度','charging_temp_alarm','charging_temp_alarm.html','3','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 /*我的电站*/
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('52','47','告警监控','station_alarm_monitor','station_alarm_monitor.html','1','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('53','47','充电告警','station_charging_alarm','station_charging_alarm.html','2','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('54','47','电池温度','station_temp_alarm','station_temp_alarm.html','3','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');

  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('55','47','电桩状态','station_alarm_status','station_alarm_status.html','4','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('56','47','电压电流','station_alarm_pileAV','station_alarm_pileAV.html','5','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('57','47','电桩输出','station_alarm_pileout','station_alarm_pileout.html','6','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('58','47','充电卡单','station_alarm_recordFail','station_alarm_recordFail.html','7','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('59','47','单价异常','station_alarm_price','station_alarm_price.html','8','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');

 /*告警配置*/
  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('60','48','告警通知设置','alarm_notice','alarm_notice.html','1','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('61','48','告警阈值设置','alarm_threshold','alarm_threshold.html','2','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
 /*运营管理*/
 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('62','0','运营管理','operation_management','operation_manage.html','5','1','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');

  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('63','62','权限管理','authoryty_management','authoryty_manage.html','1','2','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');

 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('64','63','角色列表','authoryty_management','authoryty_manage.html','1','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');

  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`,`is_button`)
 VALUES('65','64','角色新增','add_role','/oop/role/api/add','1','4','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1','1');
  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`,`is_button`)
 VALUES('66','64','角色分配','allot_role','/oop/role/api/allot','2','4','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1','1');
  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`,`is_button`)
 VALUES('67','64','角色查看','view_role','/oop/role/api/view','3','4','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1','1');

 INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`)
 VALUES('68','63','账号列表','account_list','account_list.html','2','3','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
  INSERT INTO `oop_menu`
(`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`,`is_button`)
 VALUES('69','68','数据权限分配','data_allot','/oop/role/api/saveRoleUser','3','4','0','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1','1');