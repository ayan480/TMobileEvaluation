package com.syncoders.tmobileevaluation.ui.screens.auth.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\rJ\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010\'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010\'\u001a\u00020(J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0011J\u0006\u0010,\u001a\u00020\u001fJ\u0006\u0010-\u001a\u00020\u001fJ\b\u0010.\u001a\u00020\u0011H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "authUseCase", "Lcom/syncoders/domain/usecase/auth/AuthUseCase;", "sharedPreferencesHelper", "Lcom/syncoders/data/dataSource/sharedPreferences/SharedPreferencesHelper;", "(Lcom/syncoders/domain/usecase/auth/AuthUseCase;Lcom/syncoders/data/dataSource/sharedPreferences/SharedPreferencesHelper;)V", "_landingViewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState;", "_loginUiState", "emailError", "Landroidx/compose/runtime/MutableState;", "", "getEmailError", "()Landroidx/compose/runtime/MutableState;", "isRememberMe", "", "landingViewState", "Lkotlinx/coroutines/flow/StateFlow;", "getLandingViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "loginEmail", "getLoginEmail", "loginPassword", "getLoginPassword", "loginUiState", "getLoginUiState", "passwordError", "getPasswordError", "checkLogin", "", "getSavedCredential", "onEmailChange", "newEmail", "onLoginClick", "onPasswordChange", "newPassword", "processLandingIntent", "intent", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/intent/AuthIntent;", "processLoginIntent", "rememberMeCheckChange", "isCheck", "resetLandingState", "resetLoginState", "validateForm", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.syncoders.domain.usecase.auth.AuthUseCase authUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper sharedPreferencesHelper = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState> _landingViewState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState> landingViewState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState> _loginUiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState> loginUiState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> loginEmail = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> loginPassword = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> emailError = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> passwordError = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> isRememberMe = null;
    
    @javax.inject.Inject
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.syncoders.domain.usecase.auth.AuthUseCase authUseCase, @org.jetbrains.annotations.NotNull
    com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper sharedPreferencesHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState> getLandingViewState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState> getLoginUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getLoginEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getLoginPassword() {
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
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isRememberMe() {
        return null;
    }
    
    private final void checkLogin() {
    }
    
    private final void getSavedCredential() {
    }
    
    public final void onEmailChange(@org.jetbrains.annotations.NotNull
    java.lang.String newEmail) {
    }
    
    public final void onPasswordChange(@org.jetbrains.annotations.NotNull
    java.lang.String newPassword) {
    }
    
    private final boolean validateForm() {
        return false;
    }
    
    public final void onLoginClick() {
    }
    
    public final void processLandingIntent(@org.jetbrains.annotations.NotNull
    com.syncoders.tmobileevaluation.ui.screens.auth.intent.AuthIntent intent) {
    }
    
    public final void processLoginIntent(@org.jetbrains.annotations.NotNull
    com.syncoders.tmobileevaluation.ui.screens.auth.intent.AuthIntent intent) {
    }
    
    public final void rememberMeCheckChange(boolean isCheck) {
    }
    
    public final void resetLandingState() {
    }
    
    public final void resetLoginState() {
    }
}