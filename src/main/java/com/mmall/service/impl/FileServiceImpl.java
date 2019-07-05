package com.mmall.service.impl;

import com.mmall.service.IFileService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: dtvikey
 * @Date: 05/07/19 下午 04:53
 * @Version 1.0
 */
public class FileServiceImpl implements IFileService {
    public String upload(MultipartFile file,String path){
        String fileName = file.getOriginalFilename();
    }
}
