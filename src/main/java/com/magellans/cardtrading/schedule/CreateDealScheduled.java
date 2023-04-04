package com.magellans.cardtrading.schedule;

import com.magellans.cardtrading.resource.model.OrderDetail;
import com.magellans.cardtrading.service.ProductNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class CreateDealScheduled {

	@Autowired
	private ProductNumberService productNumberService;


	@Scheduled(cron = "${order.create}")
	public void executeScheduleCreateDeal() {
		try {
			List<OrderDetail> dealNumberList = productNumberService.dealOfYesterday();
			for (OrderDetail item:dealNumberList) {
				Boolean rs = productNumberService.createDeal(item.getDeviceId(), item.getProductId(),item.getAppId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
