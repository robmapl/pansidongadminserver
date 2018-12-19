package com.qf.pansidong.service.impl;

import com.qf.pansidong.dao.TripDao;
import com.qf.pansidong.pojo.po.TripDetails;
import com.qf.pansidong.pojo.po.Type;
import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripDao tripDao;
    @Override
    public PageVo<TripDetails> listTrip(int currentPage) {
        PageVo<TripDetails> pvo = new PageVo<>();
        pvo.setCurrentPage(currentPage);
        pvo.setPageSize(8);
        List<TripDetails> list1 = tripDao.listTrip();
        pvo.setTotalNum(list1.size());
        List<TripDetails> list2 = tripDao.listTripByPage(pvo.getOffset(),pvo.getPageSize());
        pvo.setListData(list2);
        return pvo;
    }

    @Override
    public List<Type> ListType() {
        return tripDao.ListType();
    }

    @Override
    public PageVo<TripDetails> ListTripByType(int currentPage,int ttid){
        PageVo<TripDetails> pvo = new PageVo<>();
        pvo.setCurrentPage(currentPage);
        pvo.setPageSize(8);
        List<TripDetails> list1 = tripDao.listTripByTypec(ttid);
        pvo.setTotalNum(list1.size());
        List<TripDetails> list2 = tripDao.ListTripByType(pvo.getOffset(),pvo.getPageSize(),ttid);
        pvo.setListData(list2);
        return pvo;
    }

    @Override
    public void addTravel(TripDetails tripDetails) {
        tripDetails.setTimage("travel/travel_1.jpg");
        tripDetails.setTravalid(UUID.randomUUID().toString());
        tripDao.addTravel(tripDetails);
    }

    @Override
    public TripDetails getTravelById(String travalid) {

        return tripDao.getTravelById(travalid);
    }

    @Override
    public void updateTravel(TripDetails tripDetails) {
        if("国内跟团游".equals(tripDetails.getTypename())){
            tripDetails.setTypename("1");
        }else if("国内自行游".equals(tripDetails.getTypename())){
            tripDetails.setTypename("2");
        }else if("国外跟团游".equals(tripDetails.getTypename())){
            tripDetails.setTypename("3");
        }else if("国外自行游".equals(tripDetails.getTypename())){
            tripDetails.setTypename("4");
        }
        tripDao.updateTravel(tripDetails);
    }

    @Override
    public void deleteTravel(String travalid) {
        tripDao.deleteTravel(travalid);
    }
}
