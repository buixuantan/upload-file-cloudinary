package com.cg.controller.restAPI;

import com.cg.repository.model.Color;
import com.cg.service.color.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorRestController {

    @Autowired
    private IColorService colorService;

    @GetMapping
    public ResponseEntity<?> getAllColors() {

        List<Color> colors = colorService.findAll();

        if (colors.isEmpty()) {
            return new ResponseEntity<>("List colors is empty!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(colors, HttpStatus.OK);
    }
}
