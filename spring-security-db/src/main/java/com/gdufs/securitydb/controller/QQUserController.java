package com.gdufs.securitydb.controller;

import com.gdufs.securitydb.entity.QQUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QQUserController {

    @GetMapping("/qquser")
    public String user(@AuthenticationPrincipal UsernamePasswordAuthenticationToken userAuthentication, Model model){
        QQUser user = (QQUser) userAuthentication.getPrincipal();
        model.addAttribute("username", user.getNickname());
        model.addAttribute("avatar", user.getAvatar());
        return "user/qq_user";
    }

}
