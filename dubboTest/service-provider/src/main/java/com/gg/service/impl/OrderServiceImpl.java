package com.gg.service.impl ;

import com.gg.bean.UserAddress;
import com.gg.service.OrderService ;
import com.gg.service.UserAddressService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    UserAddressService userAddressService;

	public void initUserAddress(String userId) {

        List<UserAddress> userAddressList = userAddressService.getUserAddress(userId);

        userAddressList.forEach(System.out::println);
    }
}
