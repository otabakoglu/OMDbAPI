package com.otabakoglu.omdbapi.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.otabakoglu.omdbapi.util.SingleLiveEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

const val FB_KEY_SPLASH_TEXT = "splash_text"

class SplashVM @Inject constructor() : ViewModel(){

    private val _splashText = MutableLiveData<String>()
    val splashText: LiveData<String>
            get() = _splashText

    private val _navigateMainFragment = SingleLiveEvent<Boolean>()
    val navigateMainFragment: SingleLiveEvent<Boolean>
        get() = _navigateMainFragment

    init {
        getSplashTextOnFirebase()
    }

    private fun getSplashTextOnFirebase(){

        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)

        _splashText.value = remoteConfig.getString(FB_KEY_SPLASH_TEXT)

        remoteConfig.fetch().addOnCompleteListener { task ->
            runBlocking {
                if(task.isSuccessful){
                    remoteConfig.activate()
                }
                delay(3000)
                _navigateMainFragment.call()
            }
        }



    }
}