#1左侧模块表
CREATE TABLE t_module ( 
	moduleid INT auto_increment PRIMARY KEY NOT NULL, #模块编号
	modulename VARCHAR (100) #模块名称
) ENGINE = INNODB DEFAULT charset = utf8;

INSERT INTO t_module VALUES (NULL, '组织结构');

INSERT INTO t_module VALUES (NULL, '职称设置');

INSERT INTO t_module VALUES (NULL, '岗位结构');

INSERT INTO t_module VALUES (NULL, '员工管理');

INSERT INTO t_module VALUES (NULL, '权限中心');

INSERT INTO t_module VALUES (NULL, '修改密码');

INSERT INTO t_module VALUES (NULL, '汽车品牌');

INSERT INTO t_module VALUES (NULL, '汽车系列');

INSERT INTO t_module VALUES (NULL, '汽车赠品');

INSERT INTO t_module VALUES (NULL, '存储仓库');

INSERT INTO t_module VALUES (NULL, '采购申请');

INSERT INTO t_module VALUES (NULL, '赠品入库');

INSERT INTO t_module VALUES (NULL, '赠品出库');

INSERT INTO t_module VALUES (NULL, '车辆入库');

INSERT INTO t_module VALUES (NULL, '车辆出库');

INSERT INTO t_module VALUES (NULL, '客户管理');

INSERT INTO t_module VALUES (NULL, '销售统计');

INSERT INTO t_module VALUES (NULL, '售后管理');

