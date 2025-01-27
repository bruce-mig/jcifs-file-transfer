package com.github.bruce_mig.jcifs_file_transfer.controller;

import com.github.bruce_mig.jcifs_file_transfer.service.JcifsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JcifsController {

    private final JcifsService jcifsService;

    public JcifsController(JcifsService jcifsService) {
        this.jcifsService = jcifsService;
    }


    @GetMapping("/upload")
    public ResponseEntity<?> uploadFile() {
        jcifsService.sendFileToSmb();
        return ResponseEntity.ok().build();
    }
}
