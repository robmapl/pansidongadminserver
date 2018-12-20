package com.qf.pansidong.dao;

import com.qf.pansidong.pojo.po.Guide;
import com.qf.pansidong.pojo.vo.PageVo;
import jdk.nashorn.internal.objects.annotations.Property;

import java.util.List;


public interface GuideDao {

    List<Guide> listGuide();

    int getGuideTotal();

    List<Guide> listGuideByPage(PageVo<Guide> pageVo);

    int removeGuideByPid(int pid);

    int addGuideByGuide(Guide guide);

    int EditGuideByGuide(Guide guide);

    int getSearchGuideTotal(String value);

    List<Guide> searchGuide(PageVo<Guide> pageVo, String value);

//    List<Guide> listGuideByPage(PageVo<Guide> pageVO);

}
