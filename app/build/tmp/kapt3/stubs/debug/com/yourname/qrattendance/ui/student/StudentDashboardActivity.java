package com.yourname.qrattendance.ui.student;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/yourname/qrattendance/ui/student/StudentDashboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "scanLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/journeyapps/barcodescanner/ScanOptions;", "kotlin.jvm.PlatformType", "sharedPreferences", "Landroid/content/SharedPreferences;", "studentId", "", "studentViewModel", "Lcom/yourname/qrattendance/viewmodel/StudentViewModel;", "tvScanResult", "Landroid/widget/TextView;", "launchQRScanner", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showEnrollDialog", "app_debug"})
public final class StudentDashboardActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.yourname.qrattendance.viewmodel.StudentViewModel studentViewModel;
    private android.content.SharedPreferences sharedPreferences;
    private android.widget.TextView tvScanResult;
    private int studentId = -1;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<com.journeyapps.barcodescanner.ScanOptions> scanLauncher = null;
    
    public StudentDashboardActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void launchQRScanner() {
    }
    
    private final void showEnrollDialog() {
    }
}