package io.raveerocks.devbytesviewer.adapter

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import io.raveerocks.devbytesviewer.R
import io.raveerocks.devbytesviewer.databinding.DevbyteItemBinding

class DevByteViewHolder(val viewDataBinding: DevbyteItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.devbyte_item
    }
}