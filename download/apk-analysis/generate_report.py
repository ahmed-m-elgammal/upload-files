#!/usr/bin/env python3
"""Generate WILLMA APK Security Analysis Report PDF"""

import os
from reportlab.lib.pagesizes import A4
from reportlab.lib.units import mm
from reportlab.lib.colors import HexColor, white, black
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.lib.enums import TA_LEFT, TA_CENTER, TA_JUSTIFY
from reportlab.platypus import (
    SimpleDocTemplate, Paragraph, Spacer, Table, TableStyle,
    PageBreak, KeepTogether, HRFlowable
)
from reportlab.platypus.flowables import Flowable

# Output path
OUTPUT_PDF = "/home/z/my-project/download/WILLMA_Security_Analysis_Report.pdf"

# Color palette
C_PRIMARY = HexColor("#1a1a2e")
C_ACCENT = HexColor("#e94560")
C_ACCENT_LIGHT = HexColor("#fce4ec")
C_SECONDARY = HexColor("#0f3460")
C_BG_LIGHT = HexColor("#f8f9fa")
C_TEXT = HexColor("#212529")
C_TEXT_MUTED = HexColor("#6c757d")
C_CRITICAL = HexColor("#dc3545")
C_HIGH = HexColor("#fd7e14")
C_MEDIUM = HexColor("#ffc107")
C_LOW = HexColor("#28a745")
C_INFO = HexColor("#17a2b8")
C_TABLE_HEADER = HexColor("#1a1a2e")
C_TABLE_ALT = HexColor("#f2f4f8")
C_BORDER = HexColor("#dee2e6")

WIDTH, HEIGHT = A4

# Custom styles
styles = getSampleStyleSheet()

style_title = ParagraphStyle(
    'CustomTitle', parent=styles['Title'],
    fontSize=28, leading=34, textColor=C_PRIMARY,
    spaceAfter=6, fontName='Helvetica-Bold'
)
style_subtitle = ParagraphStyle(
    'CustomSubtitle', parent=styles['Normal'],
    fontSize=14, leading=18, textColor=C_TEXT_MUTED,
    spaceAfter=20, fontName='Helvetica'
)
style_h1 = ParagraphStyle(
    'H1', parent=styles['Heading1'],
    fontSize=20, leading=26, textColor=C_PRIMARY,
    spaceBefore=20, spaceAfter=10, fontName='Helvetica-Bold'
)
style_h2 = ParagraphStyle(
    'H2', parent=styles['Heading2'],
    fontSize=16, leading=22, textColor=C_SECONDARY,
    spaceBefore=16, spaceAfter=8, fontName='Helvetica-Bold'
)
style_h3 = ParagraphStyle(
    'H3', parent=styles['Heading3'],
    fontSize=13, leading=18, textColor=C_TEXT,
    spaceBefore=12, spaceAfter=6, fontName='Helvetica-Bold'
)
style_body = ParagraphStyle(
    'CustomBody', parent=styles['Normal'],
    fontSize=10, leading=15, textColor=C_TEXT,
    spaceAfter=8, fontName='Helvetica', alignment=TA_JUSTIFY
)
style_body_small = ParagraphStyle(
    'BodySmall', parent=style_body,
    fontSize=9, leading=13, spaceAfter=4
)
style_code = ParagraphStyle(
    'Code', parent=styles['Code'],
    fontSize=8, leading=11, textColor=HexColor("#d63384"),
    fontName='Courier', backColor=HexColor("#f8f9fa"),
    spaceAfter=6, leftIndent=10, rightIndent=10,
    spaceBefore=4
)
style_bullet = ParagraphStyle(
    'Bullet', parent=style_body,
    leftIndent=20, bulletIndent=10,
    spaceAfter=4
)
style_severity = {
    'CRITICAL': ParagraphStyle('SevCrit', parent=style_body, textColor=C_CRITICAL, fontName='Helvetica-Bold'),
    'HIGH': ParagraphStyle('SevHigh', parent=style_body, textColor=C_HIGH, fontName='Helvetica-Bold'),
    'MEDIUM': ParagraphStyle('SevMed', parent=style_body, textColor=HexColor("#856404"), fontName='Helvetica-Bold'),
    'LOW': ParagraphStyle('SevLow', parent=style_body, textColor=C_LOW, fontName='Helvetica-Bold'),
    'INFO': ParagraphStyle('SevInfo', parent=style_body, textColor=C_INFO, fontName='Helvetica-Bold'),
}


class SeverityBadge(Flowable):
    """Colored severity badge"""
    def __init__(self, text, severity):
        Flowable.__init__(self)
        self.text = text
        self.severity = severity
        self.width = 70
        self.height = 18

    def draw(self):
        colors = {
            'CRITICAL': C_CRITICAL,
            'HIGH': C_HIGH,
            'MEDIUM': C_MEDIUM,
            'LOW': C_LOW,
            'INFO': C_INFO
        }
        c = colors.get(self.severity, C_TEXT_MUTED)
        self.canv.setFillColor(c)
        self.canv.roundRect(0, 0, self.width, self.height, 4, fill=1, stroke=0)
        self.canv.setFillColor(white)
        self.canv.setFont('Helvetica-Bold', 8)
        self.canv.drawCentredString(self.width / 2, 5, self.text)


def severity_para(severity):
    return Paragraph(severity, style_severity.get(severity, style_body))


