import com.google.gson.annotations.SerializedName;

public enum Position {
    @SerializedName("Cleaner")
    CLEANER,
    @SerializedName("Driver")
    DRIVER,
    @SerializedName("Programmer")
    PROGRAMMER,
    @SerializedName("Tester")
    TESTER,
    @SerializedName("ProjectManager")
    PROJECT_MANAGER,
    @SerializedName("TeamLeader")
    TEAMLEADER,
    @SerializedName("SeniorManager")
    SENIOR_MANAGER
}
