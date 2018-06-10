package com.nanc.chids.controller;

import com.nanc.chids.dao.MemberDAO;
import com.nanc.chids.po.MemberPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {

    @Autowired
    private MemberDAO memberDAO;

    @RequestMapping("/index/{id}")
    public ModelAndView index(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("index");
        MemberPo memberPo = memberDAO.getById(id);
        modelAndView.addObject("memberPo",memberPo);
        return modelAndView;
    }

    @RequestMapping("/indexnew/{id}")
    public ModelAndView indexnew(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("indexnew");
        MemberPo memberPo = memberDAO.getById(id);
        modelAndView.addObject("memberPo",memberPo);
        return modelAndView;
    }

    @RequestMapping("/view/{id}")
    public ModelAndView wap(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("wap");
        MemberPo memberPo = memberDAO.getById(id);
        modelAndView.addObject("memberPo",memberPo);
        return modelAndView;
    }
}
