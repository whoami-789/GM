package com.example.gm.controllers;

import com.example.gm.payload.response.MessageResponse;
import com.example.gm.servises.ResultService;
import com.example.gm.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/api/doctor-panel")
@CrossOrigin
public class DoctorController {

    @Autowired
    private UserService userService;
    @Autowired
    private ResultService resultService;

    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadFiles(@RequestParam("file1")MultipartFile dicom,
                                                       @RequestParam("file2")MultipartFile conc,
                                                       Principal principal,Long zapisId) throws IOException {

        resultService.saveResult(principal, zapisId, dicom, conc);
        return ResponseEntity.ok(new MessageResponse("Files uploaded successfully"));
    }

}
