package com.magellans.cardtrading.schedule;

import com.magellans.cardtrading.service.ProductNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.ZoneId;

@Configuration
@EnableScheduling
public class StateDealScheduled {

//	public static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductNumberService productNumberService;

	@Scheduled(cron = "${order.update.deal}")
	public void executeScheduleCutMoney() {
		ZoneId vietnam = ZoneId.of("Asia/Ho_Chi_Minh");
		LocalDate localDate = LocalDate.now(vietnam);
		try {
			Boolean rs = productNumberService.updateDeal(localDate.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
