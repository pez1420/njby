package tests.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tests.entity.Ad;
import tests.entity.AdExample;

public interface AdMapper {
    int countByExample(AdExample example);

    int deleteByExample(AdExample example);

    int deleteByPrimaryKey(String id);

    int insert(Ad record);

    int insertSelective(Ad record);

    List<Ad> selectByExampleWithBLOBs(AdExample example);

    List<Ad> selectByExample(AdExample example);

    Ad selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByExampleWithBLOBs(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByExample(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKeyWithBLOBs(Ad record);

    int updateByPrimaryKey(Ad record);
}