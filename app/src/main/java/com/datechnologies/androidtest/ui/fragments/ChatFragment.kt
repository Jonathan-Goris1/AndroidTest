package com.datechnologies.androidtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.datechnologies.androidtest.adapter.ChatAdapter
import com.datechnologies.androidtest.data.network.ChatApi
import com.datechnologies.androidtest.data.network.Wrapper
import com.datechnologies.androidtest.data.repository.ChatRepository
import com.datechnologies.androidtest.data.responses.Data
import com.datechnologies.androidtest.databinding.FragmentChatBinding
import com.datechnologies.androidtest.ui.fragments.base.BaseFragmentApi
import com.datechnologies.androidtest.ui.fragments.base.ChatViewModel
import com.datechnologies.androidtest.ui.visible


class ChatFragment : BaseFragmentApi<ChatViewModel, FragmentChatBinding, ChatRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chatProgressBar.visible(false)
        viewModel.getMessage()

        viewModel.message.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Wrapper.Success -> {
                    showChat(it.value.data)
                    binding.chatProgressBar.visible(false)
                }
                is Wrapper.Loading -> {
                    binding.chatProgressBar.visible(true)
                }
            }
        })
    }


    private fun showChat(chatData: List<Data>) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)

            adapter = ChatAdapter(chatData)
        }
    }

    override fun getViewModel() = ChatViewModel::class.java

    override fun getFragmentBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ) = FragmentChatBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): ChatRepository {
        val api = retrofitBuilder.buildApi(ChatApi::class.java)
        return ChatRepository(api)
    }


}