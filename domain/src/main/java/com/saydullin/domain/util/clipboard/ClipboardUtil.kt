package com.saydullin.domain.util.clipboard

import android.content.ClipboardManager
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ClipboardUtil @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)as ClipboardManager

    fun getLastItem(): String {
        if (clipboardManager.hasPrimaryClip()) {
            val clipData = clipboardManager.primaryClip
            if (clipData != null && clipData.itemCount > 0) {
                val clipText = clipData.getItemAt(0).text.toString()

                return clipText
            }
        }

        return ""
    }

    fun getAllItems(): List<String> {
        val clipboardItems = arrayListOf("")
        if (clipboardManager.hasPrimaryClip()) {
            val clipData = clipboardManager.primaryClip
            if (clipData != null) {
                for (i in 0 until clipData.itemCount) {
                    val item = clipData.getItemAt(i)
                    val itemText = item.text?.toString() ?: item.uri?.toString() ?: "Неизвестный тип данных"
                    clipboardItems.add(itemText)
                }
            }
        }

        return clipboardItems
    }

}


