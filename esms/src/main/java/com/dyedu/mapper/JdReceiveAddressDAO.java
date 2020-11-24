package com.dyedu.mapper;

import com.dyedu.bean.JdReceiveAddress;

public interface JdReceiveAddressDAO {
    JdReceiveAddress  findDefaultAddressByUserId(int user_id);
}
