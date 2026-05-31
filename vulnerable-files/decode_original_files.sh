#!/bin/bash
# Decode the original vulnerable files
# Run this script to restore the original files with actual secret values
# Usage: bash decode_original_files.sh

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ENCODED_DIR="$SCRIPT_DIR/original-encoded"

echo "============================================"
echo "  WILLMA APK - Decode Original Secret Files"
echo "============================================"
echo ""
echo "WARNING: This will decode files containing REAL API keys and secrets."
echo "These secrets are ALREADY COMPROMISED by being in the APK."
echo "You MUST rotate all keys immediately after review."
echo ""
read -p "Continue? (yes/no): " confirm

if [ "$confirm" != "yes" ]; then
    echo "Aborted."
    exit 1
fi

echo ""
for f in "$ENCODED_DIR"/*.b64; do
    basename=$(basename "$f" .b64)
    output="$SCRIPT_DIR/$basename"
    echo "Decoding: $basename"
    base64 -d "$f" > "$output"
done

echo ""
echo "Done! Original files decoded to: $SCRIPT_DIR/"
echo ""
echo "REMEMBER: Rotate these compromised keys AFTER your security review:"
echo "  - OpenAI API Key"
echo "  - Anthropic API Key"  
echo "  - DeepSeek API Key"
echo "  - Gemini API Key"
echo "  - Facebook Client Token"
echo "  - Google/Firebase API Key"
echo "  - Ramadan API Key"
