package tests.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tests.entity.LeaveMessage;
import tests.entity.LeaveMessageExample;

public interface LeaveMessageMapper {
    int countByExample(LeaveMessageExample example);

    int deleteByExample(LeaveMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(LeaveMessage record);

    int insertSelective(LeaveMessage record);

    List<LeaveMessage> selectByExampleWithBLOBs(LeaveMessageExample example);

    List<LeaveMessage> selectByExample(LeaveMessageExample example);

    LeaveMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LeaveMessage record, @Param("example") LeaveMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") LeaveMessage record, @Param("example") LeaveMessageExample example);

    int updateByExample(@Param("record") LeaveMessage record, @Param("example") LeaveMessageExample example);

    int updateByPrimaryKeySelective(LeaveMessage record);

    int updateByPrimaryKeyWithBLOBs(LeaveMessage record);

    int updateByPrimaryKey(LeaveMessage record);
}