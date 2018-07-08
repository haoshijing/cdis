package com.nanc.chids.po;


import lombok.Data;

@Data
public class MemberPo {

    /**
     * 序号
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private String birthDay;
    /**
     * 入学日期
     */
    private String enterDate;
    /**
     * 毕业日期
     */
    private String graduatedDate;
    /**
     * 学习形式
     */
    private String studyStyle;
    /**
     * 毕业专业
     */
    private String graduateMajor;

    /**
     * 毕业学校
     */
    private String graduateSchool;

    /**
     * 学历类型
     */
    private String studyType;
    /**
     * 学历层次
     */
    private String level;

    /**
     * 院校所在地
     */
    private String collegeLocation;

    /**
     * 证书编号
     */
    private String cardNo;

    /**
     * 验证码
     */
    private String checkCode;

    /**
     * 校长姓名
     */
    private String president;

    /**
     * 更新日期
     */
    private String updateDate;

    /**
     * 自考专业
     */
    private String selfMajor;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * byzh
     */
    private String cardNo2;

    /**
     * 学制
     */
    private String length;

    /**
     * 二维码
     */
    private String qRCode;

    /**
     * xlbg
     */
    private String photo;

}
