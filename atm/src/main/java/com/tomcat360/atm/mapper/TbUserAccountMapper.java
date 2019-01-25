package com.tomcat360.atm.mapper;

import com.tomcat360.atm.model.TbUserAccount;
import com.tomcat360.atm.model.TbUserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserAccountMapper {
    int countByExample(TbUserAccountExample example);

    int deleteByExample(TbUserAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUserAccount record);

    int insertSelective(TbUserAccount record);

    List<TbUserAccount> selectByExample(TbUserAccountExample example);

    TbUserAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUserAccount record, @Param("example") TbUserAccountExample example);

    int updateByExample(@Param("record") TbUserAccount record, @Param("example") TbUserAccountExample example);

    int updateByPrimaryKeySelective(TbUserAccount record);

    int updateByPrimaryKey(TbUserAccount record);
}