#2模块具体动作表
CREATE TABLE t_action ( actionid INT auto_increment PRIMARY KEY NOT NULL, #动作编号
moduleid INT, #模块编号（外键1）
actionname VARCHAR (100), #动作名称
action VARCHAR (50), #动作对应的字符串
viewmode INT #是否可见
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_action ADD CONSTRAINT actioncolumnidk1_check FOREIGN KEY (moduleid) REFERENCES t_module (moduleid);

INSERT INTO t_action VALUES ( NULL, 1, '查询组织结构', 'getdept', 1 );

INSERT INTO t_action VALUES ( NULL, 1, '增加组织结构', 'adddept', 1 );

INSERT INTO t_action VALUES ( NULL, 1, '修改组织结构', 'uppdept', 1 );

INSERT INTO t_action VALUES ( NULL, 2, '查询职称设置', 'getzc', 1 );

INSERT INTO t_action VALUES ( NULL, 2, '增加职称设置', 'addzc', 1 );

INSERT INTO t_action VALUES ( NULL, 2, '修改职称设置', 'uppzc', 1 );

INSERT INTO t_action VALUES ( NULL, 3, '查询岗位结构', 'getgw', 1 );

INSERT INTO t_action VALUES ( NULL, 3, '增加岗位结构', 'addgw', 1 );

INSERT INTO t_action VALUES ( NULL, 3, '修改岗位结构', 'uppgw', 1 );

INSERT INTO t_action VALUES ( NULL, 4, '查询员工管理', 'getmaster', 1 );

INSERT INTO t_action VALUES ( NULL, 4, '增加员工管理', 'addmaster', 1 );

INSERT INTO t_action VALUES ( NULL, 4, '修改员工管理', 'uppmaster', 1 );

INSERT INTO t_action VALUES ( NULL, 4, '设置员工权限', 'setmaster', 1 );

INSERT INTO t_action VALUES ( NULL, 5, '查询系统模块', 'getactioncolum', 1 );

INSERT INTO t_action VALUES ( NULL, 5, '查询模块具体操作', 'getaction', 1 );

INSERT INTO t_action VALUES ( NULL, 5, '查询用户组设置', 'getgroupmanager', 1 );

INSERT INTO t_action VALUES ( NULL, 5, '修改用户组设置', 'uppgroupmanager', 1 );

INSERT INTO t_action VALUES ( NULL, 5, '查询用户权限设计', 'getqx', 1 );

INSERT INTO t_action VALUES ( NULL, 5, '修改用户权限设计', 'uppqx', 1 );

INSERT INTO t_action VALUES ( NULL, 7, '查询汽车品牌', 'getsort', 1 );

INSERT INTO t_action VALUES ( NULL, 7, '增加汽车品牌', 'addsort', 1 );

INSERT INTO t_action VALUES ( NULL, 7, '修改汽车品牌', 'uppsort', 1 );

INSERT INTO t_action VALUES ( NULL, 8, '查询汽车系列', 'getdetail', 1 );

INSERT INTO t_action VALUES ( NULL, 8, '增加汽车系列', 'adddetail', 1 );

INSERT INTO t_action VALUES ( NULL, 8, '修改汽车系列', 'uppdetail', 1 );

INSERT INTO t_action VALUES ( NULL, 9, '查询汽车赠品', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 9, '增加汽车赠品', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 9, '修改汽车赠品', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 10, '查询存储仓库', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 10, '增加存储仓库', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 10, '修改存储仓库', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 11, '查询采购申请', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 11, '增加采购申请', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 11, '修改采购申请', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 11, '发送采购申请', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 12, '查询赠品入库', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 12, '增加赠品入库', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 12, '修改赠品入库', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 13, '查询赠品出卖出库', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 13, '增加赠品出卖出库', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 13, '修改赠品出卖出库', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 13, '查询赠送出库', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 14, '查询车辆入库', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 14, '增加车辆入库', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 14, '修改车辆入库', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 14, '查询车辆入库明细', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 14, '增加车辆入库明细', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 14, '修改车辆入库明细', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 15, '查询车辆出库', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 15, '增加车辆出库', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 15, '修改车辆出库', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 16, '查询客户管理', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 16, '增加客户管理', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 16, '修改客户管理', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 17, '查询销售统计', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 17, '查询汽车销售统计', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 17, '查询赠品销售统计', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 18, '查询售后管理', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 18, '增加售后管理', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 18, '修改售后管理', 'upphandout', 1 );

INSERT INTO t_action VALUES ( NULL, 18, '查询售后明细管理', 'gethandout', 1 );

INSERT INTO t_action VALUES ( NULL, 18, '增加售后明细管理', 'addhandout', 1 );

INSERT INTO t_action VALUES ( NULL, 18, '修改售后明细管理', 'upphandout', 1 );

#3管理组表
CREATE TABLE t_group ( groupid INT auto_increment PRIMARY KEY NOT NULL, #管理组编号(主键)
groupname VARCHAR (100), #管理组名称
groupinfo VARCHAR (100) #管理级信息
) ENGINE = INNODB DEFAULT charset = utf8;

INSERT INTO t_group VALUES ( NULL, '系统管理员角色（组）', '系统管理员角色（组）' );

INSERT INTO t_group VALUES ( NULL, '各销售点总经理管理角色（组）', '各销售点总经理管理角色（组）' );

INSERT INTO t_group VALUES ( NULL, '各销售组经理管理角色（组）', '各销售组经理管理角色（组）' );

INSERT INTO t_group VALUES ( NULL, '各销售组普通员工角色（组）', '各销售组普通员工角色（组）' );

#4动作所在组记录表
CREATE TABLE t_agroup ( actiongroupid INT auto_increment PRIMARY KEY NOT NULL, #动作所在组编号(主键)
actionid INT, #编号所属模块具体动作ID（外键1）
groupid INT #动作所属管理组ID（外键2）
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_agroup ADD CONSTRAINT actionidk2_check FOREIGN KEY (actionid) REFERENCES t_action (actionid);

ALTER TABLE t_agroup ADD CONSTRAINT groupidk3_check FOREIGN KEY (groupid) REFERENCES t_group (groupid);

INSERT INTO t_agroup VALUES (NULL, 1, 1);

INSERT INTO t_agroup VALUES (NULL, 2, 1);

INSERT INTO t_agroup VALUES (NULL, 3, 1);

INSERT INTO t_agroup VALUES (NULL, 4, 1);

INSERT INTO t_agroup VALUES (NULL, 5, 1);

INSERT INTO t_agroup VALUES (NULL, 6, 1);

INSERT INTO t_agroup VALUES (NULL, 7, 1);

INSERT INTO t_agroup VALUES (NULL, 8, 1);

INSERT INTO t_agroup VALUES (NULL, 9, 1);

INSERT INTO t_agroup VALUES (NULL, 10, 1);

INSERT INTO t_agroup VALUES (NULL, 11, 1);

INSERT INTO t_agroup VALUES (NULL, 12, 1);

INSERT INTO t_agroup VALUES (NULL, 13, 1);

INSERT INTO t_agroup VALUES (NULL, 14, 1);

INSERT INTO t_agroup VALUES (NULL, 15, 1);

INSERT INTO t_agroup VALUES (NULL, 16, 1);

INSERT INTO t_agroup VALUES (NULL, 17, 1);

INSERT INTO t_agroup VALUES (NULL, 18, 1);

INSERT INTO t_agroup VALUES (NULL, 19, 1);

INSERT INTO t_agroup VALUES (NULL, 20, 1);

INSERT INTO t_agroup VALUES (NULL, 21, 1);

INSERT INTO t_agroup VALUES (NULL, 22, 1);

INSERT INTO t_agroup VALUES (NULL, 23, 1);

INSERT INTO t_agroup VALUES (NULL, 24, 1);

INSERT INTO t_agroup VALUES (NULL, 25, 1);

INSERT INTO t_agroup VALUES (NULL, 26, 1);

INSERT INTO t_agroup VALUES (NULL, 27, 1);

INSERT INTO t_agroup VALUES (NULL, 28, 1);

INSERT INTO t_agroup VALUES (NULL, 29, 1);

INSERT INTO t_agroup VALUES (NULL, 30, 1);

INSERT INTO t_agroup VALUES (NULL, 31, 1);

INSERT INTO t_agroup VALUES (NULL, 32, 1);

INSERT INTO t_agroup VALUES (NULL, 33, 1);

INSERT INTO t_agroup VALUES (NULL, 34, 1);

INSERT INTO t_agroup VALUES (NULL, 35, 1);

INSERT INTO t_agroup VALUES (NULL, 36, 1);

INSERT INTO t_agroup VALUES (NULL, 37, 1);

INSERT INTO t_agroup VALUES (NULL, 38, 1);

INSERT INTO t_agroup VALUES (NULL, 39, 1);

INSERT INTO t_agroup VALUES (NULL, 40, 1);

INSERT INTO t_agroup VALUES (NULL, 41, 1);

INSERT INTO t_agroup VALUES (NULL, 42, 1);

INSERT INTO t_agroup VALUES (NULL, 43, 1);

INSERT INTO t_agroup VALUES (NULL, 44, 1);

INSERT INTO t_agroup VALUES (NULL, 45, 1);

INSERT INTO t_agroup VALUES (NULL, 46, 1);

INSERT INTO t_agroup VALUES (NULL, 47, 1);

INSERT INTO t_agroup VALUES (NULL, 48, 1);

INSERT INTO t_agroup VALUES (NULL, 49, 1);

INSERT INTO t_agroup VALUES (NULL, 50, 1);

INSERT INTO t_agroup VALUES (NULL, 51, 1);

INSERT INTO t_agroup VALUES (NULL, 52, 1);

INSERT INTO t_agroup VALUES (NULL, 53, 1);

INSERT INTO t_agroup VALUES (NULL, 54, 1);

INSERT INTO t_agroup VALUES (NULL, 55, 1);

INSERT INTO t_agroup VALUES (NULL, 56, 1);

INSERT INTO t_agroup VALUES (NULL, 57, 1);

INSERT INTO t_agroup VALUES (NULL, 58, 1);

INSERT INTO t_agroup VALUES (NULL, 59, 1);

INSERT INTO t_agroup VALUES (NULL, 60, 1);

INSERT INTO t_agroup VALUES (NULL, 61, 1);

INSERT INTO t_agroup VALUES (NULL, 62, 1);

INSERT INTO t_agroup VALUES (NULL, 63, 1);


INSERT INTO t_agroup VALUES (NULL, 1, 2);

INSERT INTO t_agroup VALUES (NULL, 2, 2);

INSERT INTO t_agroup VALUES (NULL, 3, 2);

INSERT INTO t_agroup VALUES (NULL, 4, 2);

INSERT INTO t_agroup VALUES (NULL, 5, 2);

INSERT INTO t_agroup VALUES (NULL, 6, 2);

INSERT INTO t_agroup VALUES (NULL, 7, 2);

INSERT INTO t_agroup VALUES (NULL, 8, 2);

INSERT INTO t_agroup VALUES (NULL, 9, 2);

INSERT INTO t_agroup VALUES (NULL, 10, 2);

INSERT INTO t_agroup VALUES (NULL, 11, 2);

INSERT INTO t_agroup VALUES (NULL, 12, 2);

INSERT INTO t_agroup VALUES (NULL, 13, 2);

INSERT INTO t_agroup VALUES (NULL, 14, 2);

INSERT INTO t_agroup VALUES (NULL, 15, 2);

INSERT INTO t_agroup VALUES (NULL, 16, 2);

INSERT INTO t_agroup VALUES (NULL, 17, 2);

INSERT INTO t_agroup VALUES (NULL, 18, 2);

INSERT INTO t_agroup VALUES (NULL, 19, 2);

INSERT INTO t_agroup VALUES (NULL, 20, 2);

INSERT INTO t_agroup VALUES (NULL, 21, 2);

INSERT INTO t_agroup VALUES (NULL, 22, 2);

INSERT INTO t_agroup VALUES (NULL, 23, 2);

INSERT INTO t_agroup VALUES (NULL, 24, 2);

INSERT INTO t_agroup VALUES (NULL, 25, 2);

INSERT INTO t_agroup VALUES (NULL, 26, 2);

INSERT INTO t_agroup VALUES (NULL, 27, 2);

INSERT INTO t_agroup VALUES (NULL, 28, 2);

INSERT INTO t_agroup VALUES (NULL, 29, 2);

INSERT INTO t_agroup VALUES (NULL, 30, 2);

INSERT INTO t_agroup VALUES (NULL, 31, 2);

INSERT INTO t_agroup VALUES (NULL, 32, 2);

INSERT INTO t_agroup VALUES (NULL, 33, 2);

INSERT INTO t_agroup VALUES (NULL, 34, 2);

INSERT INTO t_agroup VALUES (NULL, 35, 2);

INSERT INTO t_agroup VALUES (NULL, 36, 2);

INSERT INTO t_agroup VALUES (NULL, 37, 2);

INSERT INTO t_agroup VALUES (NULL, 38, 2);

INSERT INTO t_agroup VALUES (NULL, 39, 2);

INSERT INTO t_agroup VALUES (NULL, 40, 2);

INSERT INTO t_agroup VALUES (NULL, 41, 2);

INSERT INTO t_agroup VALUES (NULL, 42, 2);

INSERT INTO t_agroup VALUES (NULL, 43, 2);

INSERT INTO t_agroup VALUES (NULL, 44, 2);

INSERT INTO t_agroup VALUES (NULL, 45, 2);

INSERT INTO t_agroup VALUES (NULL, 46, 2);

INSERT INTO t_agroup VALUES (NULL, 47, 2);

INSERT INTO t_agroup VALUES (NULL, 48, 2);

INSERT INTO t_agroup VALUES (NULL, 49, 2);

INSERT INTO t_agroup VALUES (NULL, 50, 2);

INSERT INTO t_agroup VALUES (NULL, 51, 2);

INSERT INTO t_agroup VALUES (NULL, 52, 2);

INSERT INTO t_agroup VALUES (NULL, 53, 2);

INSERT INTO t_agroup VALUES (NULL, 54, 2);

INSERT INTO t_agroup VALUES (NULL, 55, 2);

INSERT INTO t_agroup VALUES (NULL, 56, 2);

INSERT INTO t_agroup VALUES (NULL, 57, 2);

INSERT INTO t_agroup VALUES (NULL, 58, 2);

INSERT INTO t_agroup VALUES (NULL, 59, 2);

INSERT INTO t_agroup VALUES (NULL, 60, 2);

INSERT INTO t_agroup VALUES (NULL, 61, 2);

INSERT INTO t_agroup VALUES (NULL, 62, 2);

INSERT INTO t_agroup VALUES (NULL, 63, 2);

#*******************************************************************************************************************
CREATE TABLE t_part ( p_id INT auto_increment NOT NULL PRIMARY KEY, sjid INT, zjid INT, zjmc VARCHAR (50), zjjs VARCHAR (50));

INSERT INTO `t_part` VALUES ( NULL, '-1', '0', '江西骏马武汉分公司', '江西骏马武汉分公司' );

INSERT INTO `t_part` VALUES ( NULL, '0', '1', '分公司总部', '分公司总部' );

INSERT INTO `t_part` VALUES ( NULL, '0', '2', '花山软件新城销售点', '花山软件新城销售点' );

INSERT INTO `t_part` VALUES ( NULL, '0', '3', '洪山光谷销售点', '洪山光谷销售点' );

INSERT INTO `t_part` VALUES ( NULL, '2', '4', '新城总经办', '新城总经办' );

INSERT INTO `t_part` VALUES ( NULL, '2', '5', '新城销售一部', '新城销售一部' );

INSERT INTO `t_part` VALUES ( NULL, '2', '6', '新城销售二部', '新城销售二部' );

INSERT INTO `t_part` VALUES ( NULL, '2', '7', '新城财务部', '财务部' );

INSERT INTO `t_part` VALUES ( NULL, '2', '8', '新城仓管部', '新城仓管部' );

INSERT INTO `t_part` VALUES ( NULL, '3', '9', '光谷总经办', '光谷总经办' );

INSERT INTO `t_part` VALUES ( NULL, '3', '10', '光谷销售一部', '光谷销售一部' );

INSERT INTO `t_part` VALUES ( NULL, '3', '11', '光谷销售二部', '光谷销售二部' );

INSERT INTO `t_part` VALUES ( NULL, '3', '12', '光谷财务部', '光谷财务部' );

INSERT INTO `t_part` VALUES ( NULL, '3', '13', '光谷仓管部', '光谷仓管部' );

CREATE TABLE t_gw ( 
	g_id INT auto_increment PRIMARY KEY NOT NULL,
	g_name VARCHAR (50), 
	p_id INT, 
	g_remark VARCHAR (50)
);

ALTER TABLE t_gw ADD CONSTRAINT fk_pid FOREIGN KEY (p_id) REFERENCES t_part (p_id);

INSERT INTO `t_gw` VALUES ( NULL, '总经理', 1, '总经理' );

INSERT INTO `t_gw` VALUES ( NULL, '新城总经理', 5, '新城总经理' );

INSERT INTO `t_gw` VALUES ( NULL, '销售专员', 6, '销售专员' );

INSERT INTO `t_gw` VALUES ( NULL, '销售专员', 7, '销售专员' );

INSERT INTO `t_gw` VALUES ( NULL, '财务总监', 8, '财务总监' );

INSERT INTO `t_gw` VALUES ( NULL, '仓库主管', 9, '仓管主管' );

INSERT INTO `t_gw` VALUES ( NULL, '销售专员', 10, '销售专员' );

INSERT INTO `t_gw` VALUES ( NULL, '销售专员', 11, '销售专员' );

INSERT INTO `t_gw` VALUES ( NULL, '财务总监', 12, '财务总监' );

INSERT INTO `t_gw` VALUES ( NULL, '仓库主管', 13, '仓库主管' );

INSERT INTO `t_gw` VALUES ( NULL, '光谷总经理', 14, '光谷总经理' );

CREATE TABLE t_zc ( 
	z_id INT auto_increment PRIMARY KEY NOT NULL, 
	z_name VARCHAR (20), 
	z_remark VARCHAR (50)
);

INSERT INTO `t_zc` VALUES ( NULL, '注册架构师', '注册架构师' );

INSERT INTO `t_zc` VALUES ( NULL, '高级架构师', '高级架构师' );

INSERT INTO `t_zc` VALUES ( NULL, '中级架构师', '中级架构师' );

INSERT INTO `t_zc` VALUES ( NULL, '初级架构师', '初级架构师' );

INSERT INTO `t_zc` VALUES ( NULL, '注册会计师', '注册会计师' );

INSERT INTO `t_zc` VALUES ( NULL, '高级会计师', '高级会计师' );

INSERT INTO `t_zc` VALUES ( NULL, '中级会计师', '中级会计师' );

INSERT INTO `t_zc` VALUES ( NULL, '初级会计师', '初级会计师' );

INSERT INTO `t_zc` VALUES ( NULL, '注册分析师', '注册分析师' );

INSERT INTO `t_zc` VALUES ( NULL, '高级分析师', '高级分析师' );

INSERT INTO `t_zc` VALUES ( NULL, '中级分析师', '中级分析师' );

INSERT INTO `t_zc` VALUES ( NULL, '初级分析师', '初级分析师' );

INSERT INTO `t_zc` VALUES ( NULL, '注册安全师', '注册安全师' );

INSERT INTO `t_zc` VALUES ( NULL, '高级安全师', '高级安全师' );

INSERT INTO `t_zc` VALUES ( NULL, '中级安全师', '中级安全师' );

INSERT INTO `t_zc` VALUES ( NULL, '初级安全师', '初级安全师' );

#5用户表
CREATE TABLE t_master ( mid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)
	mname VARCHAR (50), #用户登陆名
	mpsw VARCHAR (50), #密码
	mrealname VARCHAR (50), #用户真实姓名
	pid INT, #所属部门编号(外键1)
	gid INT, #所属岗位编号（外键2）
	zid INT, #职称编号（外键3）
	mtel VARCHAR (50), #电话号码
	mimg VARCHAR (1000) #相片
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_master ADD CONSTRAINT p_check FOREIGN KEY (pid) REFERENCES t_part (p_id);

ALTER TABLE t_master ADD CONSTRAINT gwidk5_check FOREIGN KEY (gid) REFERENCES t_gw (g_id);

ALTER TABLE t_master ADD CONSTRAINT zcidk6_check FOREIGN KEY (zid) REFERENCES t_zc (z_id);

INSERT INTO `t_master` VALUES ( NULL, 'anna', '123', '安娜', '2', '1', '2', '13971244415', 'upload/1511147859903.jpg' );

INSERT INTO `t_master` VALUES ( NULL, 'ldh', '123', '刘德华', '5', '4', '5', '13971244488', 'upload/1511147483590.jpg' );

INSERT INTO `t_master` VALUES ( NULL, 'ldhdg', '123', '刘德华大哥', '6', '3', '2', '13971244411', 'upload/1511147572545.jpg' );

INSERT INTO `t_master` VALUES ( NULL, 'ldheg', '123', '刘德华二哥', '7', '4', '3', '13971244412', 'upload/1511147608991.jpg' );

INSERT INTO `t_master` VALUES ( NULL, 'ldhlp', '123', '刘德华老婆', '8', '5', '3', '13971244413', 'upload/1511147644804.jpg' );

INSERT INTO `t_master` VALUES ( NULL, 'ldhxyz', '123', '刘德华小姨子', '9', '6', '5', '13971244414', 'upload/1511147683206.jpg' );

#6用户所在管理组表
CREATE TABLE t_masterg ( 
	mgroupid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)
	mid INT, #用户信息表id(外键1)
	groupid INT #动作所属管理组ID(外键2)	
) ENGINE = INNODB DEFAULT CHARset = utf8;

ALTER TABLE t_masterg ADD CONSTRAINT masteridk7_check FOREIGN KEY (mid) REFERENCES t_master (mid);

ALTER TABLE t_masterg ADD CONSTRAINT groupidk8_check FOREIGN KEY (groupid) REFERENCES t_group (groupid);

INSERT INTO t_masterg VALUES (NULL, 1, 1);
INSERT INTO t_masterg VALUES (NULL, 2, 2);

#1-5汽车品牌表(carsort)
CREATE TABLE t_carsort ( 
	sortid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)		
	sortname VARCHAR (100), #汽车品牌名称
	sortflag INT 
) ENGINE = INNODB DEFAULT CHARset = utf8;

