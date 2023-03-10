package com.project.organic.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.project.organic.model.Account;
import com.project.organic.model.OrderDetail;

@Service
public class SendEmailService {
	private final JavaMailSender mailSender;
	private  OrderDetail orDetail;
	@Autowired
	public SendEmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendEmail(Account account) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(account.getEmail());
		mail.setSubject("Organic Fruit");
		mail.setText("Mã xác nhận để lấy lại mật khẩu: " + account.getToken() +"\n" +" Không được chia sẻ mã này cho bất kỳ ai tránh bị lừa đảo");
		mailSender.send(mail);
	}
	public void sendEmailOrder(List<OrderDetail> orderDetail) throws MailException {
		SimpleMailMessage mails = new SimpleMailMessage();
		mails.setTo(orderDetail.stream().map(a -> a.getOrderId().getEmail()).toArray(String[] :: new)); 
		mails.setSubject("Organic Fruit");
		String a = "";
		String b = "Bạn đã đặt hàng thành công!!";
		for (OrderDetail orderDetail2 : orderDetail) {
			a += "Mã sp: "+orderDetail2.getProductId().getCode()+ " " +"Tên sp: "+ orderDetail2.getProductId().getName()+ " " +"Số lượng: "+ orderDetail2.getQuantity()+ " " +"Giá tiền: "+ orderDetail2.getPrice()+"\n";

		}
		mails.setText(b+"\n"+a);
		mailSender.send(mails);
	}

}
