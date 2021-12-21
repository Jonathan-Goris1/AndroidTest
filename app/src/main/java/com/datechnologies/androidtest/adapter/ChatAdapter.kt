package com.datechnologies.androidtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.datechnologies.androidtest.data.responses.Data
import com.datechnologies.androidtest.databinding.ItemChatBinding
import com.squareup.picasso.Picasso

/**
 * A recycler view adapter used to display chat log messages in {@link ChatActivity}.

 */

class ChatAdapter(
        private var dataList: List<Data>
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    //==============================================================================================
    // Class Properties
    //==============================================================================================
//==============================================================================================
    // Constructor
    //==============================================================================================


    class ChatViewHolder(private val binding: ItemChatBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(get: Data) {
            binding.apply {
                nameTextView.text = get.name
                messageTextView.text = get.message
                Picasso.get()
                        .load(get.avatar_url)
                        .resize(100, 100)
                        .centerCrop()
                        .into(avatarImageView)
            }

        }

    }
    //==============================================================================================
    // RecyclerView.Adapter Methods
    //==============================================================================================


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
                ItemChatBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    //==============================================================================================
    // ChatViewHolder Class
    //==============================================================================================

    override fun getItemCount(): Int {
        return dataList.size
    }
}