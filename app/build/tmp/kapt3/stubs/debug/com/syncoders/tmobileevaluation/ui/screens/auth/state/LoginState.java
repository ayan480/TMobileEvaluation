package com.syncoders.tmobileevaluation.ui.screens.auth.state;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState;", "", "()V", "Error", "InitialState", "Loading", "NavigatingToDashboard", "NavigatingToLogin", "NavigatingToRegister", "Success", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$Error;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$InitialState;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$Loading;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$NavigatingToDashboard;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$NavigatingToLogin;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$NavigatingToRegister;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$Success;", "app_debug"})
public abstract class LoginState {
    
    private LoginState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$Error;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Error extends com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String message = null;
        
        public Error(@org.jetbrains.annotations.NotNull
        java.lang.String message) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState.Error copy(@org.jetbrains.annotations.NotNull
        java.lang.String message) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$InitialState;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState;", "()V", "app_debug"})
    public static final class InitialState extends com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState {
        @org.jetbrains.annotations.NotNull
        public static final com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState.InitialState INSTANCE = null;
        
        private InitialState() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$Loading;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState;", "()V", "app_debug"})
    public static final class Loading extends com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState {
        @org.jetbrains.annotations.NotNull
        public static final com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState.Loading INSTANCE = null;
        
        private Loading() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$NavigatingToDashboard;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState;", "()V", "app_debug"})
    public static final class NavigatingToDashboard extends com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState {
        @org.jetbrains.annotations.NotNull
        public static final com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState.NavigatingToDashboard INSTANCE = null;
        
        private NavigatingToDashboard() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$NavigatingToLogin;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState;", "()V", "app_debug"})
    public static final class NavigatingToLogin extends com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState {
        @org.jetbrains.annotations.NotNull
        public static final com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState.NavigatingToLogin INSTANCE = null;
        
        private NavigatingToLogin() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$NavigatingToRegister;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState;", "()V", "app_debug"})
    public static final class NavigatingToRegister extends com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState {
        @org.jetbrains.annotations.NotNull
        public static final com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState.NavigatingToRegister INSTANCE = null;
        
        private NavigatingToRegister() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState$Success;", "Lcom/syncoders/tmobileevaluation/ui/screens/auth/state/LoginState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Success extends com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String message = null;
        
        public Success(@org.jetbrains.annotations.NotNull
        java.lang.String message) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState.Success copy(@org.jetbrains.annotations.NotNull
        java.lang.String message) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}