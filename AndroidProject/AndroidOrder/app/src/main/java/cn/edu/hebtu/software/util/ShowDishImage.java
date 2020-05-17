package cn.edu.hebtu.software.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ShowDishImage extends AsyncTask<Object,Object,Bitmap> {

    private ImageView dishImg;
    private String imgUrl;

    public ShowDishImage(ImageView dishImg, String imgUrl){
        this.dishImg = dishImg;
        this.imgUrl = imgUrl;
    }

    @Override
    protected Bitmap doInBackground(Object... objects) {
        Bitmap bitmap = returnBitmap(imgUrl);
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if(bitmap!=null && dishImg!=null){
            dishImg.setImageBitmap(bitmap);
        }
    }

    private Bitmap returnBitmap(String imgUrl) {
        URL myFileUrl;
        Bitmap bitmap;
        if(imgUrl!=null){
            try {
                myFileUrl = new URL(imgUrl);

                HttpURLConnection conn;
                if(myFileUrl!=null){
                    conn = (HttpURLConnection) myFileUrl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(is);
                    is.close();
                    return bitmap;
                }
            }catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
