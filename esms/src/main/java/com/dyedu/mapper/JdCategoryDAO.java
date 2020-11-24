package com.dyedu.mapper;

import com.dyedu.bean.JdCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JdCategoryDAO {
    List<JdCategory> findSubCategoriesByParentId(@Param("parent_id") int parent_id);
}
