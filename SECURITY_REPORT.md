# WILLMA APK Security Analysis Report

**Application:** WILLMA (com.willma.client) v1.10.1  
**Platform:** Android (React Native / Expo)  
**Analysis Date:** June 1, 2026  
**Classifier:** Z.ai Security Analysis  

---

## Table of Contents

- [Executive Summary](#executive-summary)
- [Application Overview](#1-application-overview)
- [CRITICAL: Hardcoded LLM API Keys](#2-critical-hardcoded-llm-api-keys)
- [CRITICAL: SSL Hostname Verification Bypass](#3-critical-ssl-hostname-verification-bypass)
- [CRITICAL: Facebook Client Token Exposed](#4-critical-facebook-client-token-exposed)
- [HIGH: Missing Network Security Configuration](#5-high-missing-network-security-configuration)
- [HIGH: Exported CropImageActivity Without Protection](#6-high-exported-cropimageactivity-without-protection)
- [HIGH: Android AllowBackup Enabled](#7-high-android-allowbackup-enabled)
- [HIGH: Apple Sign-In WebView JavaScript Interface](#8-high-apple-sign-in-webview-javascript-interface)
- [HIGH: Other Hardcoded Credentials](#9-high-other-hardcoded-credentials)
- [MEDIUM: No Certificate Pinning](#10-medium-no-certificate-pinning)
- [MEDIUM: Overly Broad FileProvider Paths](#11-medium-overly-broad-fileprovider-paths)
- [MEDIUM: Development Code in Release Build](#12-medium-development-code-in-release-build)
- [MEDIUM: Excessive and Dangerous Permissions](#13-medium-excessive-and-dangerous-permissions)
- [MEDIUM: Expo OTA Update Security](#14-medium-expo-ota-update-security)
- [MEDIUM: Other Medium Findings](#15-medium-other-medium-findings)
- [LOW and INFO Findings](#16-low-and-info-findings)
- [Complete Findings Summary Table](#17-complete-findings-summary-table)
- [Priority Remediation Plan](#18-priority-remediation-plan)
- [Vulnerable Files Index](#19-vulnerable-files-index)

---

## Executive Summary

A comprehensive security analysis of the WILLMA Android application (v1.10.1) has revealed **37 security findings** across multiple categories:

| Severity | Count | Action Required |
|----------|-------|-----------------|
| **CRITICAL** | 6 | **MUST FIX BEFORE LAUNCH** |
| **HIGH** | 8 | **SHOULD FIX BEFORE LAUNCH** |
| **MEDIUM** | 12 | RECOMMENDED TO FIX |
| **LOW** | 7 | LOW PRIORITY |
| **INFO** | 4 | INFORMATIONAL |

The most severe vulnerabilities involve **hardcoded LLM API keys** (OpenAI, Anthropic, DeepSeek, Gemini) embedded in plaintext within the app configuration, an **SSL hostname verification bypass** that accepts all certificates, and the **Facebook client token** exposed in resource files. These vulnerabilities could allow attackers to:

- Consume API credits at the app owner's expense (potentially thousands of dollars)
- Intercept encrypted communications via man-in-the-middle attacks
- Impersonate the application on social platforms
- Extract all app data including authentication tokens via ADB backup

**Immediate remediation is strongly recommended before publishing to Google Play Store.**

---

## 1. Application Overview

| Property | Value |
|----------|-------|
| Package Name | `com.willma.client` |
| Application Name | WILLMA |
| Version | 1.10.1 (versionCode: 21) |
| Min SDK | 23 (Android 6.0 Marshmallow) |
| Target SDK | 35 (Android 15) |
| Framework | React Native / Expo |
| Base APK Size | 82 MB (Total XAPK: 119 MB) |
| Native Libraries | armeabi_v7a |
| Expo Project ID | `0c01da2c-5409-459b-a106-98322e3d7076` |
| Firebase Project | `willma-prod` |
| GraphQL API | `https://app.willma.life/api/graphql` |

The WILLMA application is a React Native-based Android app built with the Expo framework. It integrates multiple AI provider APIs (OpenAI, Anthropic, DeepSeek, and Google Gemini) to provide conversational AI capabilities. The app also incorporates Facebook SDK for authentication, Firebase for messaging and analytics, Microsoft Clarity for session tracking, and Google ML Kit for barcode scanning.

---

## 2. CRITICAL: Hardcoded LLM API Keys

### Severity: CRITICAL 🔴
### Files: [`vulnerable-files/app.config`](vulnerable-files/app.config)

### The Problem

The file `resources/assets/app.config` contains a JSON configuration block that embeds **four live LLM API keys** in plaintext. Anyone who extracts the APK (trivially done using publicly available tools like apktool or jadx) can retrieve these keys and use them to make API calls at the application owner's expense.

### Exposed Keys

| Provider | Key Variable | Key (Truncated) | Impact |
|----------|-------------|------------------|--------|
| OpenAI | `OPENAI_API_KEY` | `sk-proj-OsMIWUQ...G3EA` | Full API access — text, images, massive cost risk |
| Anthropic | `ANTHROPIC_API_KEY` | `sk-ant-api03-Ceoak...WwAA` | Full Claude API access — **active provider** |
| DeepSeek | `DEEPSEEK_API_KEY` | `sk-f4e060a5b624...2ff5` | Full DeepSeek API access |
| Gemini | `GEMINI_API_KEY` | `AIzaSyDaQPVTbMztW...lTE` | Full Google Gemini API access |

The app configuration indicates `AI_PROVIDER=anthropic`, meaning the Anthropic key is the primary active provider and the most heavily used — and therefore the most valuable to an attacker.

### Impact

- **Financial risk:** An attacker could automate API calls to any of these services, potentially incurring thousands of dollars in costs within hours.
- **Data risk:** Keys could be used to access any functionality available through the respective APIs, including generating content, accessing model fine-tuning endpoints, or extracting training data.
- **Abuse risk:** Compromised keys could be used for malicious purposes (spam, deepfakes, etc.) that would be attributed to your account.

### How to Fix

1. **IMMEDIATELY rotate all 4 API keys** on their respective provider consoles:
   - OpenAI: https://platform.openai.com/api-keys
   - Anthropic: https://console.anthropic.com/
   - DeepSeek: https://platform.deepseek.com/
   - Google Gemini: https://aistudio.google.com/apikey

2. **Move all AI API calls to your backend server.** The client app should NEVER communicate directly with LLM providers. Instead:
   - Route all AI requests through your GraphQL API at `app.willma.life`
   - Store API keys as environment variables on your server (e.g., using `.env` files, AWS Secrets Manager, or similar)
   - Your backend proxies the request to the LLM provider and returns the response

3. **Remove API keys from `app.config`** entirely. Replace them with empty strings or remove the fields:
   ```json
   // BEFORE (VULNERABLE):
   "OPENAI_API_KEY": "sk-proj-OsMIWUQkasTVhmLomlLI...",
   
   // AFTER (FIXED):
   "OPENAI_API_KEY": "",  // Handled by backend proxy
   ```

4. **Set up API key restrictions** on each provider console:
   - Add IP address allowlisting to only allow requests from your backend server
   - Set usage quotas and billing alerts
   - Enable rate limiting per key

---

## 3. CRITICAL: SSL Hostname Verification Bypass

### Severity: CRITICAL 🔴
### File: [`vulnerable-files/ReactNativeBlobUtilUtils.java`](vulnerable-files/ReactNativeBlobUtilUtils.java)

### The Problem

The method `getUnsafeOkHttpClient()` at **line 54** creates an OkHttpClient that **accepts ALL SSL hostnames** by returning `true` from the `HostnameVerifier.verify()` callback at **line 68**:

```java
// Line 54-69 in ReactNativeBlobUtilUtils.java
public static OkHttpClient.Builder getUnsafeOkHttpClient(OkHttpClient okHttpClient) {
    // ... trust manager setup ...
    newBuilder.hostnameVerifier(new HostnameVerifier() {
        @Override
        public boolean verify(String str, SSLSession sSLSession) {
            return true;  // ⚠️ ACCEPTS ALL HOSTNAMES — COMPLETE SSL BYPASS
        }
    });
    return newBuilder;
}
```

### Impact

When this method is called, **all SSL hostname checking is disabled**. An attacker on the same network (e.g., public Wi-Fi) with a valid but mis-issued certificate could intercept all traffic between the app and its backend servers, including:
- Authentication tokens
- User data and conversation history
- API requests and responses
- Payment information

### How to Fix

1. **Remove the `getUnsafeOkHttpClient()` method entirely** from the production build, or gate it strictly behind a debug-only flag:

   ```java
   // FIXED: Only allow in debug builds
   public static OkHttpClient.Builder getUnsafeOkHttpClient(OkHttpClient okHttpClient) {
       if (BuildConfig.DEBUG) {
           // ... unsafe config for development only ...
       } else {
           return okHttpClient.newBuilder(); // Safe default in production
       }
   }
   ```

2. **Better yet, remove it entirely** and use proper SSL configuration:
   ```java
   // FIXED: Use the default safe client
   public static OkHttpClient.Builder getSafeOkHttpClient(OkHttpClient okHttpClient) {
       return okHttpClient.newBuilder();
       // Default hostname verification is already secure
   }
   ```

3. **Implement certificate pinning** (see Section 10 below for details).

---

## 4. CRITICAL: Facebook Client Token Exposed

### Severity: CRITICAL 🔴
### File: [`vulnerable-files/strings.xml`](vulnerable-files/strings.xml) (lines 200-201)

### The Problem

The Facebook Client Token is hardcoded in `strings.xml` at **line 201**:

```xml
<!-- Line 200-201 in strings.xml -->
<string name="facebook_app_id">1241712067901568</string>
<string name="facebook_client_token">4b0f881668cbab35f07d4a6ed6ba00cb</string>
```

This token is referenced in the AndroidManifest.xml as meta-data and is trivially extractable from the APK.

### Impact

- An attacker can use this token to make API calls on behalf of the WILLMA Facebook app integration
- Combined with the App ID, an attacker could impersonate the app in Facebook API interactions
- The Facebook SDK Auto-Init and Auto-Log App Events are both enabled (`true` in manifest), meaning the SDK initializes and begins tracking as soon as the app starts, using this exposed token

### How to Fix

1. **Rotate the Facebook Client Token** immediately at https://developers.facebook.com/
2. **Remove the hardcoded token from strings.xml.** Use Facebook SDK's built-in token handling:
   ```xml
   <!-- REMOVED: Do not hardcode client tokens -->
   <!-- <string name="facebook_client_token">4b0f881668cbab35f07d4a6ed6ba00cb</string> -->
   ```
3. **Use Facebook SDK's secure token provisioning** instead of embedding it in the APK.
4. **Consider whether Facebook Auto-Init and Auto-Log should be disabled** until explicit user consent is obtained:
   ```xml
   <meta-data android:name="com.facebook.sdk.AutoInitEnabled" android:value="false"/>
   <meta-data android:name="com.facebook.sdk.AutoLogAppEventsEnabled" android:value="false"/>
   ```

---

## 5. HIGH: Missing Network Security Configuration

### Severity: HIGH 🟠
### File: [`vulnerable-files/AndroidManifest.xml`](vulnerable-files/AndroidManifest.xml)

### The Problem

The application does not define a `network_security_config.xml` file, and the AndroidManifest.xml does not reference the `android:networkSecurityConfig` attribute. This means the app relies entirely on the platform's default security policy.

### Impact

- No explicit enforcement of cleartext traffic blocking
- No certificate pinning definitions at the platform level
- No custom trust anchors configured
- No defense-in-depth for TLS configuration
- Any future misconfiguration could allow cleartext traffic

### How to Fix

1. **Create `res/xml/network_security_config.xml`:**

   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <network-security-config>
       <!-- Block all cleartext traffic by default -->
       <base-config cleartextTrafficPermitted="false">
           <trust-anchors>
               <certificates src="system" />
           </trust-anchors>
       </base-config>
       
       <!-- Pin certificates for your API -->
       <domain-config>
           <domain includeSubdomains="true">app.willma.life</domain>
           <pin-set>
               <pin digest="SHA-256">YOUR_CERTIFICATE_HASH_HERE</pin>
               <pin digest="SHA-256">YOUR_BACKUP_CERTIFICATE_HASH_HERE</pin>
           </pin-set>
           <trust-anchors>
               <certificates src="system" />
           </trust-anchors>
       </domain-config>
   </network-security-config>
   ```

2. **Reference it in AndroidManifest.xml:**
   ```xml
   <application
       ...
       android:networkSecurityConfig="@xml/network_security_config">
   ```

---

## 6. HIGH: Exported CropImageActivity Without Protection

### Severity: HIGH 🟠
### File: [`vulnerable-files/AndroidManifest.xml`](vulnerable-files/AndroidManifest.xml)

### The Problem

At the CropImageActivity declaration, the activity is exported without any protection:

```xml
<activity
    android:theme="@style/Base.Theme.AppCompat"
    android:name="com.canhub.cropper.CropImageActivity"
    android:exported="true"/>
```

### Impact

Any application on the device can launch this activity with crafted intents, potentially:
- Causing unexpected behavior
- Accessing image data being cropped
- Crashing the app through malformed input

### How to Fix

Set `android:exported="false"`:

```xml
<activity
    android:theme="@style/Base.Theme.AppCompat"
    android:name="com.canhub.cropper.CropImageActivity"
    android:exported="false"/>
```

---

## 7. HIGH: Android AllowBackup Enabled

### Severity: HIGH 🟠
### File: [`vulnerable-files/AndroidManifest.xml`](vulnerable-files/AndroidManifest.xml)

### The Problem

The application has `android:allowBackup="true"` set in the manifest:

```xml
<application
    ...
    android:allowBackup="true"
    ...>
```

### Impact

Anyone with physical access to the device (or via ADB over USB debugging) can extract the app's complete data directory using `adb backup com.willma.client`. This backup includes:
- SharedPreferences (may contain auth tokens)
- SQLite databases (may contain user data)
- Internal files (may contain cached credentials)

### How to Fix

Set `android:allowBackup="false"` and optionally specify `android:fullBackupContent`:

```xml
<application
    ...
    android:allowBackup="false"
    android:fullBackupContent="@xml/backup_rules"
    ...>
```

If some data must be backed up, create `res/xml/backup_rules.xml` to explicitly whitelist only non-sensitive data:

```xml
<?xml version="1.0" encoding="utf-8"?>
<full-backup-content>
    <include domain="sharedpref" path="."/>
    <exclude domain="sharedpref" path="auth_tokens.xml"/>
    <exclude domain="database" path="."/>
    <exclude domain="file" path="cache/"/>
</full-backup-content>
```

---

## 8. HIGH: Apple Sign-In WebView JavaScript Interface

### Severity: HIGH 🟠
### File: [`vulnerable-files/SignInWebViewDialogFragment.java`](vulnerable-files/SignInWebViewDialogFragment.java)

### The Problem

The Apple Sign-In WebView enables JavaScript and uses `addJavascriptInterface` to expose a `FormInterceptorInterface` to the WebView:

```java
settings.setJavaScriptEnabled(true);
settings.setJavaScriptCanOpenWindowsAutomatically(true);
webView.addJavascriptInterface(new FormInterceptorInterface(...), FormInterceptorInterface.NAME);
```

### Impact

- A compromised or redirected Apple auth page could invoke the JavaScript interface methods
- Could leak authentication state data
- The `setJavaScriptCanOpenWindowsAutomatically` setting allows popup-based attacks

### How to Fix

1. **Restrict the JavaScript interface** to only expose minimal methods
2. **Validate the URL** before loading it in the WebView:
   ```java
   private static final String ALLOWED_DOMAIN = "appleid.apple.com";
   
   private boolean isUrlAllowed(String url) {
       try {
           String host = new URL(url).getHost();
           return host != null && host.endsWith(ALLOWED_DOMAIN);
       } catch (MalformedURLException e) {
           return false;
       }
   }
   ```
3. **Disable `setJavaScriptCanOpenWindowsAutomatically`** unless specifically needed:
   ```java
   settings.setJavaScriptCanOpenWindowsAutomatically(false);
   ```

---

## 9. HIGH: Other Hardcoded Credentials

### Severity: HIGH 🟠
### Files: [`vulnerable-files/strings.xml`](vulnerable-files/strings.xml), [`vulnerable-files/app.config`](vulnerable-files/app.config), [`vulnerable-files/LicenseClient.java`](vulnerable-files/LicenseClient.java), [`vulnerable-files/verification.properties`](vulnerable-files/verification.properties)

### Google/Firebase API Key

**File:** `strings.xml` (line 208)
```xml
<string name="google_api_key">AIzaSyBfe2EJht-OaFnbfSNzXzCL96yMG3AXa7c</string>
```

**How to Fix:** In Google Cloud Console, restrict this API key to only the app's package name (`com.willma.client`) and SHA-1 fingerprint. Navigate to: Google Cloud Console → APIs & Services → Credentials → Select the key → Application restrictions → Android apps → Add your package name and SHA-1.

### Firebase Configuration

**File:** `strings.xml` (lines 209-211, 321)
```xml
<string name="google_app_id">1:603698132274:android:993cced615eec496cd532b</string>
<string name="google_storage_bucket">willma-prod.firebasestorage.app</string>
<string name="project_id">willma-prod</string>
```

**How to Fix:** Ensure Firebase Security Rules are properly configured to prevent unauthorized access. Review all rules at Firebase Console → Firestore/Firebase Storage → Rules. Make sure no rules allow `allow read, write: if true;`.

### Ramadan API Key

**File:** `app.config`
```
RAMADAN_API = NmQZJdz5skBXh9LPid6sgvDArJEgQKz3qxWtpI9mNn1brVxR
```

**How to Fix:** Move to backend environment variables, same as LLM keys. Never embed third-party API keys in client code.

### Sentry DSN

**File:** `app.config`
```
SENTRY_DSN = https://184ac66dc585890453c18f19205e7094@o4509140680572928.ingest.de.sentry.io/4509711491137616
```

**How to Fix:** While Sentry DSNs are semi-public by design, ensure your Sentry project has appropriate rate limiting and IP restrictions configured.

### Sentry Verification Token

**File:** `verification.properties` (line 3)
```
token=MNMM3TDLWFC5DOCIOFYQJO7JWI
```

**How to Fix:** This is a low-impact SDK verification token. If possible, move to build configuration rather than bundling in assets.

---

## 10. MEDIUM: No Certificate Pinning

### Severity: MEDIUM 🟡
### File: N/A — no pinning implementation found

### The Problem

The application does not implement certificate pinning for any of its API endpoints. While Expo includes a root certificate (`expo-root.pem`) for code signing verification of OTA updates, there is no network-level certificate pinning for the app's API communications with `app.willma.life` or any other backend service.

### Impact

MITM attacks with compromised CA certificates are possible. An attacker who obtains a certificate from a trusted CA (through compromise, social engineering, or a state-level actor) can intercept all HTTPS traffic without detection.

### How to Fix

**Option A: OkHttp CertificatePinner (recommended for React Native)**

```java
CertificatePinner certificatePinner = new CertificatePinner.Builder()
    .add("app.willma.life", "sha256/YOUR_CERT_HASH_HERE")
    .add("app.willma.life", "sha256/BACKUP_CERT_HASH_HERE")
    .build();

OkHttpClient client = new OkHttpClient.Builder()
    .certificatePinner(certificatePinner)
    .build();
```

**Option B: Android Network Security Configuration** (see Section 5 above for the XML template)

To get your certificate hash:
```bash
openssl s_client -connect app.willma.life:443 | openssl x509 -pubkey | openssl pkey -pubin -outform der | openssl dgst -sha256 -binary | openssl enc -base64
```

---

## 11. MEDIUM: Overly Broad FileProvider Paths

### Severity: MEDIUM 🟡
### Files: [`vulnerable-files/provider-paths/`](vulnerable-files/provider-paths/)

### The Problem

Multiple FileProvider path configurations use overly broad path definitions, exposing entire directory trees:

| File | Problematic Definition | Exposure |
|------|----------------------|----------|
| `provider_paths.xml` | `<external-path name="external_files" path="."/>` | All external storage |
| `file_viewer_provider_paths.xml` | `<files-path name="files" path="/"/>` + `<cache-path name="cache" path="/"/>` + `<external-path name="external" path="."/>` | All internal + external |
| `file_provider_paths.xml` | `<external-path name="shared" path="."/>` | All external storage |
| `ivpusic_imagepicker_provider_paths.xml` | `<external-path name="external_files" path="."/>` | All external storage |

### Impact

Any application receiving a content URI from WILLMA could access any file within these directories, potentially including cached authentication tokens, user data, or downloaded content that was meant to be private.

### How to Fix

Restrict FileProvider paths to specific subdirectories that need to be shared:

```xml
<!-- BEFORE (VULNERABLE): -->
<external-path name="external_files" path="."/>

<!-- AFTER (FIXED): -->
<external-path name="shared_images" path="Pictures/Willma"/>
<external-path name="shared_documents" path="Documents/Willma"/>
<files-path name="shared_files" path="shared/"/>
<cache-path name="shared_cache" path="shared_cache/"/>
```

---

## 12. MEDIUM: Development Code in Release Build

### Severity: MEDIUM 🟡
### Files: [`vulnerable-files/rn_dev_preferences.xml`](vulnerable-files/rn_dev_preferences.xml), [`vulnerable-files/DevMenuDevToolsDelegate.java`](vulnerable-files/DevMenuDevToolsDelegate.java), [`vulnerable-files/strings.xml`](vulnerable-files/strings.xml) (line 327)

### The Problem

The production build contains numerous React Native development support artifacts:

- `rn_dev_preferences.xml` includes settings for JS Dev Mode, Minify, and Debug Server Host
- `strings.xml` line 327 contains `"DEVELOPMENT CLIENT"` as splash screen text
- `DevMenuDevToolsDelegate.java` includes methods like `openJSInspector`, `toggleRemoteDebugging`, `reload`, and `togglePerformanceMonitor`

### Impact

If the dev menu can be triggered through the Expo gesture (shaking the device), it could expose debugging capabilities. The "DEVELOPMENT CLIENT" text in the splash screen may confuse users and reveals build configuration details.

### How to Fix

1. **Configure ProGuard/R8 rules** to strip dev support code from release builds
2. **Change the splash screen text** from "DEVELOPMENT CLIENT" to the actual app name
3. **Verify the dev menu is disabled** in the release build:
   ```javascript
   // In your Expo app.json / app.config.js
   {
     "expo": {
       "jsEngine": "hermes",
       // Ensure dev tools are not bundled in production
     }
   }
   ```
4. **Add to `android/app/build.gradle`:**
   ```groovy
   buildTypes {
       release {
           minifyEnabled true
           shrinkResources true
           proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
       }
   }
   ```

---

## 13. MEDIUM: Excessive and Dangerous Permissions

### Severity: MEDIUM 🟡
### File: [`vulnerable-files/AndroidManifest.xml`](vulnerable-files/AndroidManifest.xml)

### Problematic Permissions

| Permission | Risk | Recommendation |
|-----------|------|----------------|
| `READ_PHONE_STATE` | Access to IMEI, phone number, call state — **unnecessary** for an AI assistant app | **REMOVE** — use Firebase Installations ID for analytics |
| `SYSTEM_ALERT_WINDOW` | Allows overlay on other apps — potential tapjacking | **REMOVE** unless floating UI is needed |
| `DOWNLOAD_WITHOUT_NOTIFICATION` | Silent downloads — system-level permission, suspicious signal | **REMOVE** — won't be granted on most devices |
| `ACTIVITY_RECOGNITION` | Physical activity detection — unclear purpose | **REMOVE** unless fitness features exist |
| `ACCESS_FINE_LOCATION` + `ACCESS_COARSE_LOCATION` | Precise + approximate GPS | **Justify** — add clear disclosure to users |

### How to Fix

Remove unnecessary permissions from AndroidManifest.xml:

```xml
<!-- REMOVE THESE PERMISSIONS: -->
<!-- <uses-permission android:name="android.permission.READ_PHONE_STATE"/> -->
<!-- <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/> -->
<!-- <uses-permission android:name="android.permission.DOWNLOAD_WITHOUT_NOTIFICATION"/> -->
```

For the Google Play data safety declaration, clearly document why each remaining dangerous permission is needed.

---

## 14. MEDIUM: Expo OTA Update Security

### Severity: MEDIUM 🟡
### File: [`vulnerable-files/AndroidManifest.xml`](vulnerable-files/AndroidManifest.xml)

### The Problem

The app has Expo Updates enabled with `EXPO_UPDATES_CHECK_ON_LAUNCH` set to `ALWAYS` and a **300-second launch wait** (5 minutes). The update URL is:
```
https://u.expo.dev/0c01da2c-5409-459b-a106-98322e3d7076
```

on the `production` channel. While Expo includes code signing verification capabilities and a `expo-root.pem` certificate is bundled, the critical question is whether code signing is **actually enforced** or if `allowUnsignedManifests` is set to `true`.

### Impact

If code signing is not enforced, an attacker who can MITM the connection (especially given the lack of certificate pinning) could push malicious JavaScript updates that execute in the app context with full access to native capabilities including the camera, microphone, location, and all stored data.

### How to Fix

1. **Verify code signing is enforced** in your Expo configuration:
   ```javascript
   // app.config.js or app.json
   {
     "expo": {
       "updates": {
         "enabled": true,
         "codeSigningCertificate": "./expo-root.pem",
         "codeSigningMetadata": {
           "alg": "rsa-v1_5-sha256",
           "keyid": "main"
         }
       }
     }
   }
   ```

2. **Ensure unsigned manifests are rejected** — do NOT set `allowUnsignedManifests: true` in production.

3. **Reduce the launch wait time** from 300 seconds (5 minutes) to something reasonable like 0-3 seconds to avoid blocking the user:
   ```xml
   <meta-data android:name="expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS" android:value="3000"/>
   ```

4. **Protect the Expo project** — ensure only authorized accounts can publish updates to the `production` channel.

---

## 15. MEDIUM: Other Medium Findings

### 15.1 React Native WebView Bridge

**File:** [`vulnerable-files/RNCWebView.java`](vulnerable-files/RNCWebView.java)

The `RNCWebView` component adds a `RNCWebViewBridge` JavaScript interface when messaging is enabled. Any web page loaded in the WebView could call methods on the bridge object.

**Fix:** Ensure the WebView only loads trusted URLs and validate all `source` prop values in the JS layer. Do not load arbitrary URLs from user input.

### 15.2 HTTP URLs in Production Build

**File:** The React Native dev support infrastructure uses plain HTTP URLs for Metro bundler communication. While only active during development, the code remains in the production build.

**Fix:** Configure ProGuard/R8 to strip dev support classes from release builds. Add keep rules that exclude `com.facebook.react.devsupport.**` from the release build.

### 15.3 Facebook SDK Auto-Tracking

**File:** [`vulnerable-files/AndroidManifest.xml`](vulnerable-files/AndroidManifest.xml)

```xml
<meta-data android:name="com.facebook.sdk.AutoInitEnabled" android:value="true"/>
<meta-data android:name="com.facebook.sdk.AutoLogAppEventsEnabled" android:value="true"/>
<meta-data android:name="com.facebook.sdk.AdvertiserIDCollectionEnabled" android:value="true"/>
```

**Fix:** Disable auto-init and auto-logging until explicit user consent is obtained (required for GDPR/CCPA compliance):
```xml
<meta-data android:name="com.facebook.sdk.AutoInitEnabled" android:value="false"/>
<meta-data android:name="com.facebook.sdk.AutoLogAppEventsEnabled" android:value="false"/>
<meta-data android:name="com.facebook.sdk.AdvertiserIDCollectionEnabled" android:value="false"/>
```

### 15.4 GraphQL API URL Exposed

**File:** [`vulnerable-files/app.config`](vulnerable-files/app.config)

The URL `https://app.willma.life/api/graphql` is exposed in the app config.

**Fix:** This is somewhat unavoidable as the client needs to know the API URL. Ensure the GraphQL endpoint has proper authentication, rate limiting, and query depth limiting to prevent abuse.

---

## 16. LOW and INFO Findings

### LOW Findings

| # | Finding | File | Fix |
|---|---------|------|-----|
| 1 | CustomTabActivity exported (Facebook SDK) | AndroidManifest.xml | Expected for FB OAuth; validate callback data |
| 2 | Dev menu components in release build | DevMenuDevToolsDelegate.java | Verify disabled in release; strip with ProGuard |
| 3 | Facebook App ID exposed | strings.xml | Semi-public by design; secure FB app settings |
| 4 | ACTIVITY_RECOGNITION permission | AndroidManifest.xml | Remove unless fitness features exist |
| 5 | Sentry verification token | verification.properties | Low impact; move to build config if possible |
| 6 | DOWNLOAD_WITHOUT_NOTIFICATION permission | AndroidManifest.xml | Remove — won't be granted on most devices |
| 7 | SYSTEM_ALERT_WINDOW permission | AndroidManifest.xml | Remove unless floating UI is needed |

### INFO Findings

| # | Finding | File | Notes |
|---|---------|------|-------|
| 1 | FCM receivers exported | AndroidManifest.xml | Standard Google config with proper permissions |
| 2 | WebView secure defaults (positive) | RNCWebViewManagerImpl.java | `setAllowFileAccess(false)` etc. — good practice |
| 3 | Microsoft Clarity analytics included | clarity.js | Ensure privacy policy disclosure |
| 4 | Pairip license verification | LicenseClient.java | Standard Google Play anti-piracy |

---

## 17. Complete Findings Summary Table

| # | Severity | Category | Finding | File |
|---|----------|----------|---------|------|
| 1 | CRITICAL | Credential Leak | OpenAI API Key hardcoded | app.config |
| 2 | CRITICAL | Credential Leak | Anthropic API Key hardcoded | app.config |
| 3 | CRITICAL | Credential Leak | DeepSeek API Key hardcoded | app.config |
| 4 | CRITICAL | Credential Leak | Gemini API Key hardcoded | app.config |
| 5 | CRITICAL | SSL Bypass | HostnameVerifier accepts all hostnames | ReactNativeBlobUtilUtils.java |
| 6 | CRITICAL | Credential Leak | Facebook Client Token in plaintext | strings.xml |
| 7 | HIGH | Credential Leak | Google/Firebase API Key hardcoded | strings.xml |
| 8 | HIGH | Credential Leak | Facebook App ID and Client Token exposed | strings.xml |
| 9 | HIGH | Network Security | Missing network_security_config.xml | AndroidManifest.xml |
| 10 | HIGH | Exported Component | CropImageActivity exported without protection | AndroidManifest.xml |
| 11 | HIGH | WebView Security | Apple Sign-In WebView JS interface | SignInWebViewDialogFragment.java |
| 12 | HIGH | Data Exposure | android:allowBackup=true enabled | AndroidManifest.xml |
| 13 | HIGH | Credential Leak | Ramadan API Key hardcoded | app.config |
| 14 | HIGH | Credential Leak | Sentry DSN exposed | app.config |
| 15 | MEDIUM | Insecure Communication | No certificate pinning implemented | N/A |
| 16 | MEDIUM | Insecure Communication | HTTP URLs in production build | DevServerHelper.java |
| 17 | MEDIUM | WebView Security | RN WebView addJavascriptInterface | RNCWebView.java |
| 18 | MEDIUM | Credential Leak | Firebase config IDs exposed | strings.xml |
| 19 | MEDIUM | Debug Info | Dev support strings in release build | rn_dev_preferences.xml |
| 20 | MEDIUM | Path Traversal | Overly broad FileProvider paths | Multiple XML files |
| 21 | MEDIUM | Excessive Permissions | READ_PHONE_STATE permission | AndroidManifest.xml |
| 22 | MEDIUM | Update Security | Expo Updates - verify code signing | AndroidManifest.xml |
| 23 | MEDIUM | Credential Leak | GraphQL API URL exposed | app.config |
| 24 | MEDIUM | Tracking | Facebook SDK auto-tracking enabled | AndroidManifest.xml |
| 25 | MEDIUM | Credential Leak | Expo Project ID exposed | app.config |
| 26 | MEDIUM | Credential Leak | License RSA Public Key exposed | LicenseClient.java |
| 27 | LOW | Exported Component | CustomTabActivity exported (FB SDK) | AndroidManifest.xml |
| 28 | LOW | Excessive Permissions | SYSTEM_ALERT_WINDOW permission | AndroidManifest.xml |
| 29 | LOW | Suspicious Permission | DOWNLOAD_WITHOUT_NOTIFICATION | AndroidManifest.xml |
| 30 | LOW | Debug Exposure | Dev menu components in release | DevMenuDevToolsDelegate.java |
| 31 | LOW | Information Disclosure | Facebook App ID exposed | strings.xml |
| 32 | LOW | Excessive Permissions | ACTIVITY_RECOGNITION permission | AndroidManifest.xml |
| 33 | LOW | Credential Leak | Sentry verification token | verification.properties |
| 34 | INFO | Exported Component | FCM receivers (standard config) | AndroidManifest.xml |
| 35 | INFO | WebView Security | WebView secure defaults (positive) | RNCWebViewManagerImpl.java |
| 36 | INFO | Tracking | Microsoft Clarity analytics included | clarity.js |
| 37 | INFO | License | Pairip license verification (standard) | LicenseClient.java |

---

## 18. Priority Remediation Plan

### Phase 1: Immediate — Before Google Play Launch ⚡

| # | Action | Impact |
|---|--------|--------|
| 1 | **Rotate ALL LLM API keys** (OpenAI, Anthropic, DeepSeek, Gemini) | Prevents financial loss from key abuse |
| 2 | **Move API keys to secure backend** — proxy all AI calls through `app.willma.life` | Eliminates client-side key exposure |
| 3 | **Remove `getUnsafeOkHttpClient()`** or gate behind `BuildConfig.DEBUG` | Fixes SSL verification bypass |
| 4 | **Rotate Facebook Client Token** and remove from strings.xml | Prevents Facebook API impersonation |
| 5 | **Set `android:allowBackup="false"`** in AndroidManifest.xml | Prevents ADB data extraction |
| 6 | **Set `CropImageActivity exported="false"`** | Prevents unauthorized activity launch |

### Phase 2: Short-term — Within 1 Week 📅

| # | Action | Impact |
|---|--------|--------|
| 7 | Add `network_security_config.xml` with cleartext blocking and certificate pinning | Explicit TLS enforcement |
| 8 | Implement certificate pinning for `app.willma.life` | Prevents MITM with compromised CAs |
| 9 | Restrict Google API key to app package name + SHA-1 | Limits key abuse surface |
| 10 | Narrow FileProvider paths to specific subdirectories | Prevents unauthorized file access |
| 11 | Remove `READ_PHONE_STATE` permission | Reduces privacy concern and Play review risk |
| 12 | Verify Expo code signing enforcement (`CODE_SIGNING_ENABLED=true`) | Secures OTA update chain |

### Phase 3: Medium-term — Within 1 Month 📆

| # | Action | Impact |
|---|--------|--------|
| 13 | Strip dev support code from release builds via ProGuard/R8 | Reduces attack surface |
| 14 | Remove `DOWNLOAD_WITHOUT_NOTIFICATION` and `SYSTEM_ALERT_WINDOW` permissions | Removes suspicious signals |
| 15 | Add API rate limiting on all backend endpoints | Mitigates damage from future key leaks |
| 16 | Set up billing alerts and usage quotas on all AI provider consoles | Early warning for key abuse |
| 17 | Review Microsoft Clarity integration for privacy compliance | GDPR/CCPA compliance |
| 18 | Disable Facebook SDK auto-tracking until explicit user consent | Privacy regulation compliance |

---

## 19. Vulnerable Files Index

All files referenced in this report are available in the `vulnerable-files/` directory:

```
vulnerable-files/
├── AndroidManifest.xml                                    # Main manifest with backup/permissions/export issues
├── app.config                                             # CRITICAL: Contains 4 LLM API keys + other secrets
├── strings.xml                                            # CRITICAL: Facebook token, Firebase config, dev strings
├── ReactNativeBlobUtilUtils.java                          # CRITICAL: SSL hostname verification bypass
├── SignInWebViewDialogFragment.java                       # HIGH: WebView JS interface exposure
├── RNCWebView.java                                        # MEDIUM: WebView bridge attack surface
├── DevMenuDevToolsDelegate.java                           # LOW: Dev menu tools in release build
├── LicenseClient.java                                     # MEDIUM: License RSA public key
├── rn_dev_preferences.xml                                 # MEDIUM: Dev preferences in release build
├── verification.properties                                # LOW: Sentry verification token
└── provider-paths/
    ├── provider_paths.xml                                 # MEDIUM: Overly broad external-path
    ├── file_viewer_provider_paths.xml                     # MEDIUM: Root path + external-path exposure
    ├── file_provider_paths.xml                            # MEDIUM: External-path with "." path
    ├── ivpusic_imagepicker_provider_paths.xml             # MEDIUM: External-path with "." path
    ├── imagepicker_provider_paths.xml                     # MEDIUM: FileProvider path config
    ├── image_picker_provider_paths.xml                    # MEDIUM: FileProvider path config
    ├── file_system_provider_paths.xml                     # MEDIUM: FileProvider path config
    ├── sharing_provider_paths.xml                         # MEDIUM: FileProvider path config
    └── library_file_paths.xml                             # MEDIUM: FileProvider path config
```

---

*Report generated by Z.ai Security Analysis on June 1, 2026*
