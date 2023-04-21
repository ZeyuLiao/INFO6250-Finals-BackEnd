package edu.neu.booking.ticketbooking.service;
import edu.neu.booking.ticketbooking.controller.model.UserModel;
import edu.neu.booking.ticketbooking.entity.vo.LoginUser;

import edu.neu.booking.ticketbooking.utils.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    public LoginUser login(UserModel userModel) throws Exception {
        System.out.println(userModel.getUsername());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userModel.getUsername(),userModel.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }

        final UserDetails userDetails = userService.loadUserByUsername(userModel.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails.getUsername());

        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(userService.getUserById(userModel.getUsername()), loginUser);
        loginUser.setToken(token);
        return loginUser;
    }

    public void logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
