package chenyijie.voicetube.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import chenyijie.voicetube.R
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions



object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(url: String) {
        val options = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)

        Glide.with(this.context)
                .load(url)
                .apply(options)
                .into(this)
    }

}