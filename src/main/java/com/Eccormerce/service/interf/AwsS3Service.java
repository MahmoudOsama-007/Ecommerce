package com.Eccormerce.service.interf;
import org.springframework.web.multipart.MultipartFile;

public interface AwsS3Service {
    String saveImageToS3(MultipartFile file);
}
