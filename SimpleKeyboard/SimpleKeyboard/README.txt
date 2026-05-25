# Simple Keyboard — Build Instructions

## What this is
A custom Android keyboard (IME) with:
- Full QWERTY layout
- Shift, Delete, Enter, Space keys
- A HIDDEN search button at the end of the number row (after "0") — tap it to toggle Google inside the keyboard

---

## How to build the APK

### Step 1 — Install Android Studio
Download from: https://developer.android.com/studio
Install it normally. It includes everything you need (JDK, emulator, build tools).

### Step 2 — Open this project
1. Open Android Studio
2. Click "Open" (not "New Project")
3. Navigate to this folder (SimpleKeyboard) and click OK
4. Wait for Gradle to sync (takes 1-3 minutes first time)

### Step 3 — Build the APK
1. In the top menu: Build → Build Bundle(s) / APK(s) → Build APK(s)
2. Wait for it to finish
3. A popup will appear saying "APK generated" — click "locate" to find the file
4. The APK is at: app/build/outputs/apk/debug/app-debug.apk

### Step 4 — Install on your phone
Option A (USB):
1. Enable Developer Options on your phone: Settings → About Phone → tap Build Number 7 times
2. Enable USB Debugging: Settings → Developer Options → USB Debugging ON
3. Plug phone into PC via USB
4. In Android Studio: Run → Run 'app' (select your phone)

Option B (manual):
1. Copy app-debug.apk to your phone
2. Open it from your phone's file manager
3. Allow "Install from unknown sources" when prompted

### Step 5 — Set as default keyboard
1. Open the "Simple Keyboard" app on your phone
2. Tap "Step 1: Enable Keyboard" and toggle it ON
3. Tap "Step 2: Set as Default" and choose Simple Keyboard
4. Done! Open any app and the keyboard will appear

---

## Using the hidden search button
- It's the invisible button after "0" in the number row
- Tap it once → Google opens above the keyboard
- Tap it again → Google closes
