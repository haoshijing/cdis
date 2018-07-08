package com.nanc.chids.test;

import com.nanc.chids.dao.MemberDAO;
import com.nanc.chids.po.MemberPo;
import org.apache.commons.lang.time.StopWatch;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration({"classpath:application-context.xml"})
public class BaseTest {

    @Autowired
    private MemberDAO memberDAO;

    @Ignore
    public void testQueryMember() {
        MemberPo memberPo = memberDAO.getById(1);

        Assert.assertTrue(memberPo != null &&
                memberPo.getName().equals("haoshijing"));
    }


    @Ignore
    public void testSelectList() {
        MemberPo memberPo = new MemberPo();
        memberPo.setName("郝锦坤");
        memberPo.setId(100);
        List<MemberPo> list = memberDAO.selectList(memberPo);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testInsert() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        MemberPo memberPo = new MemberPo();
        memberPo.setSex("m");
        memberPo.setName("郝锦坤1234");
        memberPo.setId(3333);
        memberPo.setBirthDay("2017-10-25");
        memberPo.setCardNo("36042519880801493X");
        memberPo.setCheckCode("22222222");
        memberPo.setStudyStyle("全日制");
//        memberPo.setCheckCodeEndDate("2017-10-25");
        memberPo.setEnterDate("2017-10-25");
        memberPo.setGraduateMajor("1111");
        memberPo.setGraduateSchool("华东交通大学");
        memberPo.setLevel("专科");
        memberPo.setCollegeLocation("江西省");
        memberPo.setCheckCode("3333");
        memberPo.setCardNo("5454545412127");
//        memberPo.setCreateDate("2017-10-14");
//        memberPo.setCheckCodeEndDate("2017-10-15");
        memberPo.setIdCardNo("36042519880801493X");
        int insertSet = memberDAO.insertMember(memberPo);
        stopWatch.stop();
        System.out.println(stopWatch.getTime());

        Assert.assertTrue(insertSet == 1);
    }

    @Test
    public void testBatchInsert() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for(int j = 3 ; j < 1005;j++) {
            Integer startIdx = 2000000+  1000*(j);
            Integer endIdx = 2000000+1000*(j+1) - 1;
            List<MemberPo> memberPos = new ArrayList<>();
            for (int i = startIdx; i < endIdx; i++) {
                MemberPo memberPo = new MemberPo();
                memberPo.setSex("m");
                memberPo.setName("郝锦坤1234");
                memberPo.setId(i);
                memberPo.setBirthDay("2017-10-25");
                memberPo.setCardNo("36042519880801493X");
                memberPo.setCheckCode("22222222");
                memberPo.setStudyStyle("全日制");
//                memberPo.setCheckCodeEndDate("2017-10-25");
                memberPo.setEnterDate("2017-10-25");
                memberPo.setGraduateMajor("1111");
                memberPo.setGraduateSchool("华东交通大学");
                memberPo.setLevel("专科");
                memberPo.setCollegeLocation("江西省");
                memberPo.setCheckCode("3333");
                memberPo.setCardNo("5454545412127");
//                memberPo.setCreateDate("2017-10-14");
//                memberPo.setCheckCodeEndDate("2017-10-15");
                memberPo.setIdCardNo("36042519880801493X");
                memberPos.add(memberPo);
            }
            int insertSet = memberDAO.batchInsert(memberPos);

        }
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }


}
