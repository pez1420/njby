package tests.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tests.entity.Adminer;
import tests.entity.AdminerExample;

public interface AdminerMapper {
    int countByExample(AdminerExample example);

    int deleteByExample(AdminerExample example);

    int deleteByPrimaryKey(String id);

    int insert(Adminer record);

    int insertSelective(Adminer record);

    List<Adminer> selectByExample(AdminerExample example);

    Adminer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Adminer record, @Param("example") AdminerExample example);

    int updateByExample(@Param("record") Adminer record, @Param("example") AdminerExample example);

    int updateByPrimaryKeySelective(Adminer record);

    int updateByPrimaryKey(Adminer record);
}