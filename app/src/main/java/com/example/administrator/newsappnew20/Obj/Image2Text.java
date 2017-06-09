package com.example.administrator.newsappnew20.Obj;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/8/008.
 */

public class Image2Text implements Serializable{
    private int photoId;
    private String title;

    public Image2Text(int photoId, String title) {
        this.photoId = photoId;
        this.title = title;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getTitle() {
        return title;
    }

}
