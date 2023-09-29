package org.itp.engine.useraccount;

import org.itp.engine.restful.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserAccountController {

    private final UserAccountService service;

    @Autowired
    public UserAccountController(UserAccountService service){
        this.service = service;
    }

    @PostMapping("api/v1/user-account")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserAccount request){

//        this.service.createUser(request);

        ApiResponse response = new ApiResponse(
                "User account successfully created",
                HttpStatus.OK.value()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
