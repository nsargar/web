package configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.Data;


@Configuration
@PropertySource("classpath:mail.properties")
@ConfigurationProperties(prefix="mail")
//@Data
public class EmailConfig {
	
		
	@Data
    public static class Smtp {

        private boolean auth;
        private boolean enable=true;
        private boolean required=true;

        // ... getters and setters
    }

    @Override
	public String toString() {
		return "EmailConfig [host=" + host + ", port=" + port + ", from=" + from + ", username=" + username
				+ ", password=" + password + ", protocol=" + protocol + ", smtp=" + smtp.toString() + "]";
	}

	//@NotBlank
    private String host;
    private int port;  
    private String from;
    private String username;
    private String password;
    private String protocol;
    //@NotNull
    private Smtp smtp;

    // ... getters and setters   

    @Bean
    public JavaMailSender javaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", smtp.auth);
        mailProperties.put("mail.smtp.starttls.enable", smtp.enable);
        mailProperties.put("mail.smtp.starttls.required", smtp.required);
        mailSender.setJavaMailProperties(mailProperties);
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setProtocol(protocol);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        return mailSender;
        }

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Smtp getSmtp() {
		return smtp;
	}

	public void setSmtp(Smtp smtp) {
		this.smtp = smtp;
	}
	
   

}
