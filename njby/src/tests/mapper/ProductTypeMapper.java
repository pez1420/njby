package tests.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tests.entity.ProductType;
import tests.entity.ProductTypeExample;

public interface ProductTypeMapper {
    int countByExample(ProductTypeExample example);

    int deleteByExample(ProductTypeExample example);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductType> selectByExampleWithBLOBs(ProductTypeExample example);

    List<ProductType> selectByExample(ProductTypeExample example);

    int updateByExampleSelective(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByExample(@Param("record") ProductType record, @Param("example") ProductTypeExample example);
}