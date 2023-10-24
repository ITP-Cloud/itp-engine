package org.itp.engine.database;


import org.itp.engine.restful.ApiResponse;
import org.itp.engine.useraccount.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class DatabaseServerController {

    private final DatabaseServerService service;


    @Autowired
    public DatabaseServerController(DatabaseServerService service){
        this.service = service;
    }

    @PostMapping("database-user/new")
    public ResponseEntity<ApiResponse> createDatabaseUser(@RequestBody UserAccount user){

        this.service.createDbAccount(user);

        ApiResponse response = new ApiResponse(
                "Database user account successfully created",
                HttpStatus.OK.value()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("database-user/update")
    public ResponseEntity<ApiResponse> updateDatabaseUser(@RequestBody UserAccount user){

        this.service.updateDbAccount(user);

        ApiResponse response = new ApiResponse(
                "Database user account successfully created",
                HttpStatus.OK.value()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("database-user/delete")
    public ResponseEntity<ApiResponse> deleteDatabaseUser(@RequestBody UserAccount user){

        this.service.deleteDbAccount(user);

        ApiResponse response = new ApiResponse(
                "Database user account successfully deleted",
                HttpStatus.OK.value()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("database/new")
    public ResponseEntity<ApiResponse> createDatabase(@RequestBody Database database){

        this.service.createDb(database);

        ApiResponse response = new ApiResponse(
                "Database successfully created",
                HttpStatus.OK.value()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("database/delete")
    public ResponseEntity<ApiResponse> deleteDatabase(@RequestBody Database database){

        this.service.dropDb(database);

        ApiResponse response = new ApiResponse(
                "Database successfully dropped",
                HttpStatus.OK.value()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
