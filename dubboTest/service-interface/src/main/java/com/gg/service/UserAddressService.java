package com.gg.service ;

import com.gg.bean.UserAddress ;
import java.util.List ;

public interface UserAddressService {
	
	/**
	 * 按照用户id返回所有的收货地址
	 * @param userId
	 * @return
	 */
	List<UserAddress> getUserAddress(String userId) ;
}
