package org.itp.engine;

import org.itp.engine.restful.ApiRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class HomeController {
    @PostMapping("post/callback")
    public ResponseEntity<ApiRequest> createFtpAccount(@RequestBody ApiRequest req) {
        return ResponseEntity.status(HttpStatus.OK).body(req);
    }
}
