package com.example.eventapp.storage;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("/upload/image")
    public ResponseEntity fileUpload() {

        //데이터를 받아온것이라 가정
        Map<String, Object> data = new HashMap<>();
        data.put("userId","홍길동");
        data.put("type","webp");
        data.put("filesize",5);

        fileService.fileUpload(data);

        return ResponseEntity.ok("success");
    }
}
