package kr.hs.emirim.w2034.project11_2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryAdapter extends BaseAdapter {
    Context context;
    String[] movieName = {"기생충", "겟아웃", "조커", "라라랜드", " 뷰티인사이드", "겨울왕국2", "침입자", "크루엘라", "알라딘", "보헤미안 랩소디"};
    int[] posterIds = {R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4, R.drawable.movie5, R.drawable.movie6,
                        R.drawable.movie7, R.drawable.movie8, R.drawable.movie9, R.drawable.movie10};
    ImageView imgvLarge;

    public GalleryAdapter(Context context, ImageView imgvLarge){
        this.context = context;
        this.imgvLarge = imgvLarge;
    }
    @Override
    public int getCount() {
        return posterIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200,300));
        imgv.setImageResource(posterIds[position]);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final  int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgvLarge.setImageResource(posterIds[pos]);
                Toast toast = new Toast(context);
                View toastViwe = View.inflate(context, R.layout.toast1, null);
                TextView textView = toastViwe.findViewById(R.id.text_title);
                textView.setText(movieName[pos]);
                toast.setView(toastViwe);
                toast.show();
            }
        });

        return imgv;
    }
}
