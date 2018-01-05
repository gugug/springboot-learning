package com.gdufs.girl.service;

import com.gdufs.girl.dao.GirlRepository;
import com.gdufs.girl.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gu on 2017/12/4.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(18);
        girlRepository.save(girlB);

    }
}