INSERT INTO `t_carsort` VALUES (NULL, '宝马', '1');

INSERT INTO `t_carsort` VALUES (NULL, '奔驰', '1');

INSERT INTO `t_carsort` VALUES (NULL, '雷克萨斯', '1');

INSERT INTO `t_carsort` VALUES (NULL, '丰田', '1');

INSERT INTO `t_carsort` VALUES (NULL, '五菱', '0');

INSERT INTO `t_carsort` VALUES (NULL, '本田', '1');

INSERT INTO `t_carsort` VALUES (NULL, '东风日产', '1');

INSERT INTO `t_carsort` VALUES (NULL, '悍马', '1');

INSERT INTO `t_carsort` VALUES (NULL, '现代', '1');

INSERT INTO `t_carsort` VALUES (NULL, '东风', '1');

#1-6汽车系列表(cardetail)
CREATE TABLE t_cardetail ( 
	detailid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)		
	sortid INT, #汽车品牌编号
	detailname VARCHAR (100), #汽车系列名称
	detailguige VARCHAR (100), #汽车车型
	detailtime VARCHAR (100), #汽车出厂时间
	detailremark VARCHAR (200), #汽车系列备注说明
	detailflag INT #是否停产
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_cardetail ADD CONSTRAINT sort_check FOREIGN KEY (sortid) REFERENCES t_carsort (sortid);

