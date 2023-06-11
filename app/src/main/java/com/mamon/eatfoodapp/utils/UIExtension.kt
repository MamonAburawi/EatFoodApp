package com.mamon.eatfoodapp.utils


import android.app.Activity
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.snackbar.Snackbar
import com.mamon.eatfoodapp.R


fun Fragment.showMessage(message: String){
    Snackbar.make(this.requireView(), message, Snackbar.LENGTH_SHORT).show()
}

fun Activity.setColorStatusBar(color: Int){
    window.statusBarColor = ContextCompat.getColor(this, color)
}

@EpoxyModelClass(layout = R.layout.item_space_model)
abstract class SpaceModel : EpoxyModelWithHolder<SpaceModel.Holder>() {

    @EpoxyAttribute
    var height: Int = 0

    override fun bind(holder: Holder) {
        holder.spaceView.layoutParams.height = height
    }

    inner class Holder : EpoxyHolder() {
        lateinit var spaceView: View

        override fun bindView(itemView: View) {
            spaceView = itemView.findViewById(R.id.view_space)
        }
    }
}