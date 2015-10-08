package tests.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tests.entity.AdPosition;
import tests.entity.AdPositionExample;

public interface AdPositionMapper {
    int countByExample(AdPositionExample example);

    int deleteByExample(AdPositionExample example);

    int deleteByPrimaryKey(String id);

    int insert(AdPosition record);

    int insertSelective(AdPosition record);

    List<AdPosition> selectByExampleWithBLOBs(AdPositionExample example);

    List<AdPosition> selectByExample(AdPositionExample example);

    AdPosition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AdPosition record, @Param("example") AdPositionExample example);

    int updateByExampleWithBLOBs(@Param("record") AdPosition record, @Param("example") AdPositionExample example);

    int updateByExample(@Param("record") AdPosition record, @Param("example") AdPositionExample example);

    int updateByPrimaryKeySelective(AdPosition record);

    int updateByPrimaryKeyWithBLOBs(AdPosition record);

    int updateByPrimaryKey(AdPosition record);
}