def make_finding_table(findings):
    """Create a formatted findings summary table"""
    data = [['#', 'Severity', 'Category', 'Finding', 'File']]
    for i, f in enumerate(findings, 1):
        data.append([
            str(i),
            f['severity'],
            f['category'],
            f['title'],
            f.get('file', 'N/A')
        ])

    col_widths = [25, 65, 100, 200, 140]
    t = Table(data, colWidths=col_widths, repeatRows=1)
    style_cmds = [
        ('BACKGROUND', (0, 0), (-1, 0), C_TABLE_HEADER),
        ('TEXTCOLOR', (0, 0), (-1, 0), white),
        ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, 0), 8),
        ('FONTSIZE', (0, 1), (-1, -1), 7.5),
        ('FONTNAME', (0, 1), (-1, -1), 'Helvetica'),
        ('VALIGN', (0, 0), (-1, -1), 'MIDDLE'),
        ('GRID', (0, 0), (-1, -1), 0.5, C_BORDER),
        ('TOPPADDING', (0, 0), (-1, -1), 4),
        ('BOTTOMPADDING', (0, 0), (-1, -1), 4),
        ('LEFTPADDING', (0, 0), (-1, -1), 4),
        ('RIGHTPADDING', (0, 0), (-1, -1), 4),
    ]
    # Alternating row colors
    for i in range(1, len(data)):
        if i % 2 == 0:
            style_cmds.append(('BACKGROUND', (0, i), (-1, i), C_TABLE_ALT))
    # Severity colors
    sev_colors = {'CRITICAL': C_CRITICAL, 'HIGH': C_HIGH, 'MEDIUM': C_MEDIUM, 'LOW': C_LOW, 'INFO': C_INFO}
    for i, f in enumerate(findings, 1):
        c = sev_colors.get(f['severity'], C_TEXT_MUTED)
        style_cmds.append(('TEXTCOLOR', (1, i), (1, i), c))
        style_cmds.append(('FONTNAME', (1, i), (1, i), 'Helvetica-Bold'))

    t.setStyle(TableStyle(style_cmds))
    return t


def add_header_footer(canvas, doc):
    """Add page header and footer"""
    canvas.saveState()
    # Header line
    canvas.setStrokeColor(C_PRIMARY)
    canvas.setLineWidth(1)
    canvas.line(40, HEIGHT - 40, WIDTH - 40, HEIGHT - 40)
    canvas.setFont('Helvetica', 7)
    canvas.setFillColor(C_TEXT_MUTED)
    canvas.drawString(40, HEIGHT - 36, "WILLMA APK Security Analysis Report")
    canvas.drawRightString(WIDTH - 40, HEIGHT - 36, "Confidential")

    # Footer
    canvas.line(40, 35, WIDTH - 40, 35)
    canvas.drawString(40, 22, "Generated by Z.ai Security Analysis")
    canvas.drawRightString(WIDTH - 40, 22, f"Page {doc.page}")
    canvas.restoreState()


