package com.Eccormerce.service.impl;

import com.Eccormerce.service.interf.AwsS3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@Profile("mock")
public class DummyAwsS3ServiceImpl implements AwsS3Service {
    @Override
    public String saveImageToS3(MultipartFile file) {

        log.info("Dummy S3 Service: Simulating image upload for file: {}",
                (file != null ? file.getOriginalFilename() : "null-file-name"));


        return "http://placeholder.com/images/" + (file != null ? file.getOriginalFilename() : "default-image") + "-" + System.currentTimeMillis() + ".jpg";
    }
}