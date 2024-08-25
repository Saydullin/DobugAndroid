package com.saydullin.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.saydullin.data.server.service.PostService
import com.saydullin.domain.model.post.Post
import javax.inject.Inject

class PostsPagingSource @Inject constructor(
    private val postService: PostService
) : PagingSource<Int, Post>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        val pageNumber = params.key ?: 0
        val postsCall = postService.getAll()
        val postsResponse = postsCall.execute().body()
            ?: return LoadResult.Error(
                throwable = Exception("Post response is null")
            )

        val prevKey = if (pageNumber > 0) pageNumber - 1 else null

        val nextKey = if (postsResponse.data.items.isNotEmpty()) {
            pageNumber + 1
        } else {
            null
        }

        return LoadResult.Page(
            data = postsResponse.data.items,
            prevKey = prevKey,
            nextKey = nextKey
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?:
            state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

}