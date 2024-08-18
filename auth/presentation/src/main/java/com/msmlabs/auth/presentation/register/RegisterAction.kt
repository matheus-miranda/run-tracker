package com.msmlabs.auth.presentation.register

/**
 * Actions are passed on from the UI to the Model
 */
sealed interface RegisterAction {
    data object OnTogglePasswordVisibilityClick : RegisterAction
    data object OnLoginClick : RegisterAction
    data object OnRegisterClick : RegisterAction
}
