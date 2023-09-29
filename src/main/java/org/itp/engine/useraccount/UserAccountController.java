package org.itp.engine.useraccount;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {

    @GetMapping("api/v1/lx-usr")
    public String getLinuxUsers(){
        return "Some users";
    }
}
