package org.itp.engine.ftp;

import org.itp.engine.database.Database;
import org.itp.engine.restful.ApiResponse;
import org.itp.engine.useraccount.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class FtpServerController {

    private final FtpServerService service;

    @Autowired
    public FtpServerController(FtpServerService service){
        this.service = service;
    }

    @PostMapping("ftp-account/new")
    public ResponseEntity<ApiResponse> createFtpAccount(@RequestBody UserAccount user){

        this.service.createFtpAccount(user);

        ApiResponse response = new ApiResponse(
                "Database successfully created",
                HttpStatus.OK.value()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
