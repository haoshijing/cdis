package com.nanc.chids.po;


import lombok.Data;

@Data
public class MemberPo {
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /*
    出生日期
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
     * 学历层次
     */
    private String level;

    /**
     * 院校所在地
     */
    private String collegeLocation;

    /*
    证书编号
     */
    private String cardNo;

    /*
    验证码
     */
    private String checkCode;

    /**
     * 制表日期
     */
    private String createDate;

    /**
     * 验证期至
   */
    private String checkCodeEndDate;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 学历类型
     */
    private String studyType;

}
