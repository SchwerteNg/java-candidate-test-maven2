package com.example.demo.service;


import com.example.demo.common.ServerResponse;
import com.example.demo.entity.ProjectParam;

import java.util.LinkedHashMap;

public interface IProjectService {

    ServerResponse<LinkedHashMap<String,Object>> getId(ProjectParam projectParam);

}
