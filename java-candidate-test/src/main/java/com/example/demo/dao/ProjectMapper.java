package com.example.demo.dao;


import com.example.demo.entity.ProjectParam;

import java.util.List;

public interface ProjectMapper {

    Integer createUserTable();

    List<ProjectParam> selectIDExist(ProjectParam projectParam);

    Integer insertNewUser(ProjectParam projectParam);

}