def build_report():
    doc = SimpleDocTemplate(
        OUTPUT_PDF, pagesize=A4,
        leftMargin=40, rightMargin=40,
        topMargin=55, bottomMargin=50
    )

    story = []

    # === COVER / TITLE ===
    story.append(Spacer(1, 60))
    story.append(Paragraph("WILLMA APK", style_title))
    story.append(Paragraph("Security Analysis Report", ParagraphStyle(
        'TitleSub', parent=style_title, fontSize=22, textColor=C_ACCENT, spaceAfter=20
    )))
    story.append(HRFlowable(width="100%", thickness=2, color=C_PRIMARY, spaceAfter=15))
    story.append(Paragraph("Application: WILLMA (com.willma.client) v1.10.1", style_subtitle))
    story.append(Paragraph("Platform: Android (React Native / Expo)", style_subtitle))
    story.append(Paragraph("Analysis Date: June 1, 2026", style_subtitle))
    story.append(Paragraph("Classification: Confidential", style_subtitle))

    story.append(Spacer(1, 30))

    # Executive Summary Box
    story.append(Paragraph("Executive Summary", style_h2))
    exec_summary = """A comprehensive security analysis of the WILLMA Android application (v1.10.1) has revealed 
    <b>37 security findings</b> across multiple categories, including <b>6 CRITICAL</b>, <b>8 HIGH</b>, 
    <b>12 MEDIUM</b>, <b>7 LOW</b>, and <b>4 INFO</b> severity issues. The most severe vulnerabilities involve 
    hardcoded LLM API keys (OpenAI, Anthropic, DeepSeek, Gemini) embedded in plaintext within the app configuration, 
    an SSL hostname verification bypass that accepts all certificates, and the Facebook client token exposed in 
    resource files. These vulnerabilities could allow attackers to consume API credits at the app owner's expense, 
    intercept encrypted communications, and impersonate the application on social platforms. Immediate remediation 
    is strongly recommended before publishing to Google Play Store."""
    story.append(Paragraph(exec_summary, style_body))

    # Risk Score
    story.append(Spacer(1, 10))
    risk_data = [
        ['Risk Category', 'Count', 'Status'],
        ['CRITICAL', '6', 'MUST FIX BEFORE LAUNCH'],
        ['HIGH', '8', 'SHOULD FIX BEFORE LAUNCH'],
        ['MEDIUM', '12', 'RECOMMENDED TO FIX'],
        ['LOW', '7', 'LOW PRIORITY'],
        ['INFO', '4', 'INFORMATIONAL'],
    ]
    risk_table = Table(risk_data, colWidths=[120, 60, 280])
    risk_style = [
        ('BACKGROUND', (0, 0), (-1, 0), C_TABLE_HEADER),
        ('TEXTCOLOR', (0, 0), (-1, 0), white),
        ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, -1), 9),
        ('GRID', (0, 0), (-1, -1), 0.5, C_BORDER),
        ('VALIGN', (0, 0), (-1, -1), 'MIDDLE'),
        ('TOPPADDING', (0, 0), (-1, -1), 5),
        ('BOTTOMPADDING', (0, 0), (-1, -1), 5),
        ('LEFTPADDING', (0, 0), (-1, -1), 8),
        # Severity row colors
        ('BACKGROUND', (0, 1), (-1, 1), HexColor("#fce4ec")),
        ('TEXTCOLOR', (0, 1), (0, 1), C_CRITICAL), ('FONTNAME', (0, 1), (0, 1), 'Helvetica-Bold'),
        ('BACKGROUND', (0, 2), (-1, 2), HexColor("#fff3e0")),
        ('TEXTCOLOR', (0, 2), (0, 2), C_HIGH), ('FONTNAME', (0, 2), (0, 2), 'Helvetica-Bold'),
        ('BACKGROUND', (0, 3), (-1, 3), HexColor("#fff9e6")),
        ('TEXTCOLOR', (0, 3), (0, 3), HexColor("#856404")), ('FONTNAME', (0, 3), (0, 3), 'Helvetica-Bold'),
        ('BACKGROUND', (0, 4), (-1, 4), HexColor("#e8f5e9")),
        ('TEXTCOLOR', (0, 4), (0, 4), C_LOW), ('FONTNAME', (0, 4), (0, 4), 'Helvetica-Bold'),
        ('BACKGROUND', (0, 5), (-1, 5), HexColor("#e3f2fd")),
        ('TEXTCOLOR', (0, 5), (0, 5), C_INFO), ('FONTNAME', (0, 5), (0, 5), 'Helvetica-Bold'),
    ]
    risk_table.setStyle(TableStyle(risk_style))
    story.append(risk_table)

    story.append(PageBreak())

    # === TABLE OF CONTENTS ===
    story.append(Paragraph("Table of Contents", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=12))
    toc_items = [
        "1. Application Overview",
        "2. Hardcoded Secrets and Credential Leak",
        "3. Network Security and Communication",
        "4. Exported Components Analysis",
        "5. WebView Security",
        "6. Insecure Data Storage",
        "7. Debug and Backup Flags",
        "8. Input Validation and File Provider Issues",
        "9. Permission Analysis",
        "10. React Native / Expo Specific Issues",
        "11. Complete Findings Summary",
        "12. Priority Remediation Plan",
    ]
    for item in toc_items:
        story.append(Paragraph(item, ParagraphStyle(
            'TOC', parent=style_body, fontSize=11, leading=20, leftIndent=10
        )))
    story.append(PageBreak())

    # === SECTION 1: Application Overview ===
    story.append(Paragraph("1. Application Overview", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    app_info = [
        ['Property', 'Value'],
        ['Package Name', 'com.willma.client'],
        ['Application Name', 'WILLMA'],
        ['Version', '1.10.1 (versionCode: 21)'],
        ['Min SDK', '23 (Android 6.0 Marshmallow)'],
        ['Target SDK', '35 (Android 15)'],
        ['Framework', 'React Native / Expo'],
        ['Base APK Size', '82 MB (Total XAPK: 119 MB)'],
        ['Native Libraries', 'armeabi_v7a'],
        ['Expo Project ID', '0c01da2c-5409-459b-a106-98322e3d7076'],
        ['Firebase Project', 'willma-prod'],
        ['GraphQL API', 'https://app.willma.life/api/graphql'],
    ]
    app_table = Table(app_info, colWidths=[150, 310])
    app_table.setStyle(TableStyle([
        ('BACKGROUND', (0, 0), (-1, 0), C_TABLE_HEADER),
        ('TEXTCOLOR', (0, 0), (-1, 0), white),
        ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, -1), 9),
        ('FONTNAME', (0, 1), (0, -1), 'Helvetica-Bold'),
        ('GRID', (0, 0), (-1, -1), 0.5, C_BORDER),
        ('VALIGN', (0, 0), (-1, -1), 'MIDDLE'),
        ('TOPPADDING', (0, 0), (-1, -1), 5),
        ('BOTTOMPADDING', (0, 0), (-1, -1), 5),
        ('LEFTPADDING', (0, 0), (-1, -1), 8),
        ('BACKGROUND', (0, 1), (0, -1), HexColor("#f0f2f5")),
    ]))
    story.append(app_table)
    story.append(Spacer(1, 10))

    story.append(Paragraph(
        """The WILLMA application is a React Native-based Android app built with the Expo framework. It integrates 
        multiple AI provider APIs (OpenAI, Anthropic, DeepSeek, and Google Gemini) to provide conversational AI 
        capabilities. The app also incorporates Facebook SDK for authentication, Firebase for messaging and analytics, 
        Microsoft Clarity for session tracking, and Google ML Kit for barcode scanning. The application uses a 
        GraphQL backend API hosted at app.willma.life. The app requests a significant number of permissions, 
        including location access, camera, audio recording, calendar read/write, and phone state access, which 
        raises concerns about the principle of least privilege.""", style_body))

    # === SECTION 2: Hardcoded Secrets ===
    story.append(Paragraph("2. Hardcoded Secrets and Credential Leak", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph(
        """The most critical finding in this analysis is the presence of multiple LLM API keys hardcoded in plaintext 
        within the application's configuration file. The file <b>resources/assets/app.config</b> contains a JSON 
        configuration block that embeds API keys for four different AI service providers. This means that anyone who 
        extracts the APK (which is trivially done using publicly available tools) can retrieve these keys and use them 
        to make API calls at the application owner's expense. The potential financial impact is significant, as LLM 
        API calls can accumulate costs rapidly, especially if automated scripts are used to exhaust the keys.""",
        style_body))

    story.append(Paragraph("2.1 LLM API Keys (CRITICAL)", style_h2))

    llm_keys = [
        ['Provider', 'Key (Truncated)', 'Impact'],
        ['OpenAI', 'sk-proj-OsMIWUQ...G3EA', 'Full API access - text, images, massive cost risk'],
        ['Anthropic', 'sk-ant-api03-Ceoak...WwAA', 'Full Claude API access - active provider'],
        ['DeepSeek', 'sk-f4e060a5b624...2ff5', 'Full DeepSeek API access'],
        ['Gemini', 'AIzaSyDaQPVTbMztW...lTE', 'Full Google Gemini API access'],
    ]
    llm_table = Table(llm_keys, colWidths=[80, 150, 230])
    llm_table.setStyle(TableStyle([
        ('BACKGROUND', (0, 0), (-1, 0), C_CRITICAL),
        ('TEXTCOLOR', (0, 0), (-1, 0), white),
        ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, -1), 8.5),
        ('FONTNAME', (0, 1), (0, -1), 'Helvetica-Bold'),
        ('GRID', (0, 0), (-1, -1), 0.5, C_BORDER),
        ('VALIGN', (0, 0), (-1, -1), 'MIDDLE'),
        ('TOPPADDING', (0, 0), (-1, -1), 5),
        ('BOTTOMPADDING', (0, 0), (-1, -1), 5),
        ('LEFTPADDING', (0, 0), (-1, -1), 6),
        ('BACKGROUND', (0, 1), (-1, -1), HexColor("#fce4ec")),
    ]))
    story.append(llm_table)
    story.append(Spacer(1, 8))

    story.append(Paragraph(
        """The Anthropic key is particularly valuable as the app configuration indicates <b>AI_PROVIDER=anthropic</b>, 
        meaning this is the primary active AI provider. All four keys appear to be billing-enabled production keys 
        with no apparent rate limiting or usage restrictions configured at the provider level. An attacker extracting 
        the APK could automate API calls to any of these services, potentially incurring thousands of dollars in 
        costs within hours. Additionally, the keys could be used to access any functionality available through the 
        respective APIs, including generating content, accessing model fine-tuning endpoints, or extracting training data.""",
        style_body))

    story.append(Paragraph("2.2 Other Hardcoded Credentials (HIGH)", style_h2))

    other_creds = [
        ['Credential', 'Location', 'Value (Truncated)'],
        ['Facebook Client Token', 'strings.xml', '4b0f881668cbab35f07d4a6ed6ba00cb'],
        ['Facebook App ID', 'strings.xml', '1241712067901568'],
        ['Google API Key', 'strings.xml', 'AIzaSyBfe2EJht-OaFnbfSNzXzCL96yMG3AXa7c'],
        ['Ramadan API Key', 'app.config', 'NmQZJdz5skBXh9LPid6sgvDArJEgQKz3qxWtpI9mNn1brVxR'],
        ['Sentry DSN', 'app.config', 'https://184ac66dc585...@o4509140680572928...'],
        ['Firebase Project ID', 'strings.xml', 'willma-prod'],
        ['Google Storage Bucket', 'strings.xml', 'willma-prod.firebasestorage.app'],
        ['License RSA Public Key', 'LicenseClient.java', 'MIIBIjANBgkqhkiG9w0BAQEF...'],
    ]
    creds_table = Table(other_creds, colWidths=[130, 90, 240])
    creds_table.setStyle(TableStyle([
        ('BACKGROUND', (0, 0), (-1, 0), C_HIGH),
        ('TEXTCOLOR', (0, 0), (-1, 0), white),
        ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, -1), 8),
        ('GRID', (0, 0), (-1, -1), 0.5, C_BORDER),
        ('VALIGN', (0, 0), (-1, -1), 'MIDDLE'),
        ('TOPPADDING', (0, 0), (-1, -1), 4),
        ('BOTTOMPADDING', (0, 0), (-1, -1), 4),
        ('LEFTPADDING', (0, 0), (-1, -1), 6),
    ] + [('BACKGROUND', (0, i), (-1, i), HexColor("#fff8f0")) for i in range(2, len(other_creds), 2)]))
    story.append(creds_table)
    story.append(Spacer(1, 8))

    story.append(Paragraph(
        """The Facebook Client Token is particularly concerning as it allows API calls to be made on behalf of the 
        Facebook application integration. Combined with the Facebook App ID, an attacker could impersonate the 
        WILLMA app in Facebook API interactions, potentially accessing user data or performing actions as the app. 
        The Google API key, if unrestricted, could be used to access Google Cloud services at the project's expense. 
        The Firebase project configuration (project ID, storage bucket, sender ID) provides a complete map of the 
        backend infrastructure that could be used for targeted attacks against the Firebase project.""",
        style_body))

    # === SECTION 3: Network Security ===
    story.append(Paragraph("3. Network Security and Communication", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph("3.1 SSL Hostname Verification Bypass (CRITICAL)", style_h2))
    story.append(Paragraph(
        """The application includes a method <b>ReactNativeBlobUtilUtils.getUnsafeOkHttpClient()</b> that creates 
        an OkHttpClient instance which accepts ALL SSL hostnames by returning true from the HostnameVerifier.verify() 
        callback. This completely bypasses SSL hostname verification, enabling man-in-the-middle (MITM) attacks on 
        any connection that uses this HTTP client. An attacker on the same network (e.g., public Wi-Fi) could 
        intercept and modify all traffic between the app and its backend servers, including authentication tokens, 
        user data, and API requests.""", style_body))
    story.append(Paragraph(
        """File: com/ReactNativeBlobUtil/ReactNativeBlobUtilUtils.java""",
        style_body_small))
    story.append(Paragraph(
        "newBuilder.hostnameVerifier(new HostnameVerifier() { public boolean verify(String str, SSLSession sSLSession) { return true; } });",
        style_code))

    story.append(Paragraph("3.2 Missing Network Security Configuration (HIGH)", style_h2))
    story.append(Paragraph(
        """The application does not define a <b>network_security_config.xml</b> file, and the AndroidManifest.xml 
        does not reference the android:networkSecurityConfig attribute. This means the app relies entirely on the 
        platform's default security policy. While Android 7+ blocks cleartext traffic by default, there is no 
        explicit enforcement, no certificate pinning definitions, and no custom trust anchors configured. This 
        leaves the app vulnerable to future misconfigurations that could allow cleartext traffic, and provides no 
        defense-in-depth against TLS downgrade or MITM attacks using compromised certificate authorities.""",
        style_body))

    story.append(Paragraph("3.3 No Certificate Pinning (MEDIUM)", style_h2))
    story.append(Paragraph(
        """The application does not implement certificate pinning for any of its API endpoints. While Expo includes 
        a root certificate (expo-root.pem) for code signing verification of OTA updates, there is no network-level 
        certificate pinning for the app's API communications with app.willma.life or any other backend service. 
        This means that an attacker who can obtain a certificate from a trusted CA (through compromise, social 
        engineering, or a state-level actor) can intercept all HTTPS traffic without detection. Certificate pinning 
        would ensure that only certificates with the expected public key are accepted, even if a CA is compromised.""",
        style_body))

    story.append(Paragraph("3.4 HTTP URLs in Production Build (MEDIUM)", style_h2))
    story.append(Paragraph(
        """The React Native dev support infrastructure in the production build contains multiple HTTP (non-HTTPS) 
        URLs used for Metro bundler communication, including URLs like http://%s/status and http://%s/launch-js-devtools. 
        While these are only active during development, their presence in the production build indicates incomplete 
        build optimization. If the dev mode were accidentally enabled in production, all Metro traffic would be sent 
        over cleartext, allowing MITM attacks that could inject arbitrary JavaScript code into the running application.""",
        style_body))

    # === SECTION 4: Exported Components ===
    story.append(Paragraph("4. Exported Components Analysis", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph("4.1 CropImageActivity Exported Without Protection (HIGH)", style_h2))
    story.append(Paragraph(
        """The activity <b>com.canhub.cropper.CropImageActivity</b> is declared with android:exported="true" and 
        no intent-filter restrictions or permission guards. Any application on the device can launch this activity 
        with crafted intents, potentially causing unexpected behavior, accessing image data being cropped, or crashing 
        the app through malformed input. This is a common vulnerability in Android apps where third-party library 
        activities are exported by default. The fix is straightforward: set android:exported="false" for this activity 
        in the manifest, or add a custom signature-level permission to restrict access to apps signed with the same key.""",
        style_body))

    story.append(Paragraph("4.2 Other Exported Components", style_h2))
    exported_data = [
        ['Component', 'Exported', 'Risk'],
        ['CustomTabActivity (Facebook)', 'true', 'LOW - Standard FB SDK OAuth flow'],
        ['ReactNativeFirebaseMessagingReceiver', 'true (with perm)', 'INFO - Protected by C2DM permission'],
        ['FirebaseInstanceIdReceiver', 'true (with perm)', 'INFO - Protected by C2DM permission'],
        ['DiagnosticsReceiver (WorkManager)', 'true (with DUMP perm)', 'LOW - System-only permission'],
        ['ProfileInstallReceiver', 'true (with DUMP perm)', 'LOW - System-only permission'],
        ['SystemJobService (WorkManager)', 'true (with BIND_JOB_SERVICE)', 'INFO - Standard AndroidX component'],
    ]
    exp_table = Table(exported_data, colWidths=[180, 100, 180])
    exp_table.setStyle(TableStyle([
        ('BACKGROUND', (0, 0), (-1, 0), C_TABLE_HEADER),
        ('TEXTCOLOR', (0, 0), (-1, 0), white),
        ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, -1), 8),
        ('GRID', (0, 0), (-1, -1), 0.5, C_BORDER),
        ('VALIGN', (0, 0), (-1, -1), 'MIDDLE'),
        ('TOPPADDING', (0, 0), (-1, -1), 4),
        ('BOTTOMPADDING', (0, 0), (-1, -1), 4),
        ('LEFTPADDING', (0, 0), (-1, -1), 6),
    ]))
    story.append(exp_table)

    # === SECTION 5: WebView Security ===
    story.append(Paragraph("5. WebView Security", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph("5.1 Apple Sign-In WebView JavaScript Interface (HIGH)", style_h2))
    story.append(Paragraph(
        """The Apple Sign-In WebView (SignInWebViewDialogFragment) enables JavaScript and uses addJavascriptInterface 
        to expose a FormInterceptorInterface to the WebView. While the minSdkVersion of 23 eliminates the well-known 
        reflection-based attack vector on pre-API 17 devices, the exposed JavaScript interface could still be exploited 
        if the Apple authentication page is compromised or redirected through phishing. The interface methods could be 
        called by any JavaScript executing within the WebView, potentially leaking authentication state data or 
        interfering with the sign-in flow. The WebView also enables setJavaScriptCanOpenWindowsAutomatically, which 
        could allow popup-based attacks.""", style_body))

    story.append(Paragraph("5.2 React Native WebView Bridge (MEDIUM)", style_h2))
    story.append(Paragraph(
        """The RNCWebView component adds a RNCWebViewBridge JavaScript interface when messaging is enabled. This is 
        the standard React Native WebView bridge mechanism, but it expands the attack surface of any WebView that loads 
        external content. Any web page loaded in the WebView could call methods on the bridge object. If the WebView 
        loads arbitrary or user-controlled URLs, this becomes a significant risk, as malicious JavaScript could 
        interact with the native layer through the bridge. On the positive side, the RNCWebViewManagerImpl correctly 
        sets secure defaults including setAllowFileAccess(false), setAllowContentAccess(false), and 
        setAllowFileAccessFromFileURLs(false), which prevents local file access through WebViews.""",
        style_body))

    # === SECTION 6: Insecure Data Storage ===
    story.append(Paragraph("6. Insecure Data Storage", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph("6.1 android:allowBackup Enabled (HIGH)", style_h2))
    story.append(Paragraph(
        """The application has android:allowBackup="true" set in the manifest. This allows the app's data to be 
        backed up via ADB (Android Debug Bridge), including SharedPreferences, SQLite databases, and internal 
        files. This data may contain authentication tokens, user preferences, cached credentials, and other 
        sensitive information. Anyone with physical access to the device (or via ADB over USB debugging) can 
        extract the app's complete data directory using the command "adb backup com.willma.client". This backup 
        can then be parsed to extract all stored data. The fix is to set android:allowBackup="false" and 
        optionally specify android:fullBackupContent to explicitly control which data, if any, can be included 
        in auto-backups.""", style_body))

    story.append(Paragraph("6.2 Facebook Client Token in Plaintext Resources (CRITICAL)", style_h2))
    story.append(Paragraph(
        """As detailed in Section 2, the Facebook Client Token is hardcoded in strings.xml and referenced as a 
        meta-data value in the AndroidManifest. This token is trivially extractable from the APK by anyone using 
        tools like apktool, jadx, or even a simple ZIP extraction. The token can then be used to make API calls 
        on behalf of the Facebook application integration, potentially accessing user data or performing actions 
        as the app. This is particularly dangerous because the Facebook SDK Auto-Init and Auto-Log App Events are 
        both enabled (set to true in the manifest), meaning the SDK initializes and begins tracking as soon as 
        the app starts, using this exposed token.""", style_body))

    # === SECTION 7: Debug and Backup Flags ===
    story.append(Paragraph("7. Debug and Backup Flags", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph("7.1 Development Support Code in Release Build (MEDIUM)", style_h2))
    story.append(Paragraph(
        """The production build contains numerous React Native development support artifacts. The file 
        rn_dev_preferences.xml includes settings for JS Dev Mode, Minify, and Debug Server Host configuration. 
        The strings.xml file contains the text "DEVELOPMENT CLIENT" as a splash screen string. While the 
        DevSettingsActivity itself is marked exported="false", the presence of development preferences and 
        strings in a release build indicates incomplete build optimization and could leak information about the 
        development setup. More critically, if the dev menu can be triggered through the Expo gesture (shaking 
        the device or three-finger long press), it could expose debugging capabilities including remote JS 
        debugging, performance monitoring, and element inspection.""", style_body))

    story.append(Paragraph("7.2 Expo Dev Menu Components Present (LOW)", style_h2))
    story.append(Paragraph(
        """The Expo dev menu module (expo.modules.devmenu) is included in the release build. The 
        DevMenuDevToolsDelegate class exists with methods like openJSInspector, toggleRemoteDebugging, reload, 
        and togglePerformanceMonitor. While these are typically disabled in production builds, their presence in 
        the binary increases the attack surface. A determined attacker could potentially enable these features 
        through runtime manipulation or hooking frameworks like Frida or Xposed. The recommended action is to 
        verify that the dev menu is properly disabled in the release build and that the DevMenuInternalSettingsWrapper 
        has all debug features disabled by default.""", style_body))

    # === SECTION 8: Input Validation ===
    story.append(Paragraph("8. Input Validation and File Provider Issues", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph("8.1 Overly Broad FileProvider Paths (MEDIUM)", style_h2))
    story.append(Paragraph(
        """Multiple FileProvider path configurations use overly broad path definitions, exposing entire directory 
        trees rather than specific subdirectories. The provider_paths.xml defines external-path with path=".", 
        which exposes the entire external storage directory. The file_viewer_provider_paths.xml defines files-path 
        with path="/" and cache-path with path="/", exposing the complete internal files and cache directories. 
        The file_provider_paths.xml similarly uses external-path with path=".". These broad path definitions mean 
        that any application receiving a content URI from WILLMA could access any file within these directories, 
        potentially including cached authentication tokens, user data, or downloaded content that was meant to be 
        private.""", style_body))

    provider_paths = [
        ['File', 'Path Definition', 'Exposure'],
        ['provider_paths.xml', 'external-path path="."', 'All external storage'],
        ['file_viewer_provider_paths.xml', 'files-path path="/" + cache-path path="/" + external-path path="."', 'All internal + external'],
        ['file_provider_paths.xml', 'external-path path="."', 'All external storage'],
        ['ivpusic_imagepicker_provider_paths.xml', 'external-path path="."', 'All external storage'],
    ]
    pp_table = Table(provider_paths, colWidths=[160, 160, 140])
    pp_table.setStyle(TableStyle([
        ('BACKGROUND', (0, 0), (-1, 0), C_TABLE_HEADER),
        ('TEXTCOLOR', (0, 0), (-1, 0), white),
        ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, -1), 8),
        ('GRID', (0, 0), (-1, -1), 0.5, C_BORDER),
        ('VALIGN', (0, 0), (-1, -1), 'MIDDLE'),
        ('TOPPADDING', (0, 0), (-1, -1), 4),
        ('BOTTOMPADDING', (0, 0), (-1, -1), 4),
        ('LEFTPADDING', (0, 0), (-1, -1), 6),
    ]))
    story.append(pp_table)

    # === SECTION 9: Permissions ===
    story.append(Paragraph("9. Permission Analysis", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph(
        """The application requests a total of 49 permissions, many of which are concerning from a security and 
        privacy perspective. Below is an analysis of the most problematic permissions that could be exploited by 
        users or could raise red flags during Google Play review.""", style_body))

    perm_data = [
        ['Permission', 'Risk Level', 'Concern'],
        ['READ_PHONE_STATE', 'MEDIUM', 'Access to IMEI, phone number, call state - unnecessary for most apps'],
        ['SYSTEM_ALERT_WINDOW', 'LOW', 'Allows overlay on other apps - potential tapjacking risk'],
        ['DOWNLOAD_WITHOUT_NOTIFICATION', 'LOW', 'Silent downloads - suspicious behavior signal'],
        ['ACCESS_FINE_LOCATION', 'INFO', 'Precise GPS location - ensure proper justification'],
        ['ACCESS_COARSE_LOCATION', 'INFO', 'Approximate location - ensure proper justification'],
        ['READ_CALENDAR / WRITE_CALENDAR', 'INFO', 'Calendar access - ensure proper justification'],
        ['RECORD_AUDIO', 'INFO', 'Microphone access - ensure proper justification'],
        ['CAMERA', 'INFO', 'Camera access - ensure proper justification'],
        ['READ_EXTERNAL_STORAGE', 'INFO', 'File access - standard but review scope'],
        ['WRITE_EXTERNAL_STORAGE', 'INFO', 'File write - restricted to SDK < 30'],
        ['ACTIVITY_RECOGNITION', 'LOW', 'Physical activity detection - unclear purpose'],
    ]
    perm_table = Table(perm_data, colWidths=[170, 60, 230])
    perm_table.setStyle(TableStyle([
        ('BACKGROUND', (0, 0), (-1, 0), C_TABLE_HEADER),
        ('TEXTCOLOR', (0, 0), (-1, 0), white),
        ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, -1), 8),
        ('GRID', (0, 0), (-1, -1), 0.5, C_BORDER),
        ('VALIGN', (0, 0), (-1, -1), 'MIDDLE'),
        ('TOPPADDING', (0, 0), (-1, -1), 4),
        ('BOTTOMPADDING', (0, 0), (-1, -1), 4),
        ('LEFTPADDING', (0, 0), (-1, -1), 6),
    ] + [('BACKGROUND', (0, i), (-1, i), C_TABLE_ALT) for i in range(2, len(perm_data), 2)]))
    story.append(perm_table)

    story.append(Paragraph(
        """The READ_PHONE_STATE permission is particularly concerning as it provides access to device identifiers 
        (IMEI/MEID) and call state, which is rarely justified for a conversational AI application. Google Play 
        has increasingly rejected apps that request this permission without a clear and compelling use case. The 
        SYSTEM_ALERT_WINDOW permission allows the app to draw over other applications, which could be used for 
        tapjacking attacks if an attacker can inject content into the app. The DOWNLOAD_WITHOUT_NOTIFICATION 
        permission is a system-level permission that is typically only granted to system apps and signals potentially 
        stealthy behavior to both users and Google Play reviewers.""", style_body))

    # === SECTION 10: React Native / Expo ===
    story.append(Paragraph("10. React Native / Expo Specific Issues", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph("10.1 Expo OTA Update Security (MEDIUM)", style_h2))
    story.append(Paragraph(
        """The application has Expo Updates enabled with EXPO_UPDATES_CHECK_ON_LAUNCH set to ALWAYS and a 
        300-second launch wait time (5 minutes). The update URL points to https://u.expo.dev/0c01da2c-5409-459b-a106-98322e3d7076 
        on the production channel. While Expo includes code signing verification capabilities (CodeSigningConfiguration 
        is present in the codebase and an expo-root.pem certificate is bundled), the critical question is whether 
        code signing is actually enforced or if allowUnsignedManifests is set to true. If code signing is not 
        enforced, an attacker who can perform a MITM attack on the update connection (especially given the lack 
        of certificate pinning) could push malicious JavaScript updates that would execute in the app context 
        with full access to native capabilities including the camera, microphone, location, and all stored data.""",
        style_body))

    story.append(Paragraph("10.2 Microsoft Clarity Analytics (INFO)", style_h2))
    story.append(Paragraph(
        """The application includes the Microsoft Clarity analytics SDK (com.microsoft.clarity), which tracks 
        user sessions including WebView content and DOM mutations. The clarity.js file is present in the assets 
        directory. This tracking SDK captures detailed user interaction data that may include sensitive information 
        entered in WebViews, such as personal messages, health data, or financial information shared with the AI 
        assistant. Users should be clearly informed about this tracking through a privacy policy, and the app must 
        comply with applicable data protection regulations including GDPR, CCPA, and any regional privacy laws. 
        The inclusion of this SDK without clear disclosure could result in Google Play policy violations and 
        potential legal liability.""", style_body))

    story.append(Paragraph("10.3 Pairip License Verification (INFO)", style_h2))
    story.append(Paragraph(
        """The app includes Pairip license verification (com.pairip.licensecheck), which is Google Play's anti-piracy 
        mechanism. The LicenseActivity and LicenseContentProvider components are properly marked as exported="false". 
        The RSA public key for license verification is hardcoded in LicenseClient.java. While this is a public key 
        (not a private key) and is designed to be distributed, it can be used to analyze and potentially bypass the 
        license verification system. However, this is a standard component and the implementation follows Google's 
        recommended practices.""", style_body))

    # === SECTION 11: Complete Findings Summary ===
    story.append(Paragraph("11. Complete Findings Summary", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    all_findings = [
        {'severity': 'CRITICAL', 'category': 'Credential Leak', 'title': 'OpenAI API Key hardcoded in app.config', 'file': 'app.config'},
        {'severity': 'CRITICAL', 'category': 'Credential Leak', 'title': 'Anthropic API Key hardcoded in app.config', 'file': 'app.config'},
        {'severity': 'CRITICAL', 'category': 'Credential Leak', 'title': 'DeepSeek API Key hardcoded in app.config', 'file': 'app.config'},
        {'severity': 'CRITICAL', 'category': 'Credential Leak', 'title': 'Gemini API Key hardcoded in app.config', 'file': 'app.config'},
        {'severity': 'CRITICAL', 'category': 'SSL Bypass', 'title': 'HostnameVerifier accepts all hostnames', 'file': 'ReactNativeBlobUtilUtils.java'},
        {'severity': 'CRITICAL', 'category': 'Credential Leak', 'title': 'Facebook Client Token in plaintext', 'file': 'strings.xml'},
        {'severity': 'HIGH', 'category': 'Credential Leak', 'title': 'Google/Firebase API Key hardcoded', 'file': 'strings.xml'},
        {'severity': 'HIGH', 'category': 'Credential Leak', 'title': 'Facebook App ID and Client Token exposed', 'file': 'strings.xml'},
        {'severity': 'HIGH', 'category': 'Network Security', 'title': 'Missing network_security_config.xml', 'file': 'AndroidManifest.xml'},
        {'severity': 'HIGH', 'category': 'Exported Component', 'title': 'CropImageActivity exported without protection', 'file': 'AndroidManifest.xml'},
        {'severity': 'HIGH', 'category': 'WebView Security', 'title': 'Apple Sign-In WebView JS interface', 'file': 'SignInWebViewDialogFragment.java'},
        {'severity': 'HIGH', 'category': 'Data Exposure', 'title': 'android:allowBackup=true enabled', 'file': 'AndroidManifest.xml'},
        {'severity': 'HIGH', 'category': 'Credential Leak', 'title': 'Ramadan API Key hardcoded', 'file': 'app.config'},
        {'severity': 'HIGH', 'category': 'Credential Leak', 'title': 'Sentry DSN exposed', 'file': 'app.config'},
        {'severity': 'MEDIUM', 'category': 'Insecure Communication', 'title': 'No certificate pinning implemented', 'file': 'N/A'},
        {'severity': 'MEDIUM', 'category': 'Insecure Communication', 'title': 'HTTP URLs in production build', 'file': 'DevServerHelper.java'},
        {'severity': 'MEDIUM', 'category': 'WebView Security', 'title': 'RN WebView addJavascriptInterface', 'file': 'RNCWebView.java'},
        {'severity': 'MEDIUM', 'category': 'Credential Leak', 'title': 'Firebase config IDs exposed', 'file': 'strings.xml'},
        {'severity': 'MEDIUM', 'category': 'Debug Info', 'title': 'Dev support strings in release build', 'file': 'rn_dev_preferences.xml'},
        {'severity': 'MEDIUM', 'category': 'Path Traversal', 'title': 'Overly broad FileProvider paths', 'file': 'Multiple XML files'},
        {'severity': 'MEDIUM', 'category': 'Excessive Permissions', 'title': 'READ_PHONE_STATE permission', 'file': 'AndroidManifest.xml'},
        {'severity': 'MEDIUM', 'category': 'Update Security', 'title': 'Expo Updates - verify code signing', 'file': 'AndroidManifest.xml'},
        {'severity': 'MEDIUM', 'category': 'Credential Leak', 'title': 'GraphQL API URL exposed', 'file': 'app.config'},
        {'severity': 'MEDIUM', 'category': 'Tracking', 'title': 'Facebook SDK auto-tracking enabled', 'file': 'AndroidManifest.xml'},
        {'severity': 'MEDIUM', 'category': 'Credential Leak', 'title': 'Expo Project ID exposed', 'file': 'app.config'},
        {'severity': 'MEDIUM', 'category': 'Credential Leak', 'title': 'License RSA Public Key exposed', 'file': 'LicenseClient.java'},
        {'severity': 'LOW', 'category': 'Exported Component', 'title': 'CustomTabActivity exported (FB SDK)', 'file': 'AndroidManifest.xml'},
        {'severity': 'LOW', 'category': 'Excessive Permissions', 'title': 'SYSTEM_ALERT_WINDOW permission', 'file': 'AndroidManifest.xml'},
        {'severity': 'LOW', 'category': 'Suspicious Permission', 'title': 'DOWNLOAD_WITHOUT_NOTIFICATION', 'file': 'AndroidManifest.xml'},
        {'severity': 'LOW', 'category': 'Debug Exposure', 'title': 'Dev menu components in release', 'file': 'DevMenuDevToolsDelegate.java'},
        {'severity': 'LOW', 'category': 'Information Disclosure', 'title': 'Facebook App ID exposed', 'file': 'strings.xml'},
        {'severity': 'LOW', 'category': 'Excessive Permissions', 'title': 'ACTIVITY_RECOGNITION permission', 'file': 'AndroidManifest.xml'},
        {'severity': 'LOW', 'category': 'Credential Leak', 'title': 'Sentry verification token', 'file': 'verification.properties'},
        {'severity': 'INFO', 'category': 'Exported Component', 'title': 'FCM receivers (standard config)', 'file': 'AndroidManifest.xml'},
        {'severity': 'INFO', 'category': 'WebView Security', 'title': 'WebView secure defaults (positive)', 'file': 'RNCWebViewManagerImpl.java'},
        {'severity': 'INFO', 'category': 'Tracking', 'title': 'Microsoft Clarity analytics included', 'file': 'clarity.js'},
        {'severity': 'INFO', 'category': 'License', 'title': 'Pairip license verification (standard)', 'file': 'LicenseClient.java'},
    ]

    # Split into two tables if needed
    mid = len(all_findings) // 2 + 1
    story.append(make_finding_table(all_findings[:mid]))
    story.append(Spacer(1, 10))
    story.append(make_finding_table(all_findings[mid:]))

    # === SECTION 12: Priority Remediation ===
    story.append(Paragraph("12. Priority Remediation Plan", style_h1))
    story.append(HRFlowable(width="100%", thickness=1, color=C_BORDER, spaceAfter=10))

    story.append(Paragraph("12.1 Immediate Actions (Before Google Play Launch)", style_h2))
    story.append(Paragraph(
        """The following actions are <b>mandatory</b> and must be completed before publishing the application to 
        the Google Play Store. Failure to address these issues will expose the application to significant financial 
        risk, user data compromise, and potential Google Play policy violations.""", style_body))

    immediate_items = [
        "<b>Rotate ALL LLM API keys immediately</b> - The OpenAI, Anthropic, DeepSeek, and Gemini API keys are compromised and must be rotated. Generate new keys and do NOT embed them in the client-side code.",
        "<b>Move API keys to a secure backend</b> - All AI API calls should be proxied through your own backend server (e.g., the GraphQL API at app.willma.life). The client should never directly communicate with LLM providers.",
        "<b>Remove getUnsafeOkHttpClient()</b> - Delete or strictly gate behind build configuration the method that bypasses SSL hostname verification. This is a critical security vulnerability.",
        "<b>Rotate the Facebook Client Token</b> - The current token is exposed. Generate a new one and use the Facebook SDK's built-in token handling instead of hardcoding it.",
        '<b>Set android:allowBackup="false"</b> - Prevent extraction of app data via ADB backup. Also add android:fullBackupContent to explicitly control backup scope.',
        '<b>Set CropImageActivity exported="false"</b> - Prevent unauthorized apps from launching this activity.',
    ]
    for item in immediate_items:
        story.append(Paragraph(item, style_bullet, bulletText='\xe2\x80\xa2'))

    story.append(Paragraph("12.2 Short-term Actions (Within 1 Week)", style_h2))
    short_items = [
        "<b>Add network_security_config.xml</b> - Explicitly block cleartext traffic, define certificate pinning for API endpoints, and configure custom trust anchors.",
        "<b>Implement certificate pinning</b> - Use OkHttp CertificatePinner or Android Network Security Configuration to pin certificates for app.willma.life and other backend services.",
        "<b>Restrict Google API key</b> - In Google Cloud Console, restrict the API key to only the app's package name and SHA-1 fingerprint.",
        "<b>Narrow FileProvider paths</b> - Replace path=\".\" and path=\"/\" with specific subdirectories that need to be shared.",
        "<b>Remove READ_PHONE_STATE permission</b> - This permission is unnecessary for an AI assistant app and will trigger Google Play review concerns.",
        "<b>Verify Expo code signing enforcement</b> - Ensure CODE_SIGNING_ENABLED is true and unsigned manifests are rejected.",
    ]
    for item in short_items:
        story.append(Paragraph(item, style_bullet, bulletText='\xe2\x80\xa2'))

    story.append(Paragraph("12.3 Medium-term Actions (Within 1 Month)", style_h2))
    med_items = [
        "<b>Strip dev support code from release builds</b> - Configure ProGuard/R8 rules to remove React Native dev support code and strings from production builds.",
        "<b>Review and reduce permissions</b> - Audit all requested permissions and remove any that are not essential to the app's core functionality.",
        "<b>Add API rate limiting</b> - Implement rate limiting on all API endpoints to mitigate damage from any future key leakage.",
        "<b>Implement API key restrictions</b> - On all AI provider consoles, set up usage limits, allowed IP ranges, and billing alerts.",
        "<b>Review Microsoft Clarity integration</b> - Ensure compliance with privacy regulations and add clear disclosure in the privacy policy.",
        "<b>Remove DOWNLOAD_WITHOUT_NOTIFICATION</b> - This system-level permission will not be granted and signals suspicious behavior.",
    ]
    for item in med_items:
        story.append(Paragraph(item, style_bullet, bulletText='\xe2\x80\xa2'))

    # Build
    doc.build(story, onFirstPage=add_header_footer, onLaterPages=add_header_footer)
    print(f"Report generated: {OUTPUT_PDF}")


if __name__ == '__main__':
    build_report()
