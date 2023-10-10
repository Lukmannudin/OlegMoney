package com.ludi.olegmoney

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import com.ludi.olegmoney.ui.onboarding.OnboardingActivity
import com.ludi.olegmoney.util.TestTag
import com.ludi.olegmoney.util.withRole
import org.junit.Rule
import org.junit.Test

class SignUpTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<OnboardingActivity>()

    @Test
    fun signUpTest() {
        composeTestRule.onRoot().printToLog("TAG")
        val time = System.currentTimeMillis()

        val name = "test $time"
        val email = "test$time@gmail.com"
        val password = "1234567890"

        with(composeTestRule) {
            onNodeWithText("Sign Up").performClick()
            onNodeWithText("Name").performTextInput(name)
            onNodeWithText("Email").performTextInput(email)
            onNodeWithText("Password").performTextInput(password)
            onNode(hasTestTag(TestTag.CHECKBOX)).performClick()
            onNode(withRole(Role.Button).and(hasText("Sign Up"))).performClick()
        }

    }

}