INSERT INTO `t_cardetail` VALUES ( NULL, '3', '霸道', '中东土豪版', '2017-11-15', '土豪', '1' );

INSERT INTO `t_cardetail` VALUES ( NULL, '3', '霸道', '中东乞丐版', '2010-11-15', '乞丐', '1' );

INSERT INTO `t_cardetail` VALUES ( NULL, '1', 'X7', '2018款至尊型', '2017-11-15', '都市豪华版', '1' );

INSERT INTO `t_cardetail` VALUES ( NULL, '2', 'MINICooper', '2017乡村版', '2017-11-15', '乡村版', '1' );

INSERT INTO `t_cardetail` VALUES ( NULL, '6', 'CRV', '2017低配版', '2017-11-15', '低配', '0' );

INSERT INTO `t_cardetail` VALUES ( NULL, '1', 'i8', '2018款至尊型', '2017-11-11', '至尊', '1' );

INSERT INTO `t_cardetail` VALUES ( NULL, '10', 'AX7', '2016款风尚版', '2016-11-19', '2016款风尚版', '1' );

#1-7赠品表(handout)
CREATE TABLE t_handout ( 
	handoutid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)		
	handoutname VARCHAR (100), #赠品名称
	handoutflag INT 
) ENGINE = INNODB DEFAULT charset = utf8;

