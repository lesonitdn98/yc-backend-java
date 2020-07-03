package me.leson.controller;

import me.leson.model.Account;
import me.leson.model.User;
import me.leson.repository.AccountRepository;
import me.leson.repository.RoleRepository;
import me.leson.repository.UserRepository;
import me.leson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class JwtAuthenticationController {

    @Autowired
    private AccountRepository mAccountRepository;

    @Autowired
    private RoleRepository mRoleRepository;

    @Autowired
    private UserRepository mUserRepository;

    @Autowired
    private UserService mUserService;

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ResponseEntity<?> saveUser(@RequestBody User user) {
//        return ResponseEntity.ok(userRepository.save(user));
//    }

    @PostMapping(path = "/register")
    public @ResponseBody
    ResponseEntity<String> addNewUser(@RequestParam String phone
            , @RequestParam String password) {
        if (mAccountRepository.findByUsername(phone) == null) {
            Account account = new Account.AccountBuilder().accountBuilder(phone, password)
                    .withRole(mRoleRepository.findById(2)).withEnable(true).builder();
            mUserService.save(account);
        } else {
            return ResponseEntity.status(HttpStatus.RESET_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping(path = "/info")
    public @ResponseBody
    ResponseEntity<User> getUserInfo() {
        String userDetails = (String) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        User user = mUserRepository.findByAccount_Username(userDetails);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
