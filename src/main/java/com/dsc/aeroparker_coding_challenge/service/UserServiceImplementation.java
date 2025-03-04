package com.dsc.aeroparker_coding_challenge.service;

import com.dsc.aeroparker_coding_challenge.model.User;
import com.dsc.aeroparker_coding_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.SizeLimitExceededException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) throws SizeLimitExceededException {
        // Required fields validation
        if(user.getTitle().isEmpty() || user.getFirstName().isEmpty()  || user.getLastName().isEmpty() || user.getEmailAddress().isEmpty() || user.getAddressLine1().isEmpty() || user.getPostcode().isEmpty()) {
            throw new NullPointerException("Required fields cannot be empty");
        // Input length validation
        } else if(user.getEmailAddress().length() > 255 || user.getTitle().length() > 5 || user.getFirstName().length() > 50 || user.getLastName().length() > 50 || user.getAddressLine1().length() > 255 || user.getPostcode().length() > 10 || user.getAddressLine2().length() > 255 || user.getCity().length() > 255 || user.getPhoneNumber().length() > 20) {
            throw new SizeLimitExceededException("Length exceeded for some fields");
        // Email format and uniqueness validation
        } else if (!Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$").matcher(user.getEmailAddress()).matches() || !userRepository.findByEmailAddress(user.getEmailAddress()).isEmpty()) {
            throw new IllegalArgumentException("Invalid email address");
        } else {
            user.setRegistered(LocalDateTime.now());
            return userRepository.save(user);
        }
    }
}
