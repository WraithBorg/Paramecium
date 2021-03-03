package com.zxu.controller;

import com.zxu.util.SessionUtil;
import com.zxu.annotate.WithoutLogin;
import com.zxu.domain.CategoryDo;
import com.zxu.domain.ItemDo;
import com.zxu.domain.ItemImgDo;
import com.zxu.domain.UserDo;
import com.zxu.constant.PageConst;
import com.zxu.convert.CategoryInfoConvert;
import com.zxu.convert.ItemInfoConvert;
import com.zxu.mapper.CategoryInfoMapper;
import com.zxu.mapper.ItemInfoImgMapper;
import com.zxu.mapper.ItemInfoMapper;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.result.MsgResult;
import com.zxu.service.usb.ItemInfoService;
import com.zxu.service.usb.UserFavItemService;
import com.zxu.util.CustomUtils;
import com.zxu.vo.CategoryVO;
import com.zxu.vo.ItemInfoVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ItemInfoController {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private ItemInfoMapper itemInfoMapper;
    @Resource
    private CategoryInfoMapper categoryInfoMapper;
    @Resource
    private ItemInfoConvert itemInfoConvert;
    @Resource
    private CategoryInfoMapper categoryMapper;
    @Resource
    private CategoryInfoConvert categoryInfoConvert;
    @Resource
    private ItemInfoImgMapper itemInfoImgMapper;
    @Resource
    private ItemInfoService infoService;
    @Resource
    private UserFavItemService userFavInfoService;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private ItemInfoService itemInfoService;

    /**
     * 商品列表
     */
    @WithoutLogin
    @RequestMapping("item/b2c_product/list")
    public MsgResult list(@RequestParam(required = false) String orderby,
                          @RequestParam(required = false) String catid) {
        UserDo currentUser = SessionUtil.getCurrentUser(httpServletRequest);

        List<ItemDo> itemInfos;

        // category
        Map catMap = null;
        if (CustomUtils.isNotBlank(catid)) {
            CategoryDo catDB = categoryInfoMapper.selectById(catid);
            catMap = CustomUtils.ofMap("catid", catDB.getId(), "pid", catDB.getPid(), "title", catDB.getName());
            itemInfos = itemInfoMapper.selectByMap(CustomUtils.ofMap(ItemDo.t.category_id, catid));
        } else {
            itemInfos = itemInfoMapper.selectList(null);
        }
        itemInfos.forEach(m -> {
            List<ItemImgDo> itemInfoImgs = itemInfoImgMapper.selectByMap(CustomUtils.ofMap(ItemImgDo.t.item_id, m.getId(), ItemImgDo.t.default_flag, "1"));
            if (itemInfoImgs.size() > 0) {
                m.setDefaultImg(itemInfoImgs.get(0).getUrl());
            }
        });
        List<ItemInfoVO> list = itemInfoConvert.getItemInfoVOS(currentUser, itemInfos);

        // category
        Map data = CustomUtils.ofMapN(
                "cat", catMap,
                "catList", "",
                "list", list,
                "pagelist", false,
                "per_page", 0,
                "rscount", 0
        );
        return MsgResult.doneUrl(data, PageConst.PRODUCT_LIST_4CATEGORY + catid);
    }

    /**
     * 相似商品
     */
    @WithoutLogin
    @RequestMapping("item/b2c_product/likelist")
    public MsgResult likelist(@RequestParam String productid) {
        UserDo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
        //
        List<CategoryDo> categoryInfos = categoryMapper.selectList(null);
        List<CategoryVO> categoryVOS = categoryInfoConvert.getCategoryVOS(categoryInfos);
        //
        List<ItemDo> itemInfos = itemInfoService.selectListWithImg();
        List<ItemInfoVO> list = itemInfoConvert.getItemInfoVOS(currentUser, itemInfos);
        Map data = CustomUtils.ofMapN(
                "rscount", 0,
                "per_page", 0,
                "pagelist", false,
                "catList", categoryVOS,
                "list", list);
        return MsgResult.doneUrl(data, PageConst.PRODUCT_SHOW + productid);
    }

    /**
     * 显示商品
     */
    @WithoutLogin
    @RequestMapping("item/b2c_product/show")
    public MsgResult show(@RequestParam String id, @RequestParam String orderid) {
        UserDo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
        ItemDo itemInfo = infoService.getItemWithImg(id);
        ItemInfoVO itemInfoVO = itemInfoConvert.getItemInfoVO(currentUser, itemInfo);

        List<ItemImgDo> itemInfoImgs = itemInfoImgMapper.selectByMap(CustomUtils.ofMap(ItemImgDo.t.item_id, id));
        List<String> imgsdata = itemInfoImgs.stream().map(m -> {
            if (CustomUtils.isBlank(m.getUrl())) {
                return null;
            }
            return PageConst.IMG_PATH + "index_flash_01.png";
        }).collect(Collectors.toList());
        // 查看是否该商品是否在收藏夹里
        UserDo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        Integer hasFav;
        if (defaultUser == null) {
            hasFav = 0;
        } else {
            hasFav = userFavInfoService.hasFav(defaultUser.getId(), itemInfo.getId());
        }

        Map dataMap = CustomUtils.ofMapN(
                "cart_amount", itemInfoVO.getCart_amount(),
                "data", itemInfoVO,
                "fieldsList", null,
                "imgsdata", imgsdata,
                "isfav", hasFav,//收藏
                "ksList", new ArrayList<>(),
                "ksList2", null,
                "ksid", 0,
                "order", false,
                "pts", false,
                "pts_num", 0,
                "sharePic",
                ""
        );
        return MsgResult.doneUrl(dataMap, PageConst.PRODUCT_SHOW + id);
    }

    /**
     * 商品评价列表
     * Raty
     */
    @WithoutLogin
    @RequestMapping("item/b2c_product/raty")
    public MsgResult raty(@RequestParam String id, @RequestParam String limit) {
        ArrayList<Object> list = new ArrayList<>();
//        UserInfo userInfo = SessionUtil.getCurrentUser(httpServletRequest);
        list.add(CustomUtils.ofMap("user_head", PageConst.IMG_PATH + "userInfo.getHeadImgUrl()",
                "nickname", "张三",
                "raty_grade", "3",
                "raty_content", "这玩意真好"));
        list.add(CustomUtils.ofMap("user_head", PageConst.IMG_PATH + ":userInfo.getHeadImgUrl()",
                "nickname", "李四",
                "raty_grade", "3",
                "raty_content", "这玩意真垃圾"));
        Map dataMap = CustomUtils.ofMapN("list", list, "productid", id, "rscount", 2);
        return MsgResult.doneUrl(dataMap, PageConst.PRODUCT_SHOW + id);
    }

    /**
     * 相似商品
     */
    @WithoutLogin
    @RequestMapping("item/b2c_product/reclist")
    public MsgResult reclist(@RequestParam String productid) {
        UserDo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
        //
        List<CategoryDo> categoryInfos = categoryMapper.selectList(null);
        List<CategoryVO> categoryVOS = categoryInfoConvert.getCategoryVOS(categoryInfos);
        //
        List<ItemDo> itemInfos = itemInfoService.selectListWithImg();
        List<ItemInfoVO> list = itemInfoConvert.getItemInfoVOS(currentUser, itemInfos);
        Map data = CustomUtils.ofMapN(
                "rscount", list.size(),
                "per_page", 0,
                "pagelist", false,
                "catList", categoryVOS,
                "list", list);
        return MsgResult.doneUrl(data, PageConst.PRODUCT_SHOW + productid);
    }
}
