package com.dyedu.service;

import com.dyedu.bean.JdReceiveAddress;
import com.dyedu.mapper.JdReceiveAddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gdx
 * @description 收货地址的服务类
 * @date 2020/1/9
 */
@Service("addressService")
public class JdReceiveAddressService {
    @Autowired
    private JdReceiveAddressDAO  addressDao;
    public JdReceiveAddress  defaultAddressByUserId(int user_id){
        return  addressDao.findDefaultAddressByUserId(user_id);
    }
}
