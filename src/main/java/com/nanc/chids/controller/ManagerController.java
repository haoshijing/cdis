package com.nanc.chids.controller;

import com.nanc.chids.dao.MemberDAO;
import com.nanc.chids.po.MemberPo;
import com.nanc.chids.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ManagerController {

    @Autowired
    private MemberDAO memberDAO;

    @RequestMapping("/admin/index")
    public String index(){
        return "/admin/upload";
    }

    @RequestMapping("/admin/uploadExecl")
    @ResponseBody
    public  String upload(@RequestParam(value = "file", required = false) MultipartFile file){
        try {
          List<MemberPo> memberPoList =   ExcelUtil.parseExcel(file.getInputStream());
          for(MemberPo memberPo:memberPoList){
              MemberPo queryMemberPo = memberDAO.getById(memberPo.getId());
              if(queryMemberPo != null){
                  memberDAO.delete(memberPo.getId());
              }
              memberDAO.insertMember(memberPo);
          }

        }catch (Exception e){
            return e.getCause().toString();
        }
        return "ok";
    }
}
