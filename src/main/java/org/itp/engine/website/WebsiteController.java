package org.itp.engine.website;

import org.itp.engine.restful.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/")
public class WebsiteController {

    private final WebsiteService service;

    @Autowired
    public WebsiteController(WebsiteService service) {
        this.service = service;
    }

    @PostMapping("website/new")
    public ResponseEntity<ApiResponse> createWebsite(@RequestBody Website website) {

        this.service.createWebsite(website);

        ApiResponse response = new ApiResponse(
                "Website successfully created",
                HttpStatus.OK.value()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
