package com.zxu.controller;


import com.zxu.annotate.WithoutLogin;
import com.zxu.domain.CategoryDo;
import com.zxu.constant.PageConst;
import com.zxu.convert.CategoryInfoConvert;
import com.zxu.mapper.CategoryInfoMapper;
import com.zxu.result.MsgResult;
import com.zxu.vo.CategoryVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商品类别
 */
@RestController
public class CategoryController {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private CategoryInfoMapper categoryMapper;
    @Resource
    private CategoryInfoConvert categoryInfoConvert;

    /**
     * 查询品项类别树
     */
    @WithoutLogin
    @RequestMapping("/category/b2c_category_tree")
    public MsgResult b2c_category() {
        List<CategoryDo> categoryInfos = categoryMapper.selectList(null);
        List<CategoryVO> categoryVOS = categoryInfoConvert.getCategoryVOS(categoryInfos);
        System.out.println(PageConst.WEB_HOST);
        return MsgResult.doneUrl("catList", categoryVOS, PageConst.CATEGORY_INDEX);
    }
}
