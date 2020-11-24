package com.dyedu.service;

import com.dyedu.bean.JdCategory;
import com.dyedu.mapper.JdCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gdx
 * @description 分类的服务类
 * @date 2019/12/30
 */
@Service("categoryService")
public class JdCategoryService {
    @Autowired
    private JdCategoryDAO  categoryDao;
    /*
     *功能描述  根据父分类id 获取子分类列表
     * @author gdx
     * @date 2019/12/30
     * @param [parent_id]
     * @param parent_id    父分类id
     * @return java.util.List<com.dyedu.bean.JdCategory>
     */
    public List<JdCategory>   subCategoryList(int  parent_id){
        return   categoryDao.findSubCategoriesByParentId(parent_id);
    }
}
