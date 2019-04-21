package com.offcn.mapper;

import com.offcn.pojo.CtcKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtcMapper {

    int deleteByPrimaryKey(CtcKey key);

    int insert(CtcKey record);

    int insertSelective(CtcKey record);
   
    void  insertBatch(List<CtcKey> ctclist);
}