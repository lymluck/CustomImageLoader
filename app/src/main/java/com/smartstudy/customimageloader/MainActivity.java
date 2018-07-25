package com.smartstudy.customimageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.smartstudy.customimageloader.ImgUtils.ImageCache;
import com.smartstudy.customimageloader.ImgUtils.ImageLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageCache.ImageCacheParams cacheParams = new ImageCache.ImageCacheParams(this, "thumbs");
        cacheParams.setMemCacheSizePercent(0.25f);// Set memory cache to 25% of app memory

        // The ImageLoader takes care of loading images into our ImageView children asynchronously
        ImageLoader imageLoader = new ImageLoader(this, 200);
        imageLoader.setLoadingImage(R.mipmap.ic_launcher);
        imageLoader.addImageCache(cacheParams);

        ImageView imageView = findViewById(R.id.iv);
        imageLoader.loadImage("http://upload-images.jianshu.io/upload_images/587163-c9fa78d5ed60bcc5.jpg",
            imageView);
    }
}
