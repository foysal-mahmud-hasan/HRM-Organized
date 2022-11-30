package com.foysal.practice.hrm.ViewModel

import androidx.lifecycle.*
import com.foysal.practice.hrm.Model.Exceptions
import com.foysal.practice.hrm.Repository.ExceptionRepository
import com.foysal.practice.hrm.Repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExceptionViewModel (private val repository: ExceptionRepository) : ViewModel() {

    val allExceptions : LiveData<List<Exceptions>> = repository.exceptionList.asLiveData()

    fun insert(exceptions: Exceptions) = viewModelScope.launch (Dispatchers.IO){

        repository.insert(exceptions)

    }
    fun update(exceptions: Exceptions) = viewModelScope.launch(Dispatchers.IO){

        repository.update(exceptions)

    }
    fun delete(exceptions: Exceptions) = viewModelScope.launch(Dispatchers.IO){

        repository.delete(exceptions)

    }

}
class ExceptionViewModelFactory(private var repository: ExceptionRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExceptionViewModel::class.java)){
            return ExceptionViewModel(repository) as T
        }else{
            throw java.lang.IllegalArgumentException("Unknown View Model")
        }
    }

}