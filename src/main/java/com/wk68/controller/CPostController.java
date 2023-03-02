package com.wk68.controller;

import com.wk68.entity.CPost;
import com.wk68.mapper.CPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class CPostController {

    @Autowired
    private CPostMapper pt;

    @RequestMapping("/getByPrimaryKey")
    public CPost selectByPrimaryKey(Integer postId) {
        CPost p = pt.selectByPrimaryKey(postId);
        return p;
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public Map<String, Object> selectAll(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("map", pt.selectAll());
        return map;
    }

}
