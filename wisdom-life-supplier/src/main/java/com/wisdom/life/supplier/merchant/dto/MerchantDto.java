package com.wisdom.life.supplier.merchant.dto;

import com.wisdom.life.core.merchant.model.Merchant;

/**
 * 商户dto,页面显示视图类
 */
public class MerchantDto extends Merchant {

	private String rePassword;

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

}
