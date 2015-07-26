export ANDROID_HOME=/Users/somkiat/data/software/android-sdk-macosx
./gradlew assembleDebug
cd calabash
cp ../app/build/outputs/apk/app-debug-unaligned.apk .
calabash-android resign app-debug-unaligned.apk
calabash-android run app-debug-unaligned.apk  --format json --out report.json --format pretty