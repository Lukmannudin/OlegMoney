package com.ludi.olegmoney.data.user

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ludi.olegmoney.BaseTest
import com.ludi.olegmoney.MainDispatcherRule
import com.ludi.olegmoney.data.api.ApiHelper
import com.ludi.olegmoney.data.user.request.SignUpRequest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class UserNetworkDataSourceTest : BaseTest() {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiHelper: ApiHelper

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun signUp() = runTest {
        val time = System.currentTimeMillis()
        val request = SignUpRequest(
            "test $time",
            "test$time@gmail.com",
            "1234567890"
        )
        val response = apiHelper.signUp(request)
        response
    }
}