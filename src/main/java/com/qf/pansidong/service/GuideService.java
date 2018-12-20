package com.qf.pansidong.service;

import com.qf.pansidong.pojo.po.Guide;
import com.qf.pansidong.pojo.vo.PageVo;

import java.util.List;

public interface GuideService {

    List<Guide> listGuide();

    PageVo<Guide> listGuideByPage(PageVo<Guide> pageVo);

    int removeGuideByPid(int pid);

    int addGuideByGuide(Guide guide);

    int EditGuideByGuide(Guide guide);

    PageVo<Guide> searchGuide(PageVo<Guide> pageVo, String value);
}
