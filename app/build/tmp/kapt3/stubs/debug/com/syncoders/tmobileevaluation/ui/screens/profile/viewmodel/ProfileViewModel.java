package com.syncoders.tmobileevaluation.ui.screens.profile.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/profile/viewmodel/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "profileUseCase", "Lcom/syncoders/domain/usecase/profile/ProfileUseCase;", "sharedPreferencesHelper", "Lcom/syncoders/data/dataSource/sharedPreferences/SharedPreferencesHelper;", "(Lcom/syncoders/domain/usecase/profile/ProfileUseCase;Lcom/syncoders/data/dataSource/sharedPreferences/SharedPreferencesHelper;)V", "_profileUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/syncoders/tmobileevaluation/ui/screens/profile/state/ProfileState;", "profileUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getProfileUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "userName", "Landroidx/compose/runtime/MutableState;", "", "getUserName", "()Landroidx/compose/runtime/MutableState;", "getProfile", "", "logOut", "onIntent", "intent", "Lcom/syncoders/tmobileevaluation/ui/screens/profile/intent/ProfileIntent;", "resetState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.syncoders.domain.usecase.profile.ProfileUseCase profileUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper sharedPreferencesHelper = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.syncoders.tmobileevaluation.ui.screens.profile.state.ProfileState> _profileUiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.syncoders.tmobileevaluation.ui.screens.profile.state.ProfileState> profileUiState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> userName = null;
    
    @javax.inject.Inject
    public ProfileViewModel(@org.jetbrains.annotations.NotNull
    com.syncoders.domain.usecase.profile.ProfileUseCase profileUseCase, @org.jetbrains.annotations.NotNull
    com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper sharedPreferencesHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.syncoders.tmobileevaluation.ui.screens.profile.state.ProfileState> getProfileUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.String> getUserName() {
        return null;
    }
    
    private final void getProfile() {
    }
    
    public final void logOut() {
    }
    
    public final void onIntent(@org.jetbrains.annotations.NotNull
    com.syncoders.tmobileevaluation.ui.screens.profile.intent.ProfileIntent intent) {
    }
    
    public final void resetState() {
    }
}