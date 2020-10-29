package com.example.demo.controller;

import com.example.demo.common.ResponseCode;
import com.example.demo.common.ServerResponse;
import com.example.demo.entity.ProjectParam;
import com.example.demo.service.IProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class ProjectController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/getId.do")
    public ServerResponse<LinkedHashMap<String,Object>> getId(ProjectParam projectParam){

        if (StringUtils.isEmpty(projectParam.getId1())||StringUtils.isEmpty(projectParam.getId2())){
            return ServerResponse.createByErrorMessage(ResponseCode.ERROR.getCode(), "Unavailability of parameter");
        }
        return iProjectService.getId(projectParam);
    }

}
