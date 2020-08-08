package org.lh.fileupload.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName: FileUpLoadController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 13:51
 * @Version: 1.0
 **/
@RestController
public class FileUpLoadController {

    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request){
        String realPath = request.getServletContext().getRealPath("/img");
        File folder = new File(realPath);
        if (!folder.exists()){
            folder.mkdirs();
        }
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        try {
            file.transferTo(new File(folder,fileName));
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }


    @PostMapping("/uploads")
    public String uploads(MultipartFile[] files, HttpServletRequest request) {
        String realPath = request.getServletContext().getRealPath("/img");
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
            try {
                file.transferTo(new File(folder, fileName));
                System.out.println(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
