package com.zxu.convert;

import com.zxu.domain.CategoryInfo;
import com.zxu.constant.PageConst;
import com.zxu.util.CustomUtils;
import com.zxu.vo.Category4IndexVO;
import com.zxu.vo.CategoryVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品类别
 */
@Component
public class CategoryInfoConvert {
    private final String finalFatherID = "0";//父类的pid

    public List<CategoryVO> getCategoryVOS(List<CategoryInfo> categoryInfos) {
        List<CategoryVO> categoryVOS = categoryInfos.stream().map(this::getCategoryVO).collect(Collectors.toList());
        List<CategoryVO> bigCats = categoryVOS.stream().filter(m -> m.getPid().equals(finalFatherID)).collect(Collectors.toList());
        for (CategoryVO categoryVO : bigCats) {
            List<CategoryVO> childList = categoryVOS.stream().filter(m -> m.getPid().equals(categoryVO.getCatid())).collect(Collectors.toList());
            categoryVO.setChild(childList);
        }
        return bigCats;
    }

    private CategoryVO getCategoryVO(CategoryInfo categoryInfo) {
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setCatid(categoryInfo.getId());
        categoryVO.setDescription(categoryInfo.getName());
        categoryVO.setEx_table_id(0L);

        if (CustomUtils.isNotBlank(categoryInfo.getImgUrl())) {
            categoryVO.setImgurl(PageConst.IMG_PATH + "index_flash_01.png");
        }

        categoryVO.setOrderindex(0);
        categoryVO.setPid(categoryInfo.getPid());
        categoryVO.setStatus(1);
        categoryVO.setTitle(categoryInfo.getName());
        return categoryVO;
    }

    public List<Category4IndexVO> getCategory4IndexVOS(List<CategoryInfo> categoryInfos) {
        List<Category4IndexVO> categoryVOS = categoryInfos.stream().map(this::getCategory4IndexVO).collect(Collectors.toList());
        return categoryVOS;
    }

    private Category4IndexVO getCategory4IndexVO(CategoryInfo categoryInfo) {
        Category4IndexVO categoryVO = new Category4IndexVO();
        categoryVO.setId(categoryInfo.getId());
        categoryVO.setInfo(categoryInfo.getName());
        categoryVO.setTitle(categoryInfo.getName());
        return categoryVO;
    }
}
