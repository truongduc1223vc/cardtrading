package com.magellans.cardtrading.resource.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FrontEndRSForDeal<T> {

	private T items;
	private int totalCount;
	private int totalPage;

	public FrontEndRSForDeal(T items, int totalCount) {
		this.items = items;
		this.totalCount = totalCount;
	}

	public FrontEndRSForDeal(T items, int totalCount, int totalPage) {
		this.items = items;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}
}
