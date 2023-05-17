package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.utils.QCloudOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

  @PostMapping
  public Result upload(MultipartFile file) throws IOException {

    log.info("文件上传：{}", file);
    String originalFilename = file.getOriginalFilename();

    int index = originalFilename.lastIndexOf(".");
    String extNama = originalFilename.substring(index);

    String newFileName = UUID.randomUUID().toString() + extNama;

    String localPath = "D:\\" + newFileName;
    file.transferTo(new File(localPath));

    List<String> pathList = new ArrayList<>();
    pathList.add(localPath);

    List<String> urlList = QCloudOSSUtils.updateList(pathList);
    return Result.success(urlList);
  }
}
