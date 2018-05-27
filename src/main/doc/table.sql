drop  table member;
create table member
(
id int primary key auto_increment comment '学号',
name varchar(100) CHARACTER SET utf8 comment '姓名' ,
sex varchar(5) CHARACTER SET utf8 comment '性别' ,
birthDay  varchar(100) CHARACTER SET utf8 ,
enterDate varchar(100) CHARACTER SET utf8 ,
graduatedDate varchar(100) CHARACTER SET utf8 ,
studyStyle varchar(100) CHARACTER SET utf8,
graduateMajor varchar(100) CHARACTER SET utf8 ,
graduateSchool varchar(100)  CHARACTER SET utf8,
level varchar(100) CHARACTER SET utf8,
collegeLocation varchar(100) CHARACTER SET utf8,
cardNo varchar(100) CHARACTER SET utf8 ,
checkCode varchar(100) CHARACTER SET utf8,
createDate varchar(100) ,
checkCodeEndDate varchar(100) CHARACTER SET utf8,
idCardNo varchar(100) CHARACTER SET utf8,
studyType varchar(100) CHARACTER SET utf8
) comment '信息表';