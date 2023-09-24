package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androiddevs.mvvmnewsapp.Article

//dao = data access object
@Dao
interface ArticleDao {
    //onconflict strategy works in cases like when an article already exists while updating or uploading
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateInsertArticle(article: Article): Long

    //could not take this as suspend function as they are not compatible with LiveData
    //LiveData updates changes in all the listeners live ,
    // it is especially used in case of screen rotation as rotation does not rebuild the viewmodel this helps in updating the content of recyclerview in that case
    @Query("SELECT * FROM articles")
    fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}