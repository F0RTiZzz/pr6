package com.example.lantsev.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lantsev.repository.PostRepository
import com.example.lantsev.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.getAll()
    fun likeById(id: Int)=repository.likeById(id)
    fun shareById(id: Int)=repository.shareById(id)
}