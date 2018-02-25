/*gengzhonghui  start*/
/*tradeSeq添加索引*/
ALTER TABLE `charging_record_history` ADD  INDEX `trade_index_` (`trade_seq`(20)) USING BTREE;
CREATE TABLE `oop_district` (
  `code` varchar(40) NOT NULL COMMENT '编码',
  `acronym` varchar(20) DEFAULT NULL COMMENT '缩写',
  `level` varchar(1) NOT NULL COMMENT '级别',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `pcode` varchar(40) NOT NULL COMMENT '父级',
  `status` char(1) NOT NULL COMMENT '0 可用 1不可用'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oop_role_user` (
  `uid` VARCHAR(64) NOT NULL COMMENT '用户ID',
  `role_id` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`uid`,`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `oop_role` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `office_id` varchar(64) NOT NULL COMMENT '角色所属机构ID',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `create_id` varchar(64) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_id` varchar(64) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '0 未删除  1 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `oop_role_data` (
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `data_id` varchar(64) NOT NULL COMMENT '数据权限ID，机构ID/站点ID',
  `type` char(1) NOT NULL COMMENT '1 机构 2 站点'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oop_role_menu` (
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单ID',
  `type` char(1) DEFAULT NULL COMMENT '类型：1 web菜单 2 app菜单'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oop_menu` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '菜单名称',
  `acronym` varchar(200) NOT NULL COMMENT '首字母缩写',
  `href` varchar(255) DEFAULT NULL COMMENT '链接',
  `sort` int(11) NOT NULL COMMENT '排序（升序）',
  `level` int(2) NOT NULL COMMENT '级别',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `type` char(1) NOT NULL COMMENT '1 web菜单 2 app菜单',
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`),
  KEY `sys_menu_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';


insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('1','0','首页','web_index','overview_standard.html','1','1','1','1','2017-05-24 11:30:41','1','2017-05-24 11:30:43',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('10','6','实时订单','web_station_cur_order',NULL,'1','3','1','1','2017-05-24 11:47:47','1','2017-05-24 11:47:50',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('11','6','历史订单','web_station_history_order',NULL,'2','3','1','1','2017-05-24 11:49:03','1','2017-05-24 11:49:09',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('12','6','待处理订单','web_station_pending_order',NULL,'3','3','1','1','2017-05-24 11:49:05','1','2017-05-24 11:49:11',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('13','7','实时订单','web_charging_cur_order',NULL,'1','3','1','1','2017-05-24 11:52:22','1','2017-05-24 11:52:25',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('14','7','历史订单','web_charging_history_order',NULL,'2','3','1','1','2017-05-24 11:52:56','1','2017-05-24 11:52:58',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('15','8','统计总览','web_stat_station_all',NULL,'1','3','1','1','2017-05-25 11:12:12','1','2017-05-25 11:12:15',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('16','8','按电站统计','web_stat_station_count',NULL,'2','3','1','1','2017-05-24 13:38:42','1','2017-05-24 13:38:44',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('17','8','按电桩统计','web_stat_station_pile',NULL,'3','3','1','1','2017-05-24 13:40:26','1','2017-05-24 13:40:29',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('18','8','电桩故障统计','web_stat_station_alarm',NULL,'4','3','1','1','2017-05-24 13:40:57','1','2017-05-24 13:41:03',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('19','9','统计总览','web_stat_charging_all',NULL,'1','3','1','1','2017-05-24 13:44:22','1','2017-05-24 13:44:24',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('2','0','订单中心','web_order','order_center.html','2','1','1','1','2017-05-24 11:37:46','1','2017-05-24 11:37:49',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('20','9','按机构统计','web_stat_charging_office',NULL,'2','3','1','1','2017-05-24 13:46:09','1','2017-05-24 13:46:14',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('21','9','按用户统计','web_stat_charging_user',NULL,'3','3','1','1','2017-05-24 13:46:11','1','2017-05-24 13:46:16',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('22','0','首页','app_index',NULL,'1','1','1','1','2017-05-24 13:47:15','1','2017-05-24 13:47:18',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('23','0','订单中心','app_order',NULL,'2','1','1','1','2017-05-24 13:47:45','1','2017-05-24 13:47:49',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('24','0','统计分析','app_stat',NULL,'3','1','1','1','2017-05-24 13:48:14','1','2017-05-24 13:48:17',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('25','0','个人中心','app_uc',NULL,'4','1','1','1','2017-05-24 13:48:44','1','2017-05-24 13:48:47',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('26','22','我的电站','app_index_station',NULL,'1','2','1','1','2017-05-24 13:49:28','1','2017-05-24 13:49:30',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('27','22','我的充电','app_index_charging',NULL,'2','2','1','1','2017-05-24 13:50:15','1','2017-05-24 13:50:18',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('28','23','我的电站','app_order_station',NULL,'1','2','1','1','2017-05-24 13:50:49','1','2017-05-24 13:50:52',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('29','23','我的充电','app_order_charging',NULL,'2','2','1','1','2017-05-24 13:51:18','1','2017-05-24 13:51:21',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('3','0','统计分析','web_stat','statistics.html','3','1','1','1','2017-05-24 11:38:53','1','2017-05-24 11:38:56',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('30','24','我的电站','app_stat_station',NULL,'1','2','1','1','2017-05-24 13:53:10','1','2017-05-24 13:53:20',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('31','24','我的充电','app_stat_charging',NULL,'2','2','1','1','2017-05-24 13:53:12','1','2017-05-24 13:53:22',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('32','25','我的电站','app_uc_station',NULL,'1','2','1','1','2017-05-24 13:53:13','1','2017-05-24 13:53:24',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('33','25','我的充电','app_uc_charging',NULL,'2','2','1','1','2017-05-24 13:53:15','1','2017-05-24 13:53:25',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('34','28','实时订单','app_order_station_cur',NULL,'1','3','1','1','2017-05-24 13:55:08','1','2017-05-24 13:55:12',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('35','28','历史订单','app_order_station_history',NULL,'2','3','1','1','2017-05-24 13:55:10','1','2017-05-24 13:55:14',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('36','29','实时订单','app_order_charging_cur',NULL,'1','3','1','1','2017-05-24 13:56:23','1','2017-05-24 13:56:31',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('37','29','历史订单','app_order_charging_history',NULL,'2','3','1','1','2017-05-24 13:56:25','1','2017-05-24 13:56:32',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('38','32','安全中心','app_uc_station_security',NULL,'1','3','1','1','2017-05-24 13:57:28','1','2017-05-24 13:57:31',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('39','32','我的电站','app_uc_station_count',NULL,'2','3','1','1','2017-05-24 13:57:53','1','2017-05-24 13:57:57',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('4','1','我的电站','web_index_station',NULL,'1','2','1','1','2017-05-24 11:39:33','1','2017-05-24 11:39:36',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('40','33','安全中心','app_uc_charging_security',NULL,'1','3','1','1','2017-05-24 13:59:51','1','2017-05-24 14:00:04',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('41','33','我的机构','app_uc_charging_office',NULL,'2','3','1','1','2017-05-24 13:59:53','1','2017-05-24 14:00:06',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('42','33','我的员工','app_uc_charging_employee',NULL,'3','3','1',NULL,'2017-05-24 13:59:55','1','2017-05-24 14:00:09',NULL,'0','2');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('5','1','我的充电','web_index_charging',NULL,'2','2','1','1','2017-05-24 11:40:12','1','2017-05-24 11:40:15',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('6','2','我的电站','web_order_station',NULL,'1','2','1','1','2017-05-24 11:41:15','1','2017-05-24 11:41:18',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('7','2','我的充电','web_order_charging',NULL,'2','2','1','1','2017-05-24 11:41:51','1','2017-05-24 11:41:55',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('8','3','我的电站','web_stat_station',NULL,'1','2','1','1','2017-05-24 11:42:36','1','2017-05-24 11:42:39',NULL,'0','1');
insert into `oop_menu` (`id`, `parent_id`, `name`, `acronym`, `href`, `sort`, `level`, `is_show`, `create_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`, `type`) values('9','3','我的充电','web_stat_charging',NULL,'2','2','1','1','2017-05-24 11:43:12','1','2017-05-24 11:43:16',NULL,'0','1');


-- INSERT INTO oop_district (CODE,acronym,LEVEL,NAME,pcode,STATUS) (SELECT (CODE+1),NULL,"3" , "市辖区" ,CODE,STATUS FROM oop_district t WHERE t.level =2);
--
-- UPDATE oop_district t SET t.pcode  =  (t.pcode +100 ) WHERE t.pcode IN (110000,120000,310000,500000);
--
-- INSERT INTO oop_district (CODE,acronym,LEVEL,NAME,pcode,STATUS) (SELECT (CODE+100),NULL ,"2" , "市辖区" ,CODE,STATUS FROM oop_district t WHERE t.name IN ('北京市','天津市','上海市','重庆市'));

 /*gengzhonghui  end*/

