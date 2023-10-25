package com.JavaMail.JavaMailSender.serviceimpl;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.JavaMail.JavaMailSender.emailmodel.EmailModel;
import com.JavaMail.JavaMailSender.emailrepository.UserEmailRepository;
import com.JavaMail.JavaMailSender.exceptions.EmailVerify;
import com.JavaMail.JavaMailSender.exceptions.Emailnotsend;
import com.JavaMail.JavaMailSender.exceptions.Verifyotp;
import com.JavaMail.JavaMailSender.generateotp.OtpGenerator;
import com.JavaMail.JavaMailSender.requestdto.EmailDTO;
import com.JavaMail.JavaMailSender.requestdto.VerifyEmailDTO;
import com.JavaMail.JavaMailSender.requestdto.VerifyOtpDTO;
import com.JavaMail.JavaMailSender.service.EmailService;

@Service
public class EmailServiceIMPL implements EmailService {	
	
	@Autowired private JavaMailSender javaMailSender;
	
	@Autowired private UserEmailRepository emailrepository;
	
    @Value("${spring.mail.username}") 
    private String sender;
    
    
    public List<EmailModel> getDetails(){
    	List<EmailModel> email = emailrepository.findAll();
    	return email;
    }
    
    @Override
	public void saveInfo(EmailDTO emaildto) {
    	EmailModel model = new EmailModel();
    	model.setRecipient(emaildto.getRecipient());
    	model.setSubject(emaildto.getSubject());
    	model.setMsgBody(emaildto.getMsgBody());
    	model.setAttachment(emaildto.getAttachment());
    	emailrepository.save(model);
		
	}
    
	@Override
	public void sendSimpleMail(EmailDTO details){
        
		 try {
	            SimpleMailMessage mailMessage = new SimpleMailMessage();
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(details.getRecipient());
	            mailMessage.setText(details.getMsgBody());
	            mailMessage.setSubject(details.getSubject());
	            javaMailSender.send(mailMessage);
		 }catch (Exception e) {
	            throw new Emailnotsend("Error while sending simple mail!!!");
	        }
	}

	@Override
	public void sendMailWithAttachment(EmailDTO details) {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {	
	        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(sender);
	        mimeMessageHelper.setTo(details.getRecipient());
	        mimeMessageHelper.setText(details.getMsgBody());
	        mimeMessageHelper.setSubject(details.getSubject());
	        FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));
	        mimeMessageHelper.addAttachment(file.getFilename(), file);
	        javaMailSender.send(mimeMessage);
		}catch (Exception e) {
            throw new Emailnotsend("Error while sending attachment mail!!!");
		}
	}

	@Override
	public void sendEmail(VerifyEmailDTO verifyemaildto) {
		String otp = OtpGenerator.generateotp();
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			 msg.setTo(verifyemaildto.getEmail());
		        msg.setSubject("OTP Verification");
		        msg.setText("Your OTP is " + otp);
		        javaMailSender.send(msg);
		}catch (Exception e) {
            throw new EmailVerify("Error while verifing the Email !!!");
		}
	}

	@Override
	public void VerifyOTP(VerifyOtpDTO verifyOtpdto) throws Verifyotp {
		if(verifyOtpdto.getOtp().equals(verifyOtpdto.getEnteredOtp())) {
			
		}else {
			throw new Verifyotp("Error while verifing the OTP !!!");
		}
	}

	@Override
	public void emailVerification(VerifyEmailDTO emaildto) {        
		 try {
			 MimeMessage message = javaMailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message,true);
	            helper.setTo(new InternetAddress(emaildto.getEmail()));
	            helper.setSubject("Test Email");
	            helper.setText("This is a test email.");
	            javaMailSender.send(message);
		 }catch (MessagingException e) {
	            throw new EmailVerify("Email Does not exist in the world");
	    }
	}
}

