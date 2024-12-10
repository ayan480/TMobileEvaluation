package com.syncoders.tmobileevaluation.ui.screens.travel.view;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007\u001a:\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001a.\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0007\u001a\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0007\u001a\b\u0010\u0016\u001a\u00020\u0001H\u0007\u001a6\u0010\u0017\u001a\u00020\u00012\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u00a8\u0006\u001d"}, d2 = {"AddressTextField", "", "label", "", "value", "onValueChange", "Lkotlin/Function1;", "placeholder", "DatePickerDialog", "dateFormatter", "Ljava/text/SimpleDateFormat;", "currentDate", "Ljava/util/Calendar;", "onDateSelected", "onDismissRequest", "Lkotlin/Function0;", "DateTextField", "PreviewDateTextField", "SearchScreen", "parentNavController", "Landroidx/navigation/NavHostController;", "dashboardNavController", "SearchScreenPreview", "TravelModeSelector", "options", "", "Lkotlin/Pair;", "Landroidx/compose/ui/graphics/painter/Painter;", "onSelectionChanged", "app_debug"})
public final class SearchScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void SearchScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController parentNavController, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController dashboardNavController) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable
    public static final void SearchScreenPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TravelModeSelector(@org.jetbrains.annotations.NotNull
    java.util.List<? extends kotlin.Pair<java.lang.String, ? extends androidx.compose.ui.graphics.painter.Painter>> options, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSelectionChanged) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void AddressTextField(@org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange, @org.jetbrains.annotations.NotNull
    java.lang.String placeholder) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DateTextField(@org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange, @org.jetbrains.annotations.NotNull
    java.lang.String placeholder) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DatePickerDialog(@org.jetbrains.annotations.NotNull
    java.text.SimpleDateFormat dateFormatter, @org.jetbrains.annotations.NotNull
    java.util.Calendar currentDate, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDateSelected, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissRequest) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable
    public static final void PreviewDateTextField() {
    }
}