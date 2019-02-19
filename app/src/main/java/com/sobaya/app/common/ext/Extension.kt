package sobaya.app.common.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import org.reactivestreams.Publisher

fun <T> Publisher<T>.toLiveData() = LiveDataReactiveStreams.fromPublisher(this)

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T?) -> Unit) = observe(owner, object : Observer<T> {
    override fun onChanged(v: T?) {
        observer.invoke(v)
    }
})

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageurl: String?) {
    if (null != imageurl) {
        Picasso.get().load(imageurl).into(this)
    }
}