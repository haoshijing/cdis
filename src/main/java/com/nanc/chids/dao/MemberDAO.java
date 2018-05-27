package com.nanc.chids.dao;


import com.nanc.chids.po.MemberPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberDAO {

    MemberPo getById(Integer id);

    int insertMember(@Param("member") MemberPo memberPo);

    int delete(Integer id);

    int batchInsert(List<MemberPo> memberPos);

    List<MemberPo> selectList(@Param("queryMember") MemberPo memberPo);
}
