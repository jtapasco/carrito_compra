package com.co.compras.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.co.compras.config.UsersProperties;
import com.co.compras.service.AuthService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthServiceImpl implements AuthService {
	
	private final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);
	
	@Autowired
	private UsersProperties usersProperties;

	@Override
	public String getJWTToken(String username, String pass) {
		
		Optional<String> userPass = Optional.of(usersProperties.getData(username));
		
		if (userPass.isPresent() && userPass.get().equals(pass)) {

			String secretKey = "mySecretKey";
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

			String token = Jwts.builder().setId("comprador").setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
			
			log.debug("Logueo exitoso");

			return "Bearer " + token;
		} else {
			log.info("Datos incorrectos en el logueo");
			return null;
		}
	}

}
