package com.xlj.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author XuLeJun
 * @Date 2020/6/28 9:21
 */

public class UploadImage {

    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
