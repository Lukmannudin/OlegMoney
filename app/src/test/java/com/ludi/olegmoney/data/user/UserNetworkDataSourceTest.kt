package com.ludi.olegmoney.data.user

import com.ludi.olegmoney.BaseTest
import com.ludi.olegmoney.MainDispatcherRule
import com.ludi.olegmoney.data.api.ApiHelper
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
class UserNetworkDataSourceTest : BaseTest() {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiHelper: ApiHelper

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