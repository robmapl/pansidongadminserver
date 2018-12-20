package com.qf.pansidong.web;

import com.qf.pansidong.pojo.po.Guide;
import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.service.GuideService;
import com.qf.pansidong.util.GetSPimage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class GuideAction {
    @Autowired
    private GuideService guideService;

//查询数据库所有
//    @ResponseBody
//    @RequestMapping(value = "/guide",method = RequestMethod.POST)
//    public List<Guide> listGuide(HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        return guideService.listGuide();
//    }

    /**
     * 查询导游信息并分页，从前端页面接受当前页 current 和 每页显示条数 pagesize 两个参数
     * @param current
     * @param pagesize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/guide",method = RequestMethod.GET)
    public PageVo<Guide> listGuideByPage(@RequestParam(name="current",defaultValue ="1") int current,int pagesize){
//        System.out.println(current+"======="+pagesize);
        PageVo<Guide> pageVo = new PageVo<>();
        pageVo.setCurrentPage(current);
        pageVo.setPageSize(pagesize);

        pageVo = guideService.listGuideByPage(pageVo);
//        System.out.println("++++++++++++"+pageVo);
        return  pageVo;
    }

    /**
     * 根据pid删除对应导游信息，需从前端页面获得pid参数
     * @param pid
     */
    @ResponseBody
    @RequestMapping(value = "/guide",method = RequestMethod.DELETE)
    public int removeGuideByPid(int pid){
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        System.out.println("~~~~~~~~"+pid);
        int r = guideService.removeGuideByPid(pid);
        return r;
    }

    /**
     * 增加新导游
     * @param guide
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/guide",method = RequestMethod.POST)
    public int addGuideByGuide(Guide guide){
        System.out.println(guide);

        int r = guideService.addGuideByGuide(guide);
        return r;
    }

    /**
     * 修改导游信息
     * @param guide
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/guide",method = RequestMethod.PUT)
    public int EditGuideByGuide(Guide guide){
        System.out.println("111111111111111111"+guide);
        int r = guideService.EditGuideByGuide(guide);
        return r;
    }


    /**
     * 带关键字搜索导游
     * @param current
     * @param pagesize
     * @param value13
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/guideSearch",method = RequestMethod.GET)
    public PageVo<Guide> searchGuide(@RequestParam(name="current",defaultValue ="1") int current,int pagesize,String value13){
//        System.out.println(current+"======="+pagesize+"____________"+value13);
        PageVo<Guide> pageVo = new PageVo<>();
        pageVo.setCurrentPage(current);
        pageVo.setPageSize(pagesize);

        pageVo = guideService.searchGuide(pageVo,value13);
//        System.out.println("++++++++++++"+pageVo);
        return  pageVo;
    }

    /**
     * 前台显示页面分页查询
     * @param current
     * @param pagesize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/guideShow",method = RequestMethod.GET)
    public PageVo<Guide> listGuideByPageShow(@RequestParam(name="current",defaultValue ="1") int current,int pagesize){
//        System.out.println(current+"======="+pagesize);
        PageVo<Guide> pageVo = new PageVo<>();
        pageVo.setCurrentPage(current);
        pageVo.setPageSize(pagesize);

        pageVo = guideService.listGuideByPage(pageVo);
//        System.out.println("++++++++++++"+pageVo);
        return  pageVo;
    }

    /**
     * sguide的查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sguide",method = RequestMethod.GET)
    public String getSPimage(){

        return GetSPimage.getSPimage();
    }

    /**
     * 查询导游信息打乱顺序并分页，从前端页面接受当前页 current 和 每页显示条数 pagesize 两个参数
     * @param current
     * @param pagesize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/guideRandom",method = RequestMethod.GET)
    public PageVo<Guide> listGuideByPageRandom(@RequestParam(name="current",defaultValue ="1") int current,int pagesize){
//        System.out.println(current+"======="+pagesize);
        PageVo<Guide> pageVo = new PageVo<>();
        pageVo.setCurrentPage(current);
        pageVo.setPageSize(pagesize);

        pageVo = guideService.listGuideByPage(pageVo);
        Collections.shuffle(pageVo.getListData());
//        System.out.println("++++++++++++"+pageVo);
        return  pageVo;
    }


}
