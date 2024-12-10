package com.syncoders.tmobileevaluation.ui.screens.auth.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0010J\u000e\u0010-\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0010J\u000e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u0010J\u000e\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0010J\u0006\u00102\u001a\u00020)J\u0006\u00103\u001a\u00020)J\u0006\u00104\u001a\u00020\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000eR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000eR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000eR\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000eR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0%\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/viewmodel/RegistrationViewModel;", "Landroidx/lifecycle/ViewModel;", "authUseCase", "Lcom/syncoders/domain/usecase/auth/AuthUseCase;", "sharedPreferencesHelper", "Lcom/syncoders/data/dataSource/sharedPreferences/SharedPreferencesHelper;", "(Lcom/syncoders/domain/usecase/auth/AuthUseCase;Lcom/syncoders/data/dataSource/sharedPreferences/SharedPreferencesHelper;)V", "_registrationViewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/RegistrationState;", "agreeTNC", "Landroidx/compose/runtime/MutableState;", "", "getAgreeTNC", "()Landroidx/compose/runtime/MutableState;", "confirmPassword", "", "getConfirmPassword", "confirmPasswordError", "getConfirmPasswordError", "email", "getEmail", "emailError", "getEmailError", "mobileNo", "getMobileNo", "mobileNoError", "getMobileNoError", "name", "getName", "nameError", "getNameError", "password", "getPassword", "passwordError", "getPasswordError", "registrationViewState", "Lkotlinx/coroutines/flow/StateFlow;", "getRegistrationViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "onConfirmPasswordChange", "", "confPassword", "onEmailChange", "newEmail", "onNameChange", "onPasswordChange", "newPassword", "onPhoneNoChange", "newPhone", "onSignupClick", "resetViewState", "validateForm", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class RegistrationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.syncoders.domain.usecase.auth.AuthUseCase authUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper sharedPreferencesHelper = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.syncoders.tmobileevaluation.ui.screens.auth.state.RegistrationState> _registrationViewState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.syncoders.tmobileevaluation.ui.screens.auth.state.RegistrationState> registrationViewState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> name = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> mobileNo = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> email = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> password = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> confirmPassword = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> emailError = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> passwordError = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> confirmPasswordError = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> nameError = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> mobileNoError = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> agreeTNC = null;
    
    @javax.inject.Inject
    public RegistrationViewModel(@org.jetbrains.annotations.NotNull
    com.syncoders.domain.usecase.auth.AuthUseCase authUseCase, @org.jetbrains.annotations.NotNull
    com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper sharedPreferencesHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.syncoders.tmobileevaluation.ui.screens.auth.state.RegistrationState> getRegistrationViewState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getMobileNo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getConfirmPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getEmailError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getPasswordError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getConfirmPasswordError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getNameError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getMobileNoError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getAgreeTNC() {
        return null;
    }
    
    public final void onNameChange(@org.jetbrains.annotations.NotNull
    java.lang.String newEmail) {
    }
    
    public final void onEmailChange(@org.jetbrains.annotations.NotNull
    java.lang.String newEmail) {
    }
    
    public final void onPhoneNoChange(@org.jetbrains.annotations.NotNull
    java.lang.String newPhone) {
    }
    
    public final void onPasswordChange(@org.jetbrains.annotations.NotNull
    java.lang.String newPassword) {
    }
    
    public final void onConfirmPasswordChange(@org.jetbrains.annotations.NotNull
    java.lang.String confPassword) {
    }
    
    public final boolean validateForm() {
        return false;
    }
    
    public final void onSignupClick() {
    }
    
    public final void resetViewState() {
    }
}