package com.example.dependencyinjection.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.main.MainRepository
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
    var recyclerListLiveData: MutableLiveData<List<UserItem>> = MutableLiveData()


    //This function returns the recyclerListLiveData
    fun getRecyclerListObserver(): MutableLiveData<List<UserItem>> {
        return recyclerListLiveData
    }

    //This function is responsible of making Api call to our Api server in IO instead of main thread
    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
//                val retroInstance =
//                    RetroInstance.getRetroInstance().create(RetroService::class.java)
                val response = repository.getPosts()
                recyclerListLiveData.postValue(response)
            } catch (e: UnknownHostException) {
                e.printStackTrace()
            }
        }
    }


}

private fun <T> MutableLiveData<T>.postValue(response: Response<T>) {

}
