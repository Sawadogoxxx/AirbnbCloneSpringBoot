package com.rbnbproject.rbnbcloneproject.controller;
import com.rbnbproject.rbnbcloneproject.controller.api.AppRoute;
import com.rbnbproject.rbnbcloneproject.controller.api.Test;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(path = AppRoute.root)
public class TestController {

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/test")
    public String testUploadImage(@RequestParam("param") String myParam){
        return myParam;
    }

    @PostMapping("/upload") public StringBuilder uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        return new StringBuilder();
    }
}
