package com.document.documentmanagement.security;

import com.document.documentmanagement.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
