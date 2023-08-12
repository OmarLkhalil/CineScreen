package com.mobilebreakero

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilebreakero.common.domain.usecase.VideosUseCase
import com.mobilebreakero.common.domain.util.DetailsState
import com.mobilebreakero.common.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor(private val getVideosUseCase: VideosUseCase) :
    ViewModel() {

    val _state = mutableStateOf(DetailsState())
    var videoKey = mutableStateOf(String())

    var videos: State<DetailsState> = _state

    fun fetchVideos(movieId: String) {
        try {
            getVideosUseCase(movieId).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = DetailsState(
                            video = result.data?.videos ?: emptyList()
                        )
                        if (result.data!!.videos.isNotEmpty()) {
                            videoKey.value = result.data!!.videos[0].key.toString()
                        } else {
                            Log.e("VideosViewModel", "fetchVideoDetails: Video list is empty")
                        }
                    }

                    is Resource.Error -> {
                        _state.value = DetailsState(
                            error = result.message ?: "An unexpected error happened"
                        )
                    }

                    else -> {
                        _state.value = DetailsState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        } catch (e: Exception) {
            _state.value = DetailsState(
                error = e.message ?: "An unexpected error occurred"
            )
        }
    }
}