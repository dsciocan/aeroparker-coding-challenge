package com.dsc.aeroparker_coding_challenge.service;

import com.dsc.aeroparker_coding_challenge.model.User;

import javax.naming.SizeLimitExceededException;

public interface UserService {
    User saveUser(User user) throws SizeLimitExceededException;
}
