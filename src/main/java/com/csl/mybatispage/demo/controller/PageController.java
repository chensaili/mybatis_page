package com.csl.mybatispage.demo.controller;

import com.csl.mybatispage.demo.common.R;
import com.csl.mybatispage.demo.dao.UserInfoMapper;
import com.csl.mybatispage.demo.entity.UserInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Component
@RestController
public class PageController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping(value = "/getAll")
    public R showCityList(@RequestParam(required=true,defaultValue="1") Integer page,
                          @RequestParam(required=false,defaultValue="3") Integer pageSize){

        //设置分页信息，默认是第一页，每一页一共三条数据
        PageHelper.startPage(page,pageSize);
        List<UserInfo>list=userInfoMapper.getAll();
        //获取分页查询后的数据
        PageInfo<UserInfo> pageInfo=new PageInfo(list);

        return R.ok().put("page",pageInfo);
    }
}
