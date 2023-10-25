package com.JavaMail.JavaMailSender.emailrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.JavaMail.JavaMailSender.emailmodel.EmailModel;

@Repository
public interface UserEmailRepository extends JpaRepository<EmailModel, Integer>{

	
}
