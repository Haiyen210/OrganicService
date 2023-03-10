package com.project.organic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.organic.model.Account;
import com.project.organic.model.OrderDetail;
import com.project.organic.service.SendEmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SendMailController {
	@Autowired
	private SendEmailService notificationService;
	@Autowired
	private Account account;
	private OrderDetail orderDetail;

	@PostMapping("/send-mail")
	public String send(@RequestBody Account accounts) {
		account.setEmail(accounts.getEmail());
		account.setToken(accounts.getToken());
		try {
			notificationService.sendEmail(account);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Your mail has been send to the user.";
	}

	@PostMapping("/order-success")
	public String sendMailOrder(@RequestBody List<OrderDetail> orderDetail) { 

		for (OrderDetail orderDetail2 : orderDetail) {
			orderDetail2.setOrderId(orderDetail2.getOrderId());
			orderDetail2.setProductId(orderDetail2.getProductId());
		}
		try {
			notificationService.sendEmailOrder(orderDetail);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Your mail has been send to the user.";
	}

}
