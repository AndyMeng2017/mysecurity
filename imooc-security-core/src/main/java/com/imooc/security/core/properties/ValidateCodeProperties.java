package com.imooc.security.core.properties;

/**
 * @Author: mhn
 * @Date: 2019/5/8 21:37
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
