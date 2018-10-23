package csw.java.other;

public class AppVersion {

  private String appId;
  private String platform;
  private String appVersion;

  public AppVersion(String appId, String platform, String appVersion) {
    super();
    this.appId = appId;
    this.platform = platform;
    this.appVersion = appVersion;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public String getAppVersion() {
    return appVersion;
  }

  public void setAppVersion(String appVersion) {
    this.appVersion = appVersion;
  }
}