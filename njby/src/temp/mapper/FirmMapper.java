package temp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import temp.entity.Firm;
import temp.entity.FirmExample;

public interface FirmMapper {
    int countByExample(FirmExample example);

    int deleteByExample(FirmExample example);

    int deleteByPrimaryKey(String id);

    int insert(Firm record);

    int insertSelective(Firm record);

    List<Firm> selectByExampleWithBLOBs(FirmExample example);

    List<Firm> selectByExample(FirmExample example);

    Firm selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Firm record, @Param("example") FirmExample example);

    int updateByExampleWithBLOBs(@Param("record") Firm record, @Param("example") FirmExample example);

    int updateByExample(@Param("record") Firm record, @Param("example") FirmExample example);

    int updateByPrimaryKeySelective(Firm record);

    int updateByPrimaryKeyWithBLOBs(Firm record);

    int updateByPrimaryKey(Firm record);
}