package com.JavaMail.JavaMailSender.service;


import java.util.List;

import com.JavaMail.JavaMailSender.emailmodel.EmailModel;
import com.JavaMail.JavaMailSender.exceptions.EmailVerify;
import com.JavaMail.JavaMailSender.exceptions.Emailnotsend;
import com.JavaMail.JavaMailSender.exceptions.Verifyotp;
import com.JavaMail.JavaMailSender.requestdto.EmailDTO;
import com.JavaMail.JavaMailSender.requestdto.VerifyEmailDTO;
import com.JavaMail.JavaMailSender.requestdto.VerifyOtpDTO;

public interface EmailService {

	 public List<EmailModel> getDetails();
	 public void saveInfo(EmailDTO emaildto);
	 public void sendSimpleMail(EmailDTO details) throws Emailnotsend;	    
	 public void sendEmail(VerifyEmailDTO verifyemaildto) throws EmailVerify;
	 public void VerifyOTP(VerifyOtpDTO verifyOtpdto) throws Verifyotp;
	 public void emailVerification(VerifyEmailDTO emaildto) throws EmailVerify;
	 public  void sendMailWithAttachment(EmailDTO details) throws Emailnotsend;
}