INSERT INTO `t_handout` VALUES (NULL, '方向盘套', '1');

INSERT INTO `t_handout` VALUES ( NULL, '前挡风玻璃膜', '1' );

INSERT INTO `t_handout` VALUES (NULL, '脚垫', '1');

INSERT INTO `t_handout` VALUES ( NULL, '后挡风玻璃膜', '1' );

INSERT INTO `t_handout` VALUES (NULL, '真皮座椅套', '1');

INSERT INTO `t_handout` VALUES (NULL, '真皮把手套', '1');

INSERT INTO `t_handout` VALUES ( NULL, '中控钢化玻璃膜', '1' );

INSERT INTO `t_handout` VALUES (NULL, '雨刷器', '1');

INSERT INTO `t_handout` VALUES (NULL, '行车记录仪', '1');

#1-8仓库字典(storehouse)
CREATE TABLE t_storehouse ( 
	storeid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)		
	storename VARCHAR (100), #仓库名称
	storeflag INT 
) ENGINE = INNODB DEFAULT charset = utf8;

INSERT INTO `t_storehouse` VALUES ( NULL, '花山软件新城仓库', '1' );

INSERT INTO `t_storehouse` VALUES (NULL, '九峰仓库', '1');

INSERT INTO `t_storehouse` VALUES (NULL, '关山仓库', '1');

