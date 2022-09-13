package com.cg.controller.restAPI;


import com.cg.repository.model.Size;
import com.cg.service.size.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
public class SizeRestController {

    @Autowired
    private ISizeService sizeService;

    @GetMapping
    public ResponseEntity<?> getAllSizes() {

        List<Size> sizes = sizeService.findAll();

        if (sizes.isEmpty()) {
            return new ResponseEntity<>("List sizes is empty!", HttpStatus.OK);
        }
        return new ResponseEntity<>(sizes, HttpStatus.OK);
    }

}
