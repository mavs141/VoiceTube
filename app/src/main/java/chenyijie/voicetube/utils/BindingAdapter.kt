package chenyijie.voicetube.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import chenyijie.voicetube.R
import com.bumptech.glide.Glide

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(url: String) {
        Glide.with(this.context)
                .load(url)
                .error(this.context.getDrawable(R.mipmap.ic_launcher))
                .placeholder(this.context.getDrawable(R.mipmap.ic_launcher))
                .into(this)
    }

}