INSERT INTO `t_storehouse` VALUES (NULL, '江夏仓库', '1');

#1-9采购申请表(purchase)
CREATE TABLE t_purchase ( 
	purchaseid INT auto_increment PRIMARY KEY NOT NULL, #采购申请单编号(主键)				
	mid INT, #申请人编号(外键)
	purtitle VARCHAR (100), #申请标题
	purremark VARCHAR (100), #备注
	pmoney INT, #预算资金
	ptime VARCHAR (100), #申请时间
	purchaseflag INT, #是否审批
	sugid INT, #审批人编号(外键#员工表)
	suggestion VARCHAR (100) #审批意见
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_purchase ADD CONSTRAINT sortidk100_check FOREIGN KEY (mid) REFERENCES t_master (mid);

ALTER TABLE t_purchase ADD CONSTRAINT sortidk101_check FOREIGN KEY (sugid) REFERENCES t_master (mid);

#purchaseflag##  0   代表填写了还没发送
#purchaseflag##  1   代表你已经发送审批之中
#purchaseflag##  3   代表同意
#purchaseflag##  2   代表打回
#purchaseflag##  4   代表否定
#select * from purchase where masterid=12
INSERT INTO `t_purchase` VALUES ( NULL, '2', '2017年第一季度销售计划', '2017年第一季度销售计划', '3700', '2017-11-29 03:20:09', '1', '1', '还没有审批' );

INSERT INTO `t_purchase` VALUES ( NULL, '2', '2017年第二季度销售计划', '2017年第二季度销售计划', '1125', '2017-11-29 03:24:08', '1', '1', '还没有审批' );

INSERT INTO `t_purchase` VALUES ( NULL, '2', '2017年第三季度销售计划', '2017年第三季度销售计划', '4025', '2017-11-29 03:24:44', '0', '1', '还没有审批' );

#1-10汽车采购明细表(purcarmx)
CREATE TABLE t_purcarmx ( 
	pmxid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	purchaseid INT, #申请单编号（外键1）
	detailid INT, #汽车系列表编号（外键2）
	caigouprice INT, #汽车采购单价
	caigoucount INT #数量
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_purcarmx ADD CONSTRAINT xpurchaseidk110_check FOREIGN KEY (purchaseid) REFERENCES t_purchase (purchaseid);

ALTER TABLE t_purcarmx ADD CONSTRAINT xdetailididk111_check FOREIGN KEY (detailid) REFERENCES t_cardetail (detailid);

INSERT INTO `t_purcarmx` VALUES (NULL, '1', '1', '58', '50');

INSERT INTO `t_purcarmx` VALUES (NULL, '1', '3', '40', '20');

INSERT INTO `t_purcarmx` VALUES (NULL, '2', '4', '25', '30');

INSERT INTO `t_purcarmx` VALUES (NULL, '2', '5', '15', '25');

INSERT INTO `t_purcarmx` VALUES (NULL, '3', '5', '80', '30');

INSERT INTO `t_purcarmx` VALUES (NULL, '3', '6', '65', '25');

#drop table purcarmx;
#drop table purchase;
#1-11赠品入库表(inhandout)
CREATE TABLE t_inhandout ( 
	inhandoutid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	handoutid INT, #赠品编号(外键1)
	inhandoutcount INT, #库存量
	inhandoutflag INT #1—代表有库存量 0—无库存量
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_inhandout ADD CONSTRAINT handoutidk11_check FOREIGN KEY (handoutid) REFERENCES t_handout (handoutid);

insert into t_inhandout values(null,1,100,1);
insert into t_inhandout values(null,2,50,1);
insert into t_inhandout values(null,3,200,1);
insert into t_inhandout values(null,4,500,1);

#1-12赠品入库明细表(inhandoutmx)
CREATE TABLE t_inhandoutmx ( 
	inhandoutmxid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	inhandoutid INT, #赠品入库编号(外键1)
	handoutid INT, #赠品编号（外键2）
	storeid INT, #仓库编号（外键3）
	handoutcolor VARCHAR (50), #赠送品颜色
	handoutsize VARCHAR (100), #赠送品尺寸
	handoutimg VARCHAR (500), #赠品图片
	inhandoutnum INT, #入库数量
	handouttime VARCHAR (200), #入库时间
	handoutremark VARCHAR (200), #备注说明
	pid INT, #入库经办人所在部门（外键5）
	mid INT #入库经办人(外键4)
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_inhandoutmx ADD CONSTRAINT inhandoutidk122_check FOREIGN KEY (inhandoutid) REFERENCES t_inhandout (inhandoutid);

ALTER TABLE t_inhandoutmx ADD CONSTRAINT handoutidk123_check FOREIGN KEY (handoutid) REFERENCES t_handout (handoutid);

ALTER TABLE t_inhandoutmx ADD CONSTRAINT storeidk124_check FOREIGN KEY (storeid) REFERENCES t_storehouse (storeid);

ALTER TABLE t_inhandoutmx ADD CONSTRAINT partidk125_check FOREIGN KEY (pid) REFERENCES t_part (p_id);

ALTER TABLE t_inhandoutmx ADD CONSTRAINT masteridk126_check FOREIGN KEY (mid) REFERENCES t_master (mid);

insert into t_inhandoutmx values(null,1,1,1,'白色','200mm*20mm','20170506.jpg',25,'2017-08-07 09:58:12','good',5,2);
insert into t_inhandoutmx values(null,1,1,1,'白色','200mm*20mm','20170506.jpg',20,'2017-08-07 09:58:12','good',5,2);
insert into t_inhandoutmx values(null,1,1,1,'白色','200mm*20mm','20170506.jpg',55,'2017-08-07 09:58:12','good',5,2);

insert into t_inhandoutmx values(null,2,2,1,'黑色','500mm*100mm','20170506.jpg',20,'2017-08-07 09:58:12','good',5,2);
insert into t_inhandoutmx values(null,2,2,1,'宝蓝色','500mm*100mm','20170506.jpg',30,'2017-08-07 09:58:12','good',5,2);

insert into t_inhandoutmx values(null,3,3,1,'红色','200mm*300mm','20170506.jpg',55,'2017-08-07 09:58:12','good',5,2);
insert into t_inhandoutmx values(null,3,3,1,'灰色','200mm*300mm','20170506.jpg',45,'2017-08-07 09:58:12','good',5,2);
insert into t_inhandoutmx values(null,3,3,1,'银色','200mm*300mm','20170506.jpg',65,'2017-08-07 09:58:12','good',5,2);
insert into t_inhandoutmx values(null,3,3,1,'红色','200mm*300mm','20170506.jpg',25,'2017-08-07 09:58:12','good',5,2);

insert into t_inhandoutmx values(null,4,4,1,'暗红色','500mm*150mm','20170506.jpg',200,'2017-08-07 09:58:12','good',5,2);
insert into t_inhandoutmx values(null,4,4,1,'暗红色','500mm*150mm','20170506.jpg',152,'2017-08-07 09:58:12','good',5,2);
insert into t_inhandoutmx values(null,4,4,1,'暗红色','500mm*150mm','20170506.jpg',148,'2017-08-07 09:58:12','good',5,2);

#drop table inhandoutmx;
#drop table inhandout;
#1-13汽车入库表(incarhandout)
CREATE TABLE t_incar ( 
	incarid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	detailid INT, #汽车系列编号(外键1)
	kccarcount INT, #库存量
	kccarflag INT #1—代表有库存 0—无库存
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_incar ADD CONSTRAINT detailididk_check FOREIGN KEY (detailid) REFERENCES t_cardetail (detailid);

insert into t_incar values(null,1,4,1);
insert into t_incar values(null,2,5,1);
insert into t_incar values(null,4,3,1);
insert into t_incar values(null,5,2,1);
insert into t_incar values(null,3,4,1);
insert into t_incar values(null,6,6,1);


#1-14汽车入库明细(incarhandoutmx)
CREATE TABLE t_incarmx ( 
	incarmxid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	incarid INT, #汽车入库表编号（外键1）
	detailid INT, #汽车系列编号(外键2)
	storeid INT, #原始存放仓库编号(外键3)
	newstoreid INT, #现存放仓库编号
	incarprice VARCHAR (100), #入库价格
	outcarprice VARCHAR (100), #市场指导价
	carshouzi VARCHAR (100), #是否自动挡
	#carxhname	varchar(100),#车辆型号
	carcjh VARCHAR (100), #车架号
	carhgz VARCHAR (100), #合格证
	carfdjh VARCHAR (100), #发动机号
	carcolor VARCHAR (100), #车身颜色
	carimg VARCHAR (1000), #车辆图片
	carchanshu VARCHAR (1000), #详细配置参数
	carrukucount INT, #入库数量
	carrukutime VARCHAR (100), #入库时间
	pid INT, #入库经办人所在部门（外键5）
	mid INT, #入库经办人
	carkucunflag INT #1—没有出售  0—已经出售
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_incarmx ADD CONSTRAINT incarh217_check FOREIGN KEY (incarid) REFERENCES t_incar (incarid);
ALTER TABLE t_incarmx ADD CONSTRAINT detailididk218_check FOREIGN KEY (detailid) REFERENCES t_cardetail (detailid);
ALTER TABLE t_incarmx ADD CONSTRAINT storeidk219_check FOREIGN KEY (storeid) REFERENCES t_storehouse (storeid);
ALTER TABLE t_incarmx ADD CONSTRAINT partidk220_check FOREIGN KEY (pid) REFERENCES t_part (p_id);
ALTER TABLE t_incarmx ADD CONSTRAINT masteridk221_check FOREIGN KEY (mid) REFERENCES t_master (mid);

#drop table incarhandoutmx;
#drop table incarhandout;
#1-15客户信息表(custom)
CREATE TABLE t_custom ( 
	customid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	mid INT, #员工编号(外键)
	customname VARCHAR (50), #客户姓名
	customtel VARCHAR (50) #客户电话
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_custom ADD CONSTRAINT masteridk321_check FOREIGN KEY (mid) REFERENCES t_master (mid);

INSERT INTO `t_custom` VALUES ( NULL, '2', '林俊杰', '13971244412' );

INSERT INTO `t_custom` VALUES ( NULL, '2', '周杰伦', '13971244413' );

INSERT INTO `t_custom` VALUES ( NULL, '2', '林志林', '13971244414' );

INSERT INTO `t_custom` VALUES ( NULL, '2', '奥巴马', '13971244415' );

#1-16汽车出库记录明细表(caroutmx)
CREATE TABLE t_caroutmx ( 
	caroutmxid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	incarmxid INT, #汽车表编号（外键）
	customid INT, #客户编号
	mid INT, #经办人编号（外键）
	carouttime VARCHAR (50), #出售时间
	caroutremark VARCHAR (100) #备注说明
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_caroutmx ADD CONSTRAINT incarhandoutmxidk451_check FOREIGN KEY (incarmxid) REFERENCES t_incarmx (incarmxid);

ALTER TABLE t_caroutmx ADD CONSTRAINT customidk452_check FOREIGN KEY (customid) REFERENCES t_custom (customid);

ALTER TABLE t_caroutmx ADD CONSTRAINT masteridk453_check FOREIGN KEY (mid) REFERENCES t_master (mid);

#drop table caroutmx;
#select max(caroutmxid) from caroutmx
#1-17出售赠品表(salezengpin)
CREATE TABLE t_salezengpin ( 
	salezpid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	inhandoutid INT, #赠品编号（外键）
	kehuname VARCHAR (100), #零售客户姓名
	kehutel VARCHAR (50), #零售客户电话
	salecount INT, #出售数量
	saletime VARCHAR (100), #卖出时间
	mid INT, #经办人
	saleremark VARCHAR (100) #备注
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_salezengpin ADD CONSTRAINT inhandoutidk1611_check FOREIGN KEY (inhandoutid) REFERENCES t_inhandout (inhandoutid);

ALTER TABLE t_salezengpin ADD CONSTRAINT masteridk162_check FOREIGN KEY (mid) REFERENCES t_master (mid);

#drop table salezengpin;
#1-18汽车赠品(附件记录)表(fujian)
CREATE TABLE t_fujian ( 
	fjid INT auto_increment PRIMARY KEY NOT NULL, #附件编号(主键)				
	caroutmxid INT, #汽车出售记录编号(外键)
	inhandoutid INT, #赠品入库编号（外键）
	zscount INT #赠送数量		
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_fujian ADD CONSTRAINT caroutmxidk812_check FOREIGN KEY (caroutmxid) REFERENCES t_caroutmx (caroutmxid);

ALTER TABLE t_fujian ADD CONSTRAINT inhandoutidk813_check FOREIGN KEY (inhandoutid) REFERENCES t_inhandout (inhandoutid);

#1-19汽车售后记录表(shouhou)
CREATE TABLE t_shouhou ( 
	shouhouid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	customid INT #客户编号（外键）
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_shouhou ADD CONSTRAINT caroutmxidk712_check FOREIGN KEY (customid) REFERENCES t_custom (customid);

#1汽车售后记录表明细(shouhoumx)
CREATE TABLE t_shouhoumx ( 
	shouhoumxid INT auto_increment PRIMARY KEY NOT NULL, #编号(主键)				
	shouhouid INT, #售后编号（外键）
	fwnr VARCHAR (100), #服务内容
	shouhouflag INT, #是否收费
	shmoney VARCHAR (100), #费用
	shtime VARCHAR (100), #售后时间
	mid INT #经办人编号（外键）
) ENGINE = INNODB DEFAULT charset = utf8;

ALTER TABLE t_shouhoumx ADD CONSTRAINT shouhouidk612_check FOREIGN KEY (shouhouid) REFERENCES t_shouhou (shouhouid);

ALTER TABLE t_shouhoumx ADD CONSTRAINT masteridk613_check FOREIGN KEY (mid) REFERENCES t_master (mid);

