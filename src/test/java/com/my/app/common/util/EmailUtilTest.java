package com.my.app.common.util;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/config-context.xml", "classpath:spring/root-context.xml",
		"classpath:spring/email-context.xml" })
public class EmailUtilTest {

	@Autowired
	private JavaMailSender javaMailSender;

	static {
		System.setProperty("spring.profiles.default", "local");
	}

	@Test
	public void testSendEmail() {
		javaMailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
				mimeMessageHelper.setFrom("보낸이메일");
				mimeMessageHelper.setTo("받을이메일");
				mimeMessageHelper.setSubject("제목");
				mimeMessageHelper.setText("내용");
			}
		});
	}

}
