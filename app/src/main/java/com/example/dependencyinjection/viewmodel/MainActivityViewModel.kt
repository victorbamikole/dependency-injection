package com.example.dependencyinjection.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.dependencyinjection.main.MainRepository
import com.example.dependencyinjection.model.User
import com.example.dependencyinjection.model.UserItem
import com.example.dependencyinjection.network.RetroInstance
import com.example.dependencyinjection.network.RetroService
import dagger.assisted.Assisted
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.UnknownHostException
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle, private val repository: MainRepository) : ViewModel() {

    // Holds the details of the pokemon retrieved from the API
    val _recyclerList: MutableLiveData<List<UserItem>> = MutableLiveData()
    val recyclerList: LiveData<List<UserItem>>
    get() = _recyclerList


    //This function returns the recyclerListLiveData
//    fun getRecyclerListObserver(): MutableLiveData<List<UserItem>> {
//        return _recyclerList
//    }

    //This function is responsible of making Api call to our Api server in IO instead of main thread
    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
//                val retroInstance =
//                    RetroInstance.getRetroInstance().create(RetroService::class.java)
                val response = repository.getPosts()
                _recyclerList.postValue(response)
            } catch (e: UnknownHostException) {
                e.printStackTrace()
            }
        }
    }


}

//private fun <T> MutableLiveData<T>.postValue(response: Response<T>) {
//
//}
