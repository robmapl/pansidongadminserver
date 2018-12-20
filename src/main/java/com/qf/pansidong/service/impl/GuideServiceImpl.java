package com.qf.pansidong.service.impl;

import com.qf.pansidong.dao.GuideDao;
import com.qf.pansidong.pojo.po.Guide;
import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.service.GuideService;
import com.qf.pansidong.util.GetPimage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideServiceImpl implements GuideService{

    @Autowired
    private GuideDao guideDao;

    @Override
    public List<Guide> listGuide() {
        List<Guide> guides = guideDao.listGuide();

        return guides;
    }

    @Override
    public PageVo<Guide> listGuideByPage(PageVo<Guide> pageVo) {
        pageVo.setTotalNum(guideDao.getGuideTotal());
        List<Guide> guides = guideDao.listGuideByPage(pageVo);
        pageVo.setListData(guides);
        return pageVo;
    }

    /**
     * 删除导游信息根据pid
     * @param pid
     * @return
     */
    @Override
    public int removeGuideByPid(int pid) {
        int r = guideDao.removeGuideByPid(pid);
        return r;
    }


    /**
     * 增加导游
     * @param guide
     * @return
     */
    @Override
    public int addGuideByGuide(Guide guide) {
        guide.setPimage(GetPimage.getPimage());
        int r = guideDao.addGuideByGuide(guide);
        return r;
    }

    /**
     * 编辑导游
     * @param guide
     * @return
     */
    @Override
    public int EditGuideByGuide(Guide guide) {
        int r = guideDao.EditGuideByGuide(guide);
        return r;
    }

    /**
     * 搜索导游
     * @param pageVo
     * @return
     */
    @Override
    public PageVo<Guide> searchGuide(PageVo<Guide> pageVo,String value) {
        pageVo.setTotalNum(guideDao.getSearchGuideTotal(value));
        List<Guide> guides = guideDao.searchGuide(pageVo,value);
        pageVo.setListData(guides);
        return pageVo;
    }

}
