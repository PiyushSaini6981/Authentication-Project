package com.JavaMail.JavaMailSender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JavaMail.JavaMailSender.emailmodel.EmailModel;
import com.JavaMail.JavaMailSender.requestdto.EmailDTO;
import com.JavaMail.JavaMailSender.requestdto.VerifyEmailDTO;
import com.JavaMail.JavaMailSender.requestdto.VerifyOtpDTO;
import com.JavaMail.JavaMailSender.responsedto.ApiResponseDTO;
import com.JavaMail.JavaMailSender.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	
	@GetMapping
	public  ResponseEntity<List<EmailModel>> getDetails(){
		 return new ResponseEntity<>(this.emailService.getDetails(),HttpStatus.OK);
	}
	
	@PostMapping
	public  ResponseEntity<ApiResponseDTO> saveDetails(@RequestBody EmailDTO dto){
		this.emailService.saveInfo(dto);
        return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO("Information save Successfully"),HttpStatus.OK);
	}
	
	@PostMapping("/send")
    public ResponseEntity<ApiResponseDTO> sendMail(@RequestBody EmailDTO details){
		this.emailService.sendSimpleMail(details);
        return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO("Send Successfully"),HttpStatus.OK);
    }
 
	@PostMapping("/sendemailtootp")
	public ResponseEntity<ApiResponseDTO> SendMail(@RequestBody VerifyEmailDTO verifyemail){
		this.emailService.sendEmail(verifyemail);
        return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO("OTP Send Successfully"),HttpStatus.OK);
	}
	
	@PostMapping("/verifyotp")
	public ResponseEntity<ApiResponseDTO> OTPverify(@RequestBody VerifyOtpDTO verifyOTP){
		this.emailService.VerifyOTP(verifyOTP);
        return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO(" OTP Verified Successfully"),HttpStatus.OK);
	}
	@PostMapping("/verifyEmail")
	public ResponseEntity<ApiResponseDTO> Emailverify(@RequestBody VerifyEmailDTO verifyemaildto){
		this.emailService.emailVerification(verifyemaildto);
		return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO(" Email Verified Successfully"),HttpStatus.OK);
	}

    @PostMapping("/sendMailWithAttachment")
    public ResponseEntity<ApiResponseDTO> sendMailWithAttachment(@RequestBody EmailDTO details){
		this.emailService.sendMailWithAttachment(details);
        return new ResponseEntity<ApiResponseDTO>(new ApiResponseDTO("Send Email With Attachment Successfully"),HttpStatus.OK);

    }
}
