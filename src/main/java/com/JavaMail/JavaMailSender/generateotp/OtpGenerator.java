package com.JavaMail.JavaMailSender.generateotp;

import java.util.Random;

public class OtpGenerator {

	public static String generateotp() {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return Integer.toString(otp);
	}
}
