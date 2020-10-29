package com.example.demo.service.Impl;


import com.example.demo.common.ResponseCode;
import com.example.demo.common.ServerResponse;
import com.example.demo.dao.ProjectMapper;
import com.example.demo.entity.ProjectParam;
import com.example.demo.service.IProjectService;
import com.example.demo.util.RedisPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Service("IProjectService")
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ServerResponse<LinkedHashMap<String, Object>> getId(ProjectParam projectParam) {

        List<ProjectParam> selectIDExist = projectMapper.selectIDExist(projectParam);
        LinkedHashMap<String,Object> result = new LinkedHashMap<>();
        if (selectIDExist.size()>0){
            result.put("userID", selectIDExist.get(0).getUserID());
        }else {
            String userId = UUID.randomUUID().toString();
            projectParam.setUserID(userId);
            projectMapper.insertNewUser(projectParam);
            result.put("userID", userId);
        }
        RedisPoolUtil.setEx(result.get("usrerID").toString(), result.get("usrerID").toString(), 60 * 60 * 24);
        return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getDesc(), result);
    }
}
