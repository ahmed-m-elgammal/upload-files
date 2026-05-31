# WILLMA APK Security Analysis

This repository contains a comprehensive security analysis of the WILLMA Android application (com.willma.client v1.10.1).

## ⚠️ Important Notice

**All secret values in the `vulnerable-files/` directory have been REDACTED** to prevent further exposure. The original secrets were already compromised by being embedded in the APK. You should **rotate all API keys immediately** regardless.

## Contents

| File | Description |
|------|-------------|
| [`SECURITY_REPORT.md`](SECURITY_REPORT.md) | Full security analysis report with 37 findings and fix instructions |
| [`vulnerable-files/`](vulnerable-files/) | Decompiled files containing security vulnerabilities |
| [`vulnerable-files/app.config`](vulnerable-files/app.config) | Originally contained 4 LLM API keys (REDACTED) |
| [`vulnerable-files/strings.xml`](vulnerable-files/strings.xml) | Originally contained Facebook token, Firebase config (REDACTED) |
| [`vulnerable-files/ReactNativeBlobUtilUtils.java`](vulnerable-files/ReactNativeBlobUtilUtils.java) | SSL hostname verification bypass |
| [`vulnerable-files/AndroidManifest.xml`](vulnerable-files/AndroidManifest.xml) | Backup enabled, exported components, excessive permissions |
| [`vulnerable-files/SignInWebViewDialogFragment.java`](vulnerable-files/SignInWebViewDialogFragment.java) | WebView JavaScript interface exposure |
| [`vulnerable-files/provider-paths/`](vulnerable-files/provider-paths/) | Overly broad FileProvider path configurations |

## Key Findings

- **6 CRITICAL** vulnerabilities (hardcoded API keys, SSL bypass, token exposure)
- **8 HIGH** vulnerabilities (missing network security config, exported components, etc.)
- **12 MEDIUM** vulnerabilities (no cert pinning, broad FileProvider paths, etc.)
- **7 LOW + 4 INFO** findings

## Immediate Actions Required

1. **Rotate ALL API keys** (OpenAI, Anthropic, DeepSeek, Gemini)
2. **Move API keys to backend server** — never embed in client code
3. **Remove SSL bypass method** (`getUnsafeOkHttpClient`)
4. **Set `android:allowBackup="false"`**
5. **Fix exported CropImageActivity**

See the [full report](SECURITY_REPORT.md) for detailed fix instructions for every finding.
