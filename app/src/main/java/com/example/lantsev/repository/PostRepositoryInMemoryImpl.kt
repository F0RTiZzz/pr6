package com.example.lantsev.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lantsev.dto.Post

class PostRepositoryInMemoryImpl : PostRepository{
    private var posts = listOf(
        Post(
            id = 2,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "18 сентября в 10:12",
            likedByMe = false,
            likes = 489,
            share = 23,
            shareByMe=false
        ),
        Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            likes = 999999,
            share = 999,
            shareByMe=false
        ),
    )
    private val data = MutableLiveData(posts)
    override fun getAll(): LiveData<List<Post>> = data
    override fun likeById(id: Int) {
        posts = posts.map {
            if(it.id!= id.toInt()) it else it.copy(likedByMe = !it.likedByMe)
        }
        posts.map{
            if(it.likedByMe && it.id == id.toInt()) it.likes++ else it
        }
        posts.map {
            if(!it.likedByMe && it.id == id.toInt()) it.likes-- else it
        }
        data.value = posts
    }
    override fun shareById(id: Int) {
        posts = posts.map {
            if(it.id!= id.toInt()) it else it.copy(shareByMe = !it.shareByMe)
        }
        posts.map {
            if (it.id != id.toInt()) it else it.share++
        }
        data.value = posts
    }
}


