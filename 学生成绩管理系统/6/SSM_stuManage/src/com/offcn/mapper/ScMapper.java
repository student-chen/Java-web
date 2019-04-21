package com.offcn.mapper;

import com.offcn.pojo.Sc;
import com.offcn.pojo.ScKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScMapper {

    int deleteByPrimaryKey(ScKey key);

    int insert(Sc record);

    int insertSelective(Sc record);

    Sc selectByPrimaryKey(ScKey key);

    int updateByPrimaryKeySelective(Sc record);

    int updateByPrimaryKey(Sc record);
    
    int inserBatch(List<Sc> sclist);
 
}