package com.gg.service.impl ;

import com.gg.bean.UserAddress ;
import com.gg.service.UserAddressService ;
import java.util.ArrayList ;
import java.util.Arrays ;
import java.util.List ;

public class UserServiceImpl implements UserAddressService {
	
	public List<UserAddress> getUserAddress(String userId) {
		UserAddress userAddress1 = new UserAddress(1, "桥西", "123", "关培", "188XXXX6929", "Y") ;
		UserAddress userAddress2 = new UserAddress(2, "滨河路", "123", "关培", "188XXXX6929", "N") ;
		return new ArrayList<UserAddress>(Arrays.asList(userAddress1, userAddress2)) ;
	}
}
