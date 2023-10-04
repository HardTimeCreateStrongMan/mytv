package com.example.mytv.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytv.data.model.User
import com.example.mytv.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel {
    class LoginViewModel : ViewModel() {
        // A LiveData that holds the user object
        private val _user = MutableLiveData<User>()
        val user: LiveData<User>
            get() = _user

        // A LiveData that holds the login status
        private val _status = MutableLiveData<Status>()
        val status: LiveData<Status>
            get() = _status

        // An enum class that defines the possible login statuses
        enum class Status {
            LOADING, SUCCESS, FAILURE
        }

        // A function that authenticates a user with the web service using coroutines
        fun authenticate(user: User) {
            viewModelScope.launch { // Launch a coroutine in the view model scope
                _status.value = Status.LOADING // Set the status to loading
                val result = UserRepository.getInstance().authenticate(user) // Call the repository function
                if (result != null) { // Check if the result is not null
                    _user.value = result // Set the user value to the result
                    _status.value = Status.SUCCESS // Set the status to success
                } else {
                    _status.value = Status.FAILURE // Set the status to failure
                }
            }
        }
    }
}