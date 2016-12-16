create table jbr_user(
  user_id  int identity (1,1) NOT NULL,
  user_name varchar(50) not null,
  user_pass varchar(50) not null,
  email varchar(100),
  primary key(user_id),
  unique(user_name)
);

create table jbr_teacher(
  id  int identity (1,1) NOT NULL,
  teaid  varchar(10) NOT NULL,
  teaname varchar(20) not null,
  teacell varchar(20)  null,
  email varchar(500),
  primary key(id)
);

create table jbr_cur_sch(
  id  int identity (1,1) NOT NULL,
  teaid varchar(10) not null,
  SequenceNumber int,
  weekday varchar(10) not null,
  subject varchar(20) not null,
  fromtime varchar(8) not null,
  totime varchar(8) not null,
  roomno varchar(20) not null,
  primary key(id)
);

create table jbr_classroom(
  id  int identity (1,1) NOT NULL,
  roomno varchar(20) not null,
  equno varchar(20) not null,
  primary key(id)
);

create table jbr_manualrecord(
  ID int identity (1,1) NOT NULL,
  EmplID varchar(20) not null,
  EmplName varchar(20) not null,
  Subject varchar(20),
  TeacherID varchar(20) not null,
  TeacherName varchar(20) not null,
  RoomNO varchar(20) ,
  RecordTime Datetime not null,
  Status varchar(10) not null,
  CellPhone varchar(20),
  PayTime Datetime,
  primary key(id)
);

create table jbr_he_information(
  ID int identity (1,1) NOT NULL,
  EmplID varchar(20) not null,
  EmplName varchar(20) not null,
  JoinTime Datetime,
  RecommendPerson varchar(20),

  FatherName varchar(20),
  FatherCompany varchar(20) ,
  FatherProfession varchar(20),
  FatherCellphone varchar(20),
  FatherPhoneNumber varchar(20),
  FatherEmail varchar(20),
  Fatherqqormsn varchar(20),

  MotherName varchar(20),
  MotherCompany varchar(20) ,
  MotherProfession varchar(20),
  MotherCellphone varchar(20),
  MotherPhoneNumber varchar(20),
  MotherEmail varchar(20),
  Motherqqormsn varchar(20),
  
  Address varchar(20),
  Postcode varchar(20),
  PhoneNumber varchar(20),

  OtherContactPerson varchar(20),
  OtherName varchar(20),
  RelationShip varchar(20),
  OtherCellphone varchar(20),
  OtherPhoneNumber varchar(20),
  
  primary key(ID)
);


create table jbr_contract(
  ID int identity (1,1) NOT NULL,
  ContractNO varchar(20) not null,
  EmplID varchar(20) not null,
  TotalLessonAmount int,
  Amount int,

  ContractDate Datetime,
  ExpireDate Datetime,
  RemainLessonAmount int,
  ContractStatus varchar(20),
  ContractPayStatus varchar(20),
  ContractType varchar(20),
  
  primary key(ID)
);

adjust表增加了字段 2015-12-9
1.alter table adjust add s_status varchar(200) null; 
adjust表增加了字段 2015-12-11
2.alter table adjust add newlcassroom varchar(200) null;



CREATE TABLE `kechengversion` (
   `id` int(10) NOT NULL auto_increment,
   `vname` varchar(30) character set latin1 default NULL COMMENT '版本名称',
   `vid` varchar(30) character set latin1 default NULL COMMENT '版本编号',
   `createid` varchar(30) character set latin1 default NULL COMMENT '创建人',
   `description` varchar(100) character set latin1 default NULL COMMENT '课表版本描述',
   `createdate` datetime default NULL COMMENT '创建日期',
   PRIMARY KEY  (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=gbk 
 
 alter table kecheng add vid varchar(30) null 
 
 CREATE TABLE `v_kecheng` (
   `id` int(10) unsigned NOT NULL auto_increment COMMENT '表示ID',
   `grade` int(10) unsigned default NULL COMMENT '年级',
   `classname` varchar(200) default NULL COMMENT '班级',
   `subjectname` varchar(200) default NULL COMMENT '课程',
   `teacher` varchar(200) default NULL COMMENT '上课老师',
   `week` int(10) unsigned default NULL COMMENT '第多少周',
   `campus` varchar(80) default NULL COMMENT '校区',
   `classroom` varchar(200) default NULL COMMENT '上课教室',
   `weekday` varchar(80) default NULL COMMENT '上课日',
   `starttime` varchar(80) default NULL COMMENT '上课开始时间',
   `endtime` varchar(80) default NULL COMMENT '上课结束时间',
   `subjectid` int(11) default NULL COMMENT '课程ID',
   `teacherid` varchar(45) default NULL COMMENT '老师ID',
   `semester` varchar(45) default NULL COMMENT '学期',
   `classid` int(10) unsigned default NULL,
   `vid` varchar(30) default NULL COMMENT '版本编号',
   PRIMARY KEY  (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='课程表'