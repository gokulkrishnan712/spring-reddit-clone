package com.reddit.service;

import java.time.Instant;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reddit.model.NotificationEmail;
import com.reddit.model.RegisterRequest;
import com.reddit.model.User;
import com.reddit.model.VerificationToken;
import com.reddit.repository.UserRepository;
import com.reddit.repository.VerificationTokenRepository;

@Service
public class AuthService {
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserRepository userRep;
	@Autowired
	private VerificationTokenRepository verifyRep;
	@Autowired
	private MailService mailService;
	
	@Transactional
	public void signUp(RegisterRequest register) {
		User user=new User();
		user.setUserName(register.getUsername());
		user.setPassword(encoder.encode(register.getPassword()));
		user.setEmail(register.getEmail());
		user.setCreated(Instant.now());
		user.setEnabled(false);
		
		userRep.save(user);
		String token=generateVerificationToken(user);
		mailService.sendMail(new NotificationEmail("Please Activate your Account",user.getEmail(),
				"Thank you for registering in subreddit \n you are one step ahead to open account with us \n"+
				"please click the following link to activate your account"+
				"http://localhost:8080/api/reddit/accountVerification/"+token));
	}
	
	private String generateVerificationToken(User user) {
		String token=UUID.randomUUID().toString();
		VerificationToken vt=new VerificationToken();
		vt.setToken(token);
		vt.setUser(user);
		verifyRep.save(vt);
		
		return token;
	}

}
