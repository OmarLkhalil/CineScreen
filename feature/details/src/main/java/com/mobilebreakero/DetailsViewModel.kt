package com.mobilebreakero

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobilebreakero.common.domain.usecase.VideosUseCase
import com.mobilebreakero.common.domain.util.DetailsState
import com.mobilebreakero.common.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getVideosUseCase: VideosUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(DetailsState())
    private val _videoKey = MutableStateFlow<String?>(null)
    val videoKey: StateFlow<String?> = _videoKey
    private val movieId = "569094"



    fun fetchVideoDetails() {

        try {
            getVideosUseCase(movieId).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = DetailsState(
                            video = result.data!!.videos
                        )
                        if (result.data!!.videos.isNotEmpty()) {
                            Log.e("DetailsViewModel", "fetchVideoDetails: $videoKey")
                        } else {
                            Log.e("DetailsViewModel", "fetchVideoDetails: Video list is empty")
                        }
                    }

                    is Resource.Error -> {
                        _state.value = DetailsState(
                            error = result.message ?: "An unexpected error happened"
                        )
                    }

                    else -> {}
                }
            }.launchIn(viewModelScope)
        } catch (e: Exception) {
            _state.value = DetailsState(
                error = e.message ?: "An unexpected error occurred"
            )
        }
    }
}