package cxx.androidutils.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cxx.androidutils.R;
import cxx.androidutils.bean.MyBean;

/**
 * Created by LJN on 2017/9/28.
 */

public class MyAdapter extends BaseQuickAdapter<MyBean, BaseViewHolder> {

    private Context context;

    public MyAdapter(@LayoutRes int layoutResId, @Nullable List<MyBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyBean item) {
//        if (item.isShowIcon()) {
        ImageView view = helper.getView(R.id.ivIcon);
//        view.setImageResource(R.mipmap.ic_launcher);
//            Glide.with(context).load("http://avatar.csdn.net/F/2/F/1_return_code.jpg").into(view);
//        } else {
//            helper.setImageResource(R.id.ivIcon,R.mipmap.ic_launcher);
//        }
        helper.setText(R.id.tvName, item.getName());
        helper.setText(R.id.tvAge, String.valueOf(item.getAge()));
    }
}
