package com.magellans.cardtrading.resource.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FrontEndRS<T> {
	private List<T> items;

	public FrontEndRS(List<T> items) {
		this.items = items;
	}
}
