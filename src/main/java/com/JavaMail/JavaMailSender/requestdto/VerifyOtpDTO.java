package com.JavaMail.JavaMailSender.requestdto;

public class VerifyOtpDTO {

	private String otp;
    private String enteredOtp;
    
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getEnteredOtp() {
		return enteredOtp;
	}
	public void setEnteredOtp(String enteredOtp) {
		this.enteredOtp = enteredOtp;
	}
	public VerifyOtpDTO(String otp, String enteredOtp) {
		super();
		this.otp = otp;
		this.enteredOtp = enteredOtp;
